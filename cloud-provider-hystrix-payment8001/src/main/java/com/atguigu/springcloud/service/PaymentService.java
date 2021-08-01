package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
@Service
public class PaymentService {
    /**
     * 正常访问，ok的方法
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_ok, id： " + id + "\t" + "O(∩_∩)O哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeout(Integer id){
        int timeNum = 5;
        try {
            // int num = 10/0;
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_timeout, id： " + id + "\t" + "耗时（秒）：" + timeNum;
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() + " 系统繁忙，请稍后再试, id： " + id + " /(ㄒoㄒ)/~~";
    }

}
