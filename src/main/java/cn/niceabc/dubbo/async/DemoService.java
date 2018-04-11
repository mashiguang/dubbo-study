package cn.niceabc.dubbo.async;

public interface DemoService {
    String sayHello(String name) throws InterruptedException;

    String sayHi(String name) throws InterruptedException;
}
