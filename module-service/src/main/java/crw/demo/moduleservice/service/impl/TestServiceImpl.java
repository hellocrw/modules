package crw.demo.moduleservice.service.impl;

import crw.demo.model.entity.Test;
import crw.demo.moduleservice.service.TestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    private String port = "2000";

    @Override
    public String port() {
        Test test = new Test();
        test.setId("1");
        test.setName("张三");
        System.out.println(test.toString());
        return port;
    }
}
