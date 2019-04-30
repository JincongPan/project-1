package com.rent.web.admin;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rent.entity.TCar;
import com.rent.entity.TCustomer;
import com.rent.entity.TFeatures;
import com.rent.form.TCarInfoBean;
import com.rent.form.TCustomerInfoBean;
import com.rent.service.ITCustomerService;
import com.rent.utils.ResponseCode;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-05
 */
@Controller
@RequestMapping("/admin/customer")
public class AdminCustomerController {

    @Autowired
    private ITCustomerService iTCustomerService;

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> map, @RequestParam(required = false) TCustomerInfoBean infoBean) {
        if (infoBean == null) {
            infoBean = new TCustomerInfoBean();
        }
        map.put("result", iTCustomerService.findAllCustomers(infoBean));
        return "admin/customers";
    }


    /**
     * 更新
     *
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(TCustomerInfoBean infoBean) throws IOException {
        TCustomer entity = iTCustomerService.selectById(infoBean.getId());
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        infoBean.setPassword(null);
        infoBean.setIsAdmin(null);
        infoBean.setUsername(null);
        if (iTCustomerService.updateById(infoBean.toTCustomer(entity))) {
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
    @RequestMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable("id") Integer id, Map<String,Object> model) {
        TCustomer entity = iTCustomerService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        model.put("customer",entity);
        return "admin/editCustomer";

    }

    /**
     * delete
     *
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Map<String,Object> model) {
        TCustomer entity = iTCustomerService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if(entity.getIsDelete() == 0) {
            entity.setIsDelete(1);

        }else{
            entity.setIsDelete(0);
        }
        iTCustomerService.updateById(entity);
        return "redirect:/admin/customer/index";

    }

}
