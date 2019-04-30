package com.rent.service;

import com.rent.entity.TCustomer;
import com.baomidou.mybatisplus.service.IService;
import com.rent.form.TCustomerInfoBean;
import com.rent.utils.Result;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rent
 * @since 2019-04-05
 */
public interface ITCustomerService extends IService<TCustomer> {
     String findTCustomers(TCustomerInfoBean infoBean);

    Result login(TCustomerInfoBean infoBean, HttpSession session);

    Result findAllCustomers(TCustomerInfoBean infoBean);
}
