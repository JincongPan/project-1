package com.rent.service.impl;

import com.rent.entity.Contact;
import com.rent.mapper.ContactMapper;
import com.rent.service.IContactService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.utils.PageBean;
import com.rent.utils.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.rent.form.ContactInfoBean;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rent
 * @since 2019-04-25
 */
@Service

public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IContactService {
    @Override
    public Result findContacts(ContactInfoBean infoBean) {
        Page<Contact> page = infoBean.getPage();
        if(page == null) {
        page = infoBean.createPage();
        }
        page.setRecords(baseMapper.selectPage(page,infoBean.toWrapper()));
        return Result.ok(new PageBean<>(page));
    }
}

