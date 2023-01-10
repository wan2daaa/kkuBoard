package wane.kkuboard.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "board")
@Data
@ToString
@DynamicInsert
@NoArgsConstructor
public class Board extends BaseEntity{

    @Id
    @GeneratedValue
    private Long boardIdx;

    @Column(nullable = true)
    private String boardTitle;

    private String boardWriter;

    @ColumnDefault("0")
    private Long boardLikes;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "board_id")
    private Comment comment;

    @ColumnDefault("0")
    private String boardComments;

    @ColumnDefault("0")
    private Long boardViews;

    private String boardPhoto;

    private String boardContents;

    public Board(Long boardIdx) {
        this.boardIdx = boardIdx;
    }
}
