package cn.niceabc.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
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
