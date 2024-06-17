package com.miris.test.dto;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.miris.test.exception.CustomException;
import com.miris.test.exception.ErrorCode;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @FileName : ErrorDto.java

 * @작성자 : yg

 * @작성일 : 2024. 6. 13. 

 * @프로그램 설명 : 오류 데이터 클래스 

 * @변경이력 :
 */
@Builder
@Data
public class ErrorDto {
	
	private final LocalDateTime timestamp = LocalDateTime.now();
	private int status;
	private String error;
	private String message;

	public static ResponseEntity<ErrorDto>  toResponseEntity(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ErrorDto.builder()
                        .status(errorCode.getStatus().value())
                        .message(errorCode.getMessage())
                        .build()
                );
    }
}
