package wane.kkuboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@NoArgsConstructor
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue
    private Long comIdx;

    @OneToOne
    @JoinColumn(name = "board_idx")
    private Board board;

    private String comContents;

    private String comWriter;

    @ColumnDefault("0")
    private Integer comLikes;

}
