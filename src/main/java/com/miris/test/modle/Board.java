package com.miris.test.modle;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Board {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id

    private String title; //제목

    private String content; //내용
}
