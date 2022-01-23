package repository;

import domain.dto.TestDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
    String getTime();
    void test(@Param(value = "testDto")TestDto testDto);
}
