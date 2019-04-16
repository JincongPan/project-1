package com.rent.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.entity.CustomerRent;
import com.rent.form.CustomerRentInfoBean;
import com.rent.mapper.CustomerRentMapper;
import com.rent.service.ICustomerRentService;
import com.rent.utils.PageBean;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rent
 * @since 2019-04-12
 */
@Service

public class CustomerRentServiceImpl extends ServiceImpl<CustomerRentMapper, CustomerRent> implements ICustomerRentService {
    @Override
    public Result findCustomerRents(CustomerRentInfoBean infoBean) {
        Page<CustomerRent> page = infoBean.getPage();
        if (page == null) {
            page = infoBean.createPage();
        }
        page.setRecords(baseMapper.findCustomerRents(page, infoBean.toWrapper()));
        return Result.ok(new PageBean(page));
    }
}

