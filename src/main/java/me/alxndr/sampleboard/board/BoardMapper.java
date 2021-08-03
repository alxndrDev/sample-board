package me.alxndr.sampleboard.board;

import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "views", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Board toEntity(BoardCreateDto dto);

    Board toEntity(BoardDto dto);

    BoardDto toDto(Board board);

}
