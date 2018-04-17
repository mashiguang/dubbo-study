package cn.niceabc.dubbo.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"redis/provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}