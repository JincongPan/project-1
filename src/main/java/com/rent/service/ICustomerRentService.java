package com.rent.service;


import com.baomidou.mybatisplus.service.IService;
import com.rent.entity.CustomerRent;
import com.rent.form.CustomerRentInfoBean;
import com.rent.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rent
 * @since 2019-04-12
 */
public interface ICustomerRentService extends IService<CustomerRent> {
     Result findCustomerRents(CustomerRentInfoBean infoBean);
}
