package wane.kkuboard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDTO {

    private Long comIdx;

    private Long boardIdx;

    private String comContents;

    private String comWriter;

    private Integer comLikes;


}
