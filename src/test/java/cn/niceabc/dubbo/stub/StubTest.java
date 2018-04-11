package cn.niceabc.dubbo.stub;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StubTest {

    private static Logger log = LoggerFactory.getLogger(StubTest.class);

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"stub/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

        // 异步调用
        // provider.xml中要配置timeout，不然这里会超时失败。

        String hello = demoService.sayHello("niceabc");
        log.info("{}", hello);

    }
}
