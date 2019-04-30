package com.rent.web;


import com.rent.entity.Contact;
import com.rent.form.ContactInfoBean;
import com.rent.service.IContactService;
import com.rent.utils.ResponseCode;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-25
 */
@Controller
@RequestMapping("/rent/contact")


public class ContactController {

    @Autowired
    private IContactService iContactService;


    /**
     * 创建
     *
     * @return
     */
    @PostMapping(value = "/create")
    @ResponseBody
    public String create(@Validated ContactInfoBean infoBean
            , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            System.out.println(errorList.toString());
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if (iContactService.insert(
                infoBean.toContact(new Contact()))) {
            return ResultBuilder.buildOk();
        } else {
            return ResultBuilder.buildResponseCode(ResponseCode.DATABASE_FAIL);
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @PostMapping(value = "/index" , produces = "application/json; charset=utf-8")
    public Result index(@RequestBody ContactInfoBean infoBean) {
        return iContactService.findContacts(infoBean);
    }

}
