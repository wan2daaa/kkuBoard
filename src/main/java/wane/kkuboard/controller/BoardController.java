package wane.kkuboard.controller;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wane.kkuboard.dto.CommentDTO;
import wane.kkuboard.entity.Board;
import wane.kkuboard.entity.Comment;
import wane.kkuboard.repository.BoardRepository;
import wane.kkuboard.repository.CommentRepository;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping()
    public String board(Model model) {
        List<Board> boardList = boardRepository.findAll();

        model.addAttribute("boardList", boardList);

        return "board/board";
    }

    @RequestMapping("/view")
    public String boardView(@RequestParam(value = "boardIdx", required = false) Long boardIdx,
        Model model) {

        boardRepository.updateView(boardIdx);

        Optional<Board> boardDetail = boardRepository.findById(boardIdx);
        Optional<Comment> commentsList = commentRepository.findByBoard_BoardIdx(boardIdx);
        if (!boardDetail.isPresent()) {
            throw new IllegalArgumentException();
        }else {
            model.addAttribute("board", boardDetail.get());

            if (commentsList.isPresent()) {
                model.addAttribute("commentList", commentsList);
            }

            return "board/board_view";
        }



    }

    @RequestMapping("/write")
    public String boardWrite() {

        return "board/board_write";
    }

    @RequestMapping("/update")
    public String boardUpdate() {
        return "board.board_write";
    }


    @PostMapping("/write")
    public String boardSave(Board board) {
        Board save = boardRepository.save(board);
        log.warn("board = {}", save.toString());

        return "redirect:/board";
    }

    @GetMapping("/delete")
    public String boardDelete(@RequestParam Long boardIdx) {

        boardRepository.deleteById(boardIdx);

        return "redirect:/board";
    }

//    @PostMapping(value = "/comment/insert", produces = "application/json")
    @PostMapping(value = "/comment/insert" )
    @ResponseBody
    public String commentInsert(@RequestBody CommentDTO commentDTO){

        Long boardIdx = commentDTO.getBoardIdx();

        Board findBoard = boardRepository.findById(boardIdx)
            .orElseThrow(() -> new RuntimeException("boardNotFound"));




        return "asd";
    }
}
