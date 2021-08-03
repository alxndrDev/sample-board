package me.alxndr.sampleboard.board.dto;

import lombok.*;
import me.alxndr.sampleboard.common.YnType;
import org.hibernate.type.YesNoType;

import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BoardDto {

    private Long id;

    private String title;

    private String content;

    private int views;

    private YnType isPinned;

    private YnType isDeleted;

    private YnType isPublished;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
