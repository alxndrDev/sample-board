package me.alxndr.sampleboard.board;

import lombok.*;
import lombok.Builder.Default;
import me.alxndr.sampleboard.common.YnType;
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

}
