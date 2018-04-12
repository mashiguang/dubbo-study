package cn.niceabc.dubbo.simple;

import com.alibaba.dubbo.rpc.service.EchoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"simple/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理

        String hello = null; // 执行远程方法
        try {
            hello = demoService.sayHello("World");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println( hello ); // 显示调用结果

    }
}
