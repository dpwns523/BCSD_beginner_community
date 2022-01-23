package service;

import domain.dto.TestDto;
import response.BaseResponse;

public interface TestService {
    BaseResponse test(TestDto testDto) throws Exception;
}
