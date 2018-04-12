package cn.niceabc.dubbo.simple;

import java.util.concurrent.TimeUnit;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) throws Exception {
        if ("World".equals(name))
            throw new Exception("no World.");
        TimeUnit.SECONDS.sleep(10);
        return "Hello " + name;
    }
}
