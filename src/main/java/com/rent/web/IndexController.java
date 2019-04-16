package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rent.entity.TCar;
import com.rent.form.CustomerRentInfoBean;
import com.rent.form.TCarInfoBean;
import com.rent.service.ICustomerRentService;
import com.rent.service.ITCarService;
import com.rent.service.ITFeaturesService;
import com.rent.utils.PageBean;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
public class IndexController {
    @Autowired
    private ITCarService iTCarService;
    @Autowired
    private ITFeaturesService itFeaturesService;
    @Autowired
    private ICustomerRentService iCustomerRentService;
    @RequestMapping(value = {"/index","/","/index.html"})
    public String index(Map<String, Object> map, @RequestParam(required = false) TCarInfoBean infoBean) {
        if (infoBean == null) {
            infoBean = new TCarInfoBean();
        }
        List<TCar> list = iTCarService.selectList(new EntityWrapper<TCar>().eq("status", TCar.STATUS_NORMAL));
        map.put("cars", list);
        map.put("jsonData", JSON.toJSONString(list));
        return "index";
    }

    @RequestMapping(value = "/car.html")
    public String toCarDetail(Map<String, Object> map, TCarInfoBean infoBean) {

        map.put("car", iTCarService.selectById(infoBean.getId()));
        map.put("features",itFeaturesService.findTFeaturesByCar(infoBean.getId()));
        return "car";
    }
    @RequestMapping(value = "/cars.html")
    public String findCars(Map<String, Object> map, TCarInfoBean infoBean) {
        if(StringUtils.isNotEmpty(infoBean.getKeyword())) {
            infoBean.setCarBrand(infoBean.getKeyword());
            map.put("keyword",infoBean.getKeyword());
        }
        infoBean.setPageSize(5);
        map.put("res",iTCarService.findTCars(infoBean));
        return "cars";
    }

    @RequestMapping(value = "/orders.html")
    public String findOrders(Map<String, Object> map, CustomerRentInfoBean infoBean) {
        infoBean.setPageSize(5);
        map.put("res",iCustomerRentService.findCustomerRents(infoBean));
        return "orders";
    }
}
