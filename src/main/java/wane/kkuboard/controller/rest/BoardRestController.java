package wane.kkuboard.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wane.kkuboard.dto.CommentDTO;
import wane.kkuboard.entity.Board;
import wane.kkuboard.repository.BoardRepository;
import wane.kkuboard.repository.CommentRepository;
import wane.kkuboard.service.BoardService;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardRestController {

    @Autowired
    BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping(value = "/comment/insert" )
    public String commentInsert(@RequestBody CommentDTO commentDTO){

        Long boardIdx = commentDTO.getBoardIdx();

        Board findBoard = boardRepository.findById(boardIdx)
            .orElseThrow(() -> new RuntimeException("boardNotFound"));



        return "asd";
    }
}
