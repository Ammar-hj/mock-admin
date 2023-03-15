package com.platform.mocklearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.platform.mocklearn.model.mapper")
@EnableSwagger2
public class MockLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockLearnApplication.class, args);
    }

}
