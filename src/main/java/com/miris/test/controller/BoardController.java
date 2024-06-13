package com.miris.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miris.test.aop.annotation.MeasureTime;
import com.miris.test.exception.ErrorCode;
import com.miris.test.modle.Board;
import com.miris.test.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/{id}")
    public Optional<Board> getBoard(@PathVariable Long id) {
        return boardService.findById(id);
    }
	
	@GetMapping("/boards")
	@MeasureTime
	public List<Board> getBoards() {
//		throw new RuntimeException("This is a forced RuntimeException");
		return boardService.findAll();
	}
	
	@PostMapping("/board/add")
	public Board addBoard(@RequestBody Board board) {
		return boardService.save(board);
	}
	
	@PostMapping("/board/update")
	public Board updateBoard(@RequestBody Board board) {
		return boardService.save(board);
	}
}