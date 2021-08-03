package me.alxndr.sampleboard.board.dto;

import lombok.*;
import me.alxndr.sampleboard.common.YnType;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardCreateDto {

    private String title;

    private String content;

    private YnType isPinned;

    private YnType isPublished;

}
