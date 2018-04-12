http://dubbo.apache.org/books/dubbo-user-book/

问题列表：
1. consumer.xml中配置了retries=2，但cn.niceabc.dubbo.Consumer在执行过程中并没有重试。
2. prodiver端抛出异常后，consumer端拦截到，但为什么异常信息里会有XxxImpl这样的信息？

        cn.niceabc.dubbo.event
        java.lang.Exception: no World.
    	    at cn.niceabc.dubbo.event.DemoServiceImpl.sayHello(DemoServiceImpl.java:6)
    	    at com.alibaba.dubbo.common.bytecode.Wrapper1.invokeMethod(Wrapper1.java)
    	    at com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory$1.doInvoke(JavassistProxyFactory.java:45)
    	    ......
3. Stub应该是consumer端的概念，但为什么文档示例代码中，把stub配置在了provider上。

        http://dubbo.apache.org/books/dubbo-user-book/demos/local-stub.html
    
    >同问题4
    
4. 只在provider端配了token，consumer就可以用上这个token，怎么做到的？
    >如http://dubbo.apache.org/books/dubbo-user-book/references/xml/introduction.html
    所说，provider端所有配置都会生成到url，经由注册中心转播给consumer端。