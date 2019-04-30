package com.rent.web.admin;


import com.rent.entity.CustomerRent;
import com.rent.form.CustomerRentInfoBean;
import com.rent.form.TCarInfoBean;
import com.rent.service.ICustomerRentService;
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
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-25
 */
@Controller("adminCustomerRentController")
@RequestMapping("/admin/orders")
public class CustomerRentController {

    @Autowired
    private ICustomerRentService iCustomerRentService;


    /**
     * 创建
     *
     * @return
     */
    @PostMapping(value = "/create" , produces = "application/json;charset=utf-8")
    public String create(@RequestBody @Validated CustomerRentInfoBean infoBean
            , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            System.out.println(errorList.toString());
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if (iCustomerRentService.insert(
                infoBean.toCustomerRent(new CustomerRent()))) {
            return ResultBuilder.buildOk();
        } else {
            return ResultBuilder.buildResponseCode(ResponseCode.DATABASE_FAIL);
        }
    }


    /**
     * 更新
     *
     * @return
     */
    @PostMapping(value = "/update/{id}" , produces = "application/json;charset=utf-8")
    public String update(@PathVariable("id") Integer id
            , @RequestBody CustomerRentInfoBean infoBean) {
        CustomerRent entity = iCustomerRentService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if (iCustomerRentService.updateById(
                infoBean.toCustomerRent(entity))) {
            return ResultBuilder.buildOk();
        } else {
            return ResultBuilder.buildResponseCode(ResponseCode.DATABASE_FAIL);
        }
    }

    /**
     * 关闭
     *
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        CustomerRent entity = iCustomerRentService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.DATA_NOT_EXIST);
        }
        if (iCustomerRentService.deleteById(id)) {
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
    @RequestMapping(value = "/index")
    public String index(Map<String, Object> map, CustomerRentInfoBean infoBean) {
        if (infoBean == null) {
            infoBean = new CustomerRentInfoBean();
        }
        map.put("result", iCustomerRentService.findCustomerRents(infoBean));
        return "admin/orders";
    }

}
