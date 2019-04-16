package com.rent.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rent.entity.TCustomer;
import com.rent.form.TCustomerInfoBean;
import com.rent.service.ITCustomerService;
import com.rent.utils.ResponseCode;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-05
 */
@Controller
@RequestMapping("/rent/customer")
public class CustomerController {

    @Autowired
    private ITCustomerService iTCustomerService;


    /**
     * 创建
     *
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public Result create(@Validated TCustomerInfoBean infoBean
            , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            System.out.println(errorList.toString());
            return Result.fail(ResponseCode.PARAMS_WRONG.getMsg());
        }
        if (iTCustomerService.insert(
                infoBean.toTCustomer(new TCustomer()))) {
            return Result.ok("register success");
        } else {
            return Result.fail(ResponseCode.DATABASE_FAIL.getMsg());
        }
    }


    /**
     * 更新
     *
     * @return
     */
    @PostMapping(value = "/update/{id}", produces = "application/json;charset=utf-8")
    public String update(@PathVariable("id") Integer id
            , @RequestBody TCustomerInfoBean infoBean) {
        TCustomer entity = iTCustomerService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if (iTCustomerService.updateById(
                infoBean.toTCustomer(entity))) {
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
        TCustomer entity = iTCustomerService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.DATA_NOT_EXIST);
        }
        if (iTCustomerService.deleteById(id)) {
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
    @PostMapping(value = "/index", produces = "application/json; charset=utf-8")
    public String index(@RequestBody TCustomerInfoBean infoBean) {
        return iTCustomerService.findTCustomers(infoBean);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(TCustomerInfoBean infoBean, HttpSession session) {
        return iTCustomerService.login(infoBean, session);
    }


    @RequestMapping(value = "/checkUsername")
    @ResponseBody
    public Object checkUsername(TCustomerInfoBean infoBean, HttpSession session) {
        TCustomer customer = iTCustomerService.selectOne(
                new EntityWrapper<TCustomer>().eq("username", infoBean.getUsername()));
        Map<String,Boolean> map = new HashMap<>();
        if (customer == null) {
            map.put("valid",true);
        } else {
            map.put("valid",false);

        }
        return map;

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("customer");

        return "redirect:/";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
