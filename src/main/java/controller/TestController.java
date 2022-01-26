package controller;


import domain.dto.TestDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.TestMapper;
import service.TestService;

@Controller
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
    @ResponseBody
    @RequestMapping(value = "/hellotest2", method = RequestMethod.GET)
    public String hellotest2(){
        return "hello";
    }

    // Mybatis Test
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping(value ="/gettime", method=RequestMethod.GET)
    public String test(){
        System.out.println(testMapper.getTime());
        return "hello";
    }
    //Mapper Test
    @RequestMapping(value="test", method = RequestMethod.POST)
    @ApiOperation(value="Mapper Test", notes ="DB Test")
    public ResponseEntity test(@RequestBody TestDto testDto)throws Exception{
        return new ResponseEntity((testService.test(testDto)), HttpStatus.OK);
    }
}
