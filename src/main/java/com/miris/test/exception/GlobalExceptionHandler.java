package com.miris.test.exception;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.utils.DateUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.miris.test.dto.ErrorDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName : testErrorControllerAdvice.java

 * @작성자 : yg87.kim

 * @작성일 : 2024. 06. 13

 * @프로그램 설명 : Controller Advice 클래

 * @변경이력 :
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorDto> handleRuntimeException(CustomException ex){
		return setError(ex.getErrorCode());
	}
	

	/**
	 * 
	 * @Method Name : handleRuntimeException
	
	 * @작성자 : yg87.kim
	
	 * @작성일 : 2024. 06. 13
	
	 * @프로그램 설명 : RuntimeException handler
	
	 * @변경이력 :
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDto> handleRuntimeException(HttpServletRequest request, HttpServletResponse response, Exception ex){
		return setError(request, response, ex);
	}
	
	/**
	 * 
	 * @Method Name : handleException
	
	 * @작성자 : yg87.kim
	
	 * @작성일 : 2024. 06. 13
	
	 * @프로그램 설명 : Exception Handler
	
	 * @변경이력 :
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		return setError(request, response, ex);
	}
	
	
	/**
	 * @Method Name : setError
	
	 * @작성자 : yg87.kim
	
	 * @작성일 : 2024. 06. 13
	
	 * @프로그램 설명 : 오류 설정 
	
	 * @변경이력 :
	 */
	private ResponseEntity<ErrorDto> setError(HttpServletRequest request, HttpServletResponse response,
			Exception ex) {
		// TODO Auto-generated method stub
		
		 LocalTime now = LocalTime.now(); 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");         
		 String formatedNow = now.format(formatter);            
		 
		 ErrorDto errorDto = ErrorDto.builder()
					 .message(ex.getMessage())
					 .build();

		 log.info("global ::::");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
	}
	
	private ResponseEntity<ErrorDto> setError(ErrorCode errorCode) {
		// TODO Auto-generated method stub
		log.info("custom ::::");
		return ErrorDto.toResponseEntity(errorCode);
	}
}
