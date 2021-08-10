package me.alxndr.sampleboard.member;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : Alexander Choi
 * @date : 2021/08/10
 */
@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member toEntity(MemberDto member);

    MemberDto toDto(Member member);

}
