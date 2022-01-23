package service.impl;

import domain.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.TestMapper;
import response.BaseResponse;
import service.TestService;

@Service
public class TestServiceImpl implements TestService {
    private TestMapper testMapper;

    @Autowired
    public TestServiceImpl(TestMapper testMapper){
        this.testMapper =testMapper;
    }

    @Override
    public BaseResponse test(TestDto testDto) throws Exception {
        testMapper.test(testDto);
        return new BaseResponse("DB연동 테스트 성공", HttpStatus.OK);
    }
}
