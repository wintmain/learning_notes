package com.wintmain.springboot02config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ImportResource(locations = {"classpath:bean.xml"})
@SpringBootApplication
public class Springboot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02ConfigApplication.class, args);
    }

}
