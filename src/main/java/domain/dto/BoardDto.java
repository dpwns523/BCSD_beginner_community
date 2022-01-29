package domain.dto;

import annotation.ValidationGroups;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    /*
        TODO : board_hit - 조회수 추가
     */
    @NotNull(groups={ValidationGroups.board.class}, message = "제목을 입력하세요.")
    private String title;
    @NotNull(groups={ValidationGroups.board.class}, message = "내용을 입력하세요.")
    private String contents;
    @ApiModelProperty(hidden = true)
    private Long id;
    @ApiModelProperty(hidden = true)
    private Long member_id;
    @ApiModelProperty(hidden = true)
    private Timestamp created_at;
    @ApiModelProperty(hidden = true)
    private Timestamp updated_at;
    @ApiModelProperty(hidden = true)
    private List<BoardCommentDto> comments;

    @Override
    public String toString() {
        return "{ title : "
                +title
                +" contents : "
                +contents
                +"}";
    }
}
