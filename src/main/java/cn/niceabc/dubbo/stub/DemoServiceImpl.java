package cn.niceabc.dubbo.stub;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) throws Exception {
        if ("World".equals(name))
            throw new Exception("no World.");
        return "Hello " + name;
    }
}
