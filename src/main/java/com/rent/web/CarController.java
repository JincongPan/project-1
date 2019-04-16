package com.rent.web;


import com.rent.entity.TCustomer;
import com.rent.form.TCarInfoBean;
import com.rent.form.TCustomerInfoBean;
import com.rent.service.ITCarService;
import com.rent.service.ITCustomerService;
import com.rent.utils.ResponseCode;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/rent/car")
public class CarController {
    @Autowired
    private ITCarService iTCarService;
    @Autowired
    private ITCustomerService iTCustomerService;

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> map, @RequestParam(required = false) TCarInfoBean infoBean) {
        if (infoBean == null) {
            infoBean = new TCarInfoBean();
        }
        map.put("result", iTCarService.findTCars(infoBean));
        return "admin/cars";
    }

}
