package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
@Component
public class PaymentFallbackService implements PaymentHytrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "======PaymentFallbackService====paymentInfo_ok===";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "======PaymentFallbackService====paymentInfo_timeout===";
    }
}
