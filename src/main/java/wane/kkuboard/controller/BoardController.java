package wane.kkuboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping()
    public String board() {
        return "board/board";
    }

    @RequestMapping("/view")
    public String boardView() {
        return "board/board_view";
    }

    @RequestMapping("/write")
    public String boardWrite() {
        return "board/board_write";
    }

    @RequestMapping("/update")
    public String boardUpdate() {return "board.board_write";}
}
