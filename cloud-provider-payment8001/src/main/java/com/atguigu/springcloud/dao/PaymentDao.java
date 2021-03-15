package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangfan
 * @version 1.0
 * @description
 */
@Mapper
public interface PaymentDao {
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
    Payment getPaymentById(@Param("id") Long id);

}
