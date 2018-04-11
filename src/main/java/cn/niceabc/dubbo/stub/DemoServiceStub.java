package cn.niceabc.dubbo.stub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceStub implements DemoService{

    private static Logger log = LoggerFactory.getLogger(DemoServiceStub.class);

    private final DemoService demoService;

    public DemoServiceStub(DemoService demoService) {
        this.demoService = demoService;
    }

    public String sayHello(String name) throws Exception {
        log.info("i'm in a stub.");
        return demoService.sayHello(name)+ " from stub.";
    }
}
