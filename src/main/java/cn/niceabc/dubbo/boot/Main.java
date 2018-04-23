package cn.niceabc.dubbo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@Configuration
@PropertySource("classpath:boot/application.properties")
@ImportResource("classpath:boot/provider.xml")
public class Main {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);

        System.in.read();
    }
}
