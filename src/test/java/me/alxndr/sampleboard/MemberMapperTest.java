package me.alxndr.sampleboard;

import me.alxndr.sampleboard.board.Board;
import me.alxndr.sampleboard.board.BoardMapper;
import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardDto;
import me.alxndr.sampleboard.common.YnType;
import me.alxndr.sampleboard.member.Member;
import me.alxndr.sampleboard.member.MemberDto;
import me.alxndr.sampleboard.member.MemberMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
public class MemberMapperTest {

    @Test
    public void memberDtoToEntity() {
        MemberDto memberDto = MemberDto.builder()
                .id(1L)
                .username("test@grovesoft.net")
                .password("1234")
                .build();

        Member member = MemberMapper.INSTANCE.toEntity(memberDto);

        assertThat(member.getId()).isEqualTo(memberDto.getId());
        assertThat(member.getUsername()).isEqualTo(memberDto.getUsername());
        assertThat(member.getPassword()).isEqualTo(memberDto.getPassword());
    }

    @Test
    public void memberEntityToDto() {
        Member member = Member.builder()
                .id(1L)
                .username("test@grovesoft.net")
                .password("1234")
                .build();

        MemberDto memberDto = MemberMapper.INSTANCE.toDto(member);

        assertThat(memberDto.getId()).isEqualTo(member.getId());
        assertThat(memberDto.getUsername()).isEqualTo(member.getUsername());
        assertThat(memberDto.getPassword()).isEqualTo(member.getPassword());

    }


}
