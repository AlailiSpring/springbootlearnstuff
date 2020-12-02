package com.alaili.springbootlearnstuff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alaili.springbootlearnstuff.mapper")
public class SpringbootlearnstuffApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootlearnstuffApplication.class, args);
    }

}
