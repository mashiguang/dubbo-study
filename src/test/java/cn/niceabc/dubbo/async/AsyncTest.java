package cn.niceabc.dubbo.async;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncTest {

    private static Logger log = LoggerFactory.getLogger(AsyncTest.class);

    @Test
    public void test() throws InterruptedException, ExecutionException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"async/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

        // 异步调用
        // provider.xml中要配置timeout，不然这里会超时失败。

        demoService.sayHello("5 seconds.");
        Future<String> sayHelloFuture = RpcContext.getContext().getFuture();

        demoService.sayHi("10 seconds.");
        Future<String> sayHiFuture = RpcContext.getContext().getFuture();

        String sayHello = sayHelloFuture.get();
        log.info("sayHello: {}", sayHello);

        String sayHi = sayHiFuture.get();
        log.info("sayHi: {}", sayHi);

    }
}
