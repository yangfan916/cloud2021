package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHytrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHytrixController {

    @Resource
    private PaymentHytrixService paymentHytrixService;

    @RequestMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentHytrixService.paymentInfo_ok(id);
        return result;
    }

    @RequestMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        int num = 10/0;
        String result = paymentHytrixService.paymentInfo_timeout(id);
        return result;
    }
    public String paymentInfo_timeoutFallback(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒后再试或者自己运行出错，请检查";
    }

    // 全局 fallback 方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试/(ㄒoㄒ)/~~";
    }

}
