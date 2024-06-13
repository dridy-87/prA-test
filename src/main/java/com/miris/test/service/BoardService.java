package com.miris.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miris.test.modle.Board;
import com.miris.test.repository.BoardRepository;



@Service
public class BoardService {
	@Autowired
    private BoardRepository boardRepository;
	
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	 public Optional<Board>  findById(Long id) {
        return boardRepository.findById(id);
    }

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
