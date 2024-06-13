package com.miris.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miris.test.modle.Board;



@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	void deleteById(Long id);
	@Query("select m from Board m where m.id = :id")
	Optional<Board> findById(@Param("id") Long id);

}