package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
@RestController
@Slf4j
public class OrderZkController {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentZk(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
