package domain.dto;

import common.Constants;
import common.exception.MyException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardPaginationDto {

    private int page;           // 현재 페이지
    @ApiModelProperty(hidden = true)
    private int range = 10;     // 한 페이지당 게시글 개수
    @ApiModelProperty(hidden = true)
    private int listCnt;        // 총 게시글 수
    @ApiModelProperty(hidden = true)
    private int pageCnt;        // 총 페이지 수
    @ApiModelProperty(hidden = true)
    private int start;          // 현재 페이지 게시글의 시작 번호
    @ApiModelProperty(hidden = true)
    private int end;            // 현재 페이지 게시글의 마지막 번호
    @ApiModelProperty(hidden = true)
    private List<BoardDto> boardList;

    // 페이지를 선택할 때 호출될 메소드
    public void setPageInfo(int page, int listCnt) throws MyException {
        this.page = page;
        this.listCnt = listCnt;
        this.pageCnt = (int) Math.ceil(listCnt/range);
        this.start = (this.page-1)*range;
        this.end = (this.page*range) -1;

        if(page > pageCnt) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "게시글이 존재하지 않습니다.");
    }

}
