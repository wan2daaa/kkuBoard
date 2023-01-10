package wane.kkuboard.controller.route;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wane.kkuboard.entity.Board;
import wane.kkuboard.entity.Comment;
import wane.kkuboard.repository.BoardRepository;
import wane.kkuboard.repository.CommentRepository;
import wane.kkuboard.service.BoardService;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardRouteController {
    @Autowired
    BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;


    @RequestMapping()
    public String board(Model model) {
        List<Board> boardList = boardService.selectBoardList();
        model.addAttribute("boardList", boardList);

        return "board/board";
    }

    @RequestMapping("/view")
    public String boardView(@RequestParam(value = "boardIdx", required = false) Long boardIdx,
        Model model) {

        Board board = boardService.selectBoardViewAndIncreseView(boardIdx);
        Comment comment = boardService.selectCommentByBoardIdx(boardIdx);

        model.addAttribute("board", board);
        model.addAttribute("commentList", comment);

        return "board/board_view";
    }

    @RequestMapping("/write")
    public String boardWrite() {

        return "board/board_write";
    }

    @RequestMapping("/update")
    public String boardUpdate() {
        return "board.board_write";
    }

    /**
     * Todo 1. 글 작성 api 수정 -> JPA 학습 부족
     *
     */
    @PostMapping("/write")
    public String boardSave(Board board) {
//        Board save = boardRepository.save(board);
//        log.warn("board = {}", save.toString());

        return "redirect:/board";
    }

    @GetMapping("/delete")
    public String boardDelete(@RequestParam Long boardIdx) {

        boardRepository.deleteById(boardIdx);

        return "redirect:/board";
    }

}
