package me.alxndr.sampleboard.board;

import lombok.*;
import lombok.Builder.Default;
import me.alxndr.sampleboard.board.dto.BoardCreateDto;
import me.alxndr.sampleboard.board.dto.BoardUpdateDto;
import me.alxndr.sampleboard.common.YnType;
import me.alxndr.sampleboard.member.Member;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String content;

    @Default
    private int views = 0;

    private YnType isPinned;

    @Default
    @Enumerated(EnumType.STRING)
    private YnType isDeleted = YnType.N;

    @Default
    @Enumerated(EnumType.STRING)
    private YnType isPublished = YnType.Y;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public static Board create(BoardCreateDto dto, Member member) {
        return Board.builder()
                .member(member)
                .title(dto.getTitle())
                .content(dto.getContent())
                .isPinned(dto.getIsPinned())
                .isPublished(dto.getIsPublished())
                .build();
    }

    public void updateBoard(BoardUpdateDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.isPinned = dto.getIsPinned();
        this.isPublished = dto.getIsPublished();
    }

}
