package me.alxndr.sampleboard.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.alxndr.sampleboard.common.YnType;
import org.hibernate.type.YesNoType;

import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BoardDto {

    private Long id;

    private String title;

    private String content;

    private int views;

    private YnType pinnedYn;

    private YnType isDeleted;

    private YnType isPublished;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
