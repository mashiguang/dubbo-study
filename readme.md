http://dubbo.apache.org/books/dubbo-user-book/

问题列表：
1. consumer.xml中配置了retries=2，但cn.niceabc.dubbo.Consumer在执行过程中并没有重试。

    timeout会触发retry.使用timout后这样提示：
    
        com.alibaba.dubbo.rpc.RpcException: Failed to invoke the method sayHello in the service cn.niceabc.dubbo.simple.DemoService. Tried 4 times of the providers [192.168.1.233:20880] (1/1) from the registry 224.5.6.7:1234 on the consumer 192.168.1.233 using the dubbo version 2.0.1. Last error is: Invoke remote method timeout.
    
    异常不会触发retry? 异常后这样提示：
    
        java.lang.Exception: no World.
        	at cn.niceabc.dubbo.simple.DemoServiceImpl.sayHello(DemoServiceImpl.java:8)
        	at com.alibaba.dubbo.common.bytecode.Wrapper1.invokeMethod(Wrapper1.java)
        	at com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory$1.doInvoke(JavassistProxyFactory.java:45)
 
2. prodiver端抛出异常后，consumer端拦截到，但为什么异常信息里会有XxxImpl这样的信息？异常里有实现类相关的信息

        cn.niceabc.dubbo.event
        java.lang.Exception: no World.
    	    at cn.niceabc.dubbo.event.DemoServiceImpl.sayHello(DemoServiceImpl.java:6)
    	    at com.alibaba.dubbo.common.bytecode.Wrapper1.invokeMethod(Wrapper1.java)
    	    at com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory$1.doInvoke(JavassistProxyFactory.java:45)
    	    ......
3. Stub应该是consumer端的概念，但为什么文档示例代码中，把stub配置在了provider上。

        http://dubbo.apache.org/books/dubbo-user-book/demos/local-stub.html
    
    同问题4
    
4. 只在provider端配了token，consumer就可以用上这个token，怎么做到的？
   
   如http://dubbo.apache.org/books/dubbo-user-book/references/xml/introduction.html
   所说，provider端所有配置都会生成到url，经由注册中心转播给consumer端。

5. zookeeper

        docker run --name some-zookeeper --restart always -d -p 0.0.0.0:2181:2181 -p 0.0.0.0:2888:2888 -p 0.0.0.0:3888:3888 zookeeper