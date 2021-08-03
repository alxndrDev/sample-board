package me.alxndr.sampleboard.board;

import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    Board createDtoToEntity(BoardCreateDto dto);

    Board toEntity(BoardDto dto);

    BoardDto toDto(Board board);

}
