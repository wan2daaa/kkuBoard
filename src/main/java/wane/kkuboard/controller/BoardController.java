package wane.kkuboard.controller;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wane.kkuboard.entity.Board;
import wane.kkuboard.repository.BoardRepository;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @RequestMapping()
    public String board(Model model) {
        List<Board> boardList = boardRepository.findAll();

        model.addAttribute("boardList", boardList);

        return "board/board";
    }

    @RequestMapping("/view")
    public String boardView(@RequestParam(value = "boardIdx", required = false) Long boardIdx ) {
//        log.warn("boarIdx : {}", boardIdx);
        Optional<Board> boardView = boardRepository.findById((long) boardIdx);
        log.warn("boardView : {}", boardView);

        return "board/board_view";
    }

    @RequestMapping("/write")
    public String boardWrite() {

        return "board/board_write";
    }

    @RequestMapping("/update")
    public String boardUpdate() {return "board.board_write";}


    @PostMapping("/write")
    public String boardSave(Board board) {
        Board save = boardRepository.save(board);
        log.warn("board = {}" , save.toString());

        return "redirect:/board";
    }

}
