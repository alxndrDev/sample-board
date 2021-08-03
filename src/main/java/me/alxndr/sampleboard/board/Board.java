package me.alxndr.sampleboard.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Getter
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

    private YnType pinedYn;

    @Enumerated(EnumType.STRING)
    private YnType isDeleted;

    @Enumerated(EnumType.STRING)
    private YnType isPublished;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
