package com.miris.test.dto;

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
	
	private int status;
	
	private String path;
	
	private String error;
	
	private String message;
	
	private String errorDt;
	
	private String errorTm;
}
