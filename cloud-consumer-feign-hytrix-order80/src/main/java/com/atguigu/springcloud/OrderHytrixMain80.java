package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHytrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHytrixMain80.class, args);
    }

}
