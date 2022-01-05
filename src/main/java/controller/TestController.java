package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.TestMapper;

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

    @ResponseBody
    @RequestMapping(value ="/gettime", method=RequestMethod.GET)
    public String test(){
        System.out.println(testMapper.getTime());
        return "hello";
    }


}
