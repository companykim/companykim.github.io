package www.dream.bbs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.News.model.NewsVO;
import www.dream.bbs.board.model.BoardVO;
import www.dream.bbs.board.service.BoardService;
import www.dream.bbs.webclient.WebClient4News;

@RestController		//Container에 담기도록 지정
@RequestMapping("/xxx")
public class BoardController2 {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private WebClient4News webClient4News;
	
	@GetMapping("/anonymous/listxxxyyy/{word1}/{word2}")
	public ResponseEntity<String> searchedNews(@PathVariable String word1, @PathVariable String word2) {
		System.out.println(word1);
		return new ResponseEntity<>("대통령", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoardVO> findById(@PathVariable String id) {
		BoardVO board = boardService.findById(id);
		return ResponseEntity.ok(board);
	}
}
