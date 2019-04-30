package com.rent.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.TCar;
import com.rent.entity.TCustomer;
import com.rent.form.BaseInfoBean;
import com.rent.form.TCustomerInfoBean;
import com.rent.mapper.TCustomerMapper;
import com.rent.service.ITCustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.utils.PageBean;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rent
 * @since 2019-04-05
 */
@Service

public class TCustomerServiceImpl extends ServiceImpl<TCustomerMapper, TCustomer> implements ITCustomerService {
    @Override
    public String findTCustomers(TCustomerInfoBean infoBean) {
        Page<TCustomer> page = infoBean.getPage();
        if(page == null) {
        page = infoBean.createPage();
        }
        page.setRecords(baseMapper.selectPage(page,infoBean.toWrapper()));
        return ResultBuilder.buildData(new PageBean<>(page));
    }

    @Override
    public Result login(TCustomerInfoBean infoBean, HttpSession session) {
        TCustomer user = this.selectOne(new EntityWrapper<TCustomer>().eq("username", infoBean.getUsername()));
        if(user == null||user.getIsDelete() == 1) {
            return Result.fail("login fail,please check your username and password");
        }
        if(!user.getPassword().equals(infoBean.getPassword())) {
            return Result.fail("password error");

        }
        if(user.getIsAdmin().equals(1)) {
            session.setAttribute("admin",user);
        }else{
            session.setAttribute("customer",user);
        }
        return Result.ok(user.getIsAdmin());
    }

    @Override
    public Result findAllCustomers(TCustomerInfoBean infoBean) {
        Page<TCustomer> page = infoBean.getPage();
        if (page == null) {
            page = infoBean.createPage(BaseInfoBean.DEFAULT_PAGE_NUM,5);
        }
        Wrapper<TCustomer> wrapper =
                infoBean.toWrapper();
        wrapper.eq("is_admin",0);
        page.setRecords(baseMapper.selectPage(page, wrapper));
        return Result.ok(new PageBean<>(page));
    }
}

