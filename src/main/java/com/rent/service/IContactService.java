package com.rent.service;

import com.rent.entity.Contact;
import com.baomidou.mybatisplus.service.IService;
import com.rent.form.ContactInfoBean;
import com.rent.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rent
 * @since 2019-04-25
 */
public interface IContactService extends IService<Contact> {
     Result findContacts(ContactInfoBean infoBean);
}
