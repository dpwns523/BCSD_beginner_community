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
    /*
        TODO : 댓글 작성자의 닉네임을 contents와 같이 출력하고자 함.
         memberId로 DB를 다시 접근 vs sql의 join활용
     */
    @Override
    public String toString() {
        return "{ contents : "+
                contents+
                " }";
    }
}
