package cn.niceabc.dubbo.zookeeper;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZookeeperTest {
    private static Logger log = LoggerFactory.getLogger(ZookeeperTest.class);

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"zookeeper/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理

        String hello = null; // 执行远程方法
        try {
            hello = demoService.sayHello("niceabc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{}", hello);

    }
}
