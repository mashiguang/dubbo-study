package cn.niceabc.dubbo.async;

import java.util.concurrent.TimeUnit;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5L);
        return "Hello " + name;
    }

    public String sayHi(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10L);
        return "Hi " + name;
    }
}
