package com.miris.test.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ErrorCode {
	
	/* 400 BAD_REQUEST : 잘못된 요청 */
	ACCOUNT_NOT_FOUND(HttpStatus.BAD_REQUEST, "계정 정보를 찾을 수 없습니다."),
	INVALID_SESSION(HttpStatus.BAD_REQUEST, "세션키가 만료되었습니다."),
	;
	private HttpStatus status;
	private final String message;
	
}