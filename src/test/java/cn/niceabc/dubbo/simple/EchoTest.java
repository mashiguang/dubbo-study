package cn.niceabc.dubbo.simple;

import cn.niceabc.dubbo.simple.DemoService;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EchoTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"simple/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理

        EchoService echoService = (EchoService) demoService;

        String status = (String) echoService.$echo("OK");
        Assert.assertEquals("OK", status);

    }
}
