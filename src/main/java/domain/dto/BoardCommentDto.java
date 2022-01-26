package domain.dto;

import annotation.ValidationGroups;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class BoardCommentDto {
    @NotNull(groups={ValidationGroups.board.class}, message = "게시판을 선택하세요.")
    private Long boardId;
    @NotNull(groups={ValidationGroups.board.class}, message = "별명을 입력하세요.")
    private String nickName;
    @NotNull(groups={ValidationGroups.board.class}, message = "내용을 입력하세요.")
    private String contents;

    @ApiModelProperty(hidden=true)
    private Long id;
    @ApiModelProperty(hidden=true)
    private Long memberId;
    @ApiModelProperty(hidden=true)
    private Timestamp createdAt;
    @ApiModelProperty(hidden=true)
    private Timestamp updatedAt;

    @Override
    public String toString() {
        return "{ name : "+
                nickName+
                " contents : "+
                contents+
                " }";
    }
}
