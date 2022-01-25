package repository;

import domain.dto.BoardDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import response.BaseResponse;

@Repository
public interface BoardMapper {
    void createBoard(@Param(value="member_id") Long id, @Param(value="nick_name")String nickName, @Param(value = "boardDto") BoardDto boardDto);

    BoardDto getBoard(@Param(value="id")Long boardId);

    BaseResponse updateBoard(@Param("boardDto")BoardDto boardDto);

    BaseResponse deleteBoard(@Param("boardId")Long boardId);

}
