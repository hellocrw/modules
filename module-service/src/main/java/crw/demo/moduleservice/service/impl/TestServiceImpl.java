package crw.demo.moduleservice.service.impl;

import crw.demo.moduleservice.service.TestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    private String port = "2000";

    @Override
    public String port() {
        return port;
    }
}
