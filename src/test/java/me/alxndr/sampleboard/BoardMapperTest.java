package me.alxndr.sampleboard;

import me.alxndr.sampleboard.board.Board;
import me.alxndr.sampleboard.board.BoardMapper;
import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardDto;
import me.alxndr.sampleboard.common.YnType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
public class BoardMapperTest {

    @Test
    public void createBoardDtoToEntityTest() {
        BoardCreateDto dto = BoardCreateDto.builder()
                .title("Test")
                .content("Test Content")
                .isPublished(YnType.Y)
                .isPinned(YnType.Y)
                .build();

        Board board = BoardMapper.INSTANCE.toEntity(dto);

        assertThat(board.getTitle()).isEqualTo(dto.getTitle());
        assertThat(board.getContent()).isEqualTo(dto.getContent());
        assertThat(board.getIsPublished()).isEqualTo(dto.getIsPublished());
        assertThat(board.getIsPinned()).isEqualTo(dto.getIsPinned());

    }

    @Test
    public void boardEntityToDto() {
        Board board = Board.builder()
                .id(1L)
                .title("Test Title")
                .content("Test Content")
                .isDeleted(YnType.N)
                .isPublished(YnType.Y)
                .isPinned(YnType.Y)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BoardDto boardDto = BoardMapper.INSTANCE.toDto(board);

        assertThat(boardDto.getId()).isEqualTo(board.getId());
        assertThat(boardDto.getTitle()).isEqualTo(board.getTitle());

    }


}
