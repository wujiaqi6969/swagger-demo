package com.jiaqi.wu.swaggerDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>> SwaggerDemoApplication is running <<<<<<<<<<");
    }
}
