package me.alxndr.sampleboard.board;

import lombok.RequiredArgsConstructor;
import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardDto;
import me.alxndr.sampleboard.board.dto.BoardUpdateDto;
import me.alxndr.sampleboard.member.Member;
import me.alxndr.sampleboard.member.MemberRepository;
import me.alxndr.sampleboard.member.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberService memberService;

    public BoardDto findBoard(Long id) {
        Board board = getBoard(id);
        BoardDto boardDto = BoardMapper.INSTANCE.toDto(board);
        return boardDto;
    }

    public Board createBoard(BoardCreateDto dto) {

        Member member = memberService.getMember(1L);

        Board board = Board.create(dto, member);
        Board savedBoard = boardRepository.save(board);


        return savedBoard;
    }

    @Transactional
    public Board updateBoard(BoardUpdateDto dto) {
        Board board = getBoard(dto.getId());

        board.updateBoard(dto);

        return board;
    }

    public Board getBoard(Long id) {
        Optional<Board> foundBoard = boardRepository.findById(id);
        Board board = foundBoard.orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
        return board;
    }


}
