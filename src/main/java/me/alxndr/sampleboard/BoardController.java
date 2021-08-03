package me.alxndr.sampleboard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.alxndr.sampleboard.board.Board;
import me.alxndr.sampleboard.board.BoardService;
import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardDto;
import me.alxndr.sampleboard.board.dto.BoardUpdateDto;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<BoardDto> getBoard(@RequestParam("id") Long id) {
        BoardDto board = boardService.findBoard(id);

        return ResponseEntity.ok().body(board);
    }

    @PostMapping
    public ResponseEntity createBoard(@RequestBody BoardCreateDto dto) {

        Board board = boardService.createBoard(dto);

        URI uri = linkTo(BoardController.class).slash(board.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity updateBoard(@RequestBody BoardUpdateDto dto) {
        Board board = boardService.updateBoard(dto);

        URI uri = linkTo(BoardController.class).slash(board.getId()).toUri();
        return ResponseEntity.ok().location(uri).build();
    }

}
