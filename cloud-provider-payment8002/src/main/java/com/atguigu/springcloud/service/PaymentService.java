package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
public interface PaymentService {

    /**
     * 新增
     * @param payment
     * @return
     */
    int insert(Payment payment);

    /**
     * 查询
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);

}
