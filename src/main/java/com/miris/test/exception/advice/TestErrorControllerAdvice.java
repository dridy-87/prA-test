package com.miris.test.exception.advice;

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
public class TestErrorControllerAdvice {
	
	/**
	 * 
	 * @Method Name : handleRuntimeException
	
	 * @작성자 : yg87.kim
	
	 * @작성일 : 2024. 06. 13
	
	 * @프로그램 설명 : RuntimeException handler
	
	 * @변경이력 :
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntimeException(HttpServletRequest request, HttpServletResponse response, Exception ex){
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
	public ResponseEntity<Map<String, Object>> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		return setError(request, response, ex);
	}
	
	
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDeniedException(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        return setError(request, response, e);
    }
	

	/**
	 * @Method Name : setError
	
	 * @작성자 : yg87.kim
	
	 * @작성일 : 2024. 06. 13
	
	 * @프로그램 설명 : 오류 설정 
	
	 * @변경이력 :
	 */
	private ResponseEntity<Map<String, Object>> setError(HttpServletRequest request, HttpServletResponse response,
			Exception ex) {
		// TODO Auto-generated method stub
		
		 LocalTime now = LocalTime.now(); 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");         
		 String formatedNow = now.format(formatter);            
		 
		 ErrorDto errorDto = ErrorDto.builder()
					 .path(request.getRequestURI())
					 .message(ex.getMessage())
					 .errorTm(formatedNow)
					 .build();

		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("path", errorDto.getPath());
		model.put("status", errorDto.getStatus());
		model.put("error", errorDto.getError());
		model.put("message", errorDto.getMessage());
		model.put("regDt", errorDto.getErrorDt());
		model.put("regTm", errorDto.getErrorTm());
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(model);
	}
}
