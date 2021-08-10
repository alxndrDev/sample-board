package me.alxndr.sampleboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.common.YnType;
import me.alxndr.sampleboard.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void createTest() throws Exception {

        BoardCreateDto createDto = BoardCreateDto.builder()
                .title("Test Board")
                .content("Test Content")
                .isPinned(YnType.N)
                .isPublished(YnType.Y)
                .build();

        String content = objectMapper.writeValueAsString(createDto);

        System.out.println("content = " + content);

        mockMvc.perform(post("/api/board")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }


}
