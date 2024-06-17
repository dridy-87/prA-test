package com.miris.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miris.test.aop.annotation.MeasureTime;
import com.miris.test.exception.CustomException;
import com.miris.test.exception.ErrorCode;
import com.miris.test.modle.Board;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @FileName : ErrorController.java

 * @작성자 : yg

 * @작성일 : 2024. 6. 14. 

 * @프로그램 설명 : 강제에러 처리 테스트

 * @변경이력 :
 */
@Slf4j
@RestController
@RequestMapping("/api/error")
public class ErrorController {
	
	@GetMapping("/runtimeException")
	@MeasureTime
	public String runtime() {
		throw new RuntimeException("This is a forced RuntimeException");
		
	}
	
	@GetMapping("/exception")
	@MeasureTime
	public String exception() throws Exception {
		throw new Exception();
	}
	
	@GetMapping("/invaildSession")
	@MeasureTime
	public String invaildSession() throws CustomException {
		throw new CustomException(ErrorCode.INVALID_SESSION);
	}
	
	@GetMapping("/notFound")
	@MeasureTime
	public String notFound() throws CustomException {
		throw new CustomException(ErrorCode.ACCOUNT_NOT_FOUND);
	}

}
