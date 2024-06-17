package com.miris.test.exception;

import org.springframework.http.HttpStatus;

import com.miris.test.dto.ResultDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @FileName : BaseException.java

 * @작성자 : yg

 * @작성일 : 2024. 6. 14. 

 * @프로그램 설명 : 

 * @변경이력 :
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
	
	private final ErrorCode errorCode;

 
}
