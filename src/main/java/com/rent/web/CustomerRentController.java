package com.rent.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rent.entity.CustomerRent;
import com.rent.entity.TCar;
import com.rent.entity.TCustomer;
import com.rent.form.CustomerRentInfoBean;
import com.rent.service.ICustomerRentService;
import com.rent.service.ITCarService;
import com.rent.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-12
 */
@Controller()
@RequestMapping("/rent")
public class CustomerRentController {

    @Autowired
    private ICustomerRentService iCustomerRentService;
    @Autowired
    private ITCarService carService;

    @RequestMapping(value = "/book")
    public String book(CustomerRentInfoBean infoBean, HttpSession session, Map<String,Object> model) {
        if(infoBean.getCarId() == null) {
            model.put("res", Result.build(602,"request error","/index.html"));
            return "message";
        }
        TCustomer customer = (TCustomer) session.getAttribute("customer");
        if (customer == null) {
            model.put("res", Result.build(601,"Please login first.","/login.html"));
            return "message";
        }
        List<CustomerRent> list = iCustomerRentService.selectList(new EntityWrapper<CustomerRent>().eq("customer_id", customer.getId())
                .ne("rent_status", CustomerRent.STATUS_RETURN)
        );
        if(!list.isEmpty()){
            model.put("res", Result.build(600,"Can't rent car, You have already rent a car.","/orders.html"));
            return "message";
        }
        TCar car = carService.selectById(infoBean.getCarId());
        model.put("car",car);
        return "rent";
    }

    @RequestMapping(value = "/save")
    public String save(CustomerRentInfoBean infoBean, HttpSession session, Map<String,Object> model) {
        if(infoBean.getCarId() == null) {
            model.put("res", Result.build(602,"request error","/index.html"));
            return "message";
        }
        TCustomer customer = (TCustomer) session.getAttribute("customer");
        if (customer == null) {
            model.put("res", Result.build(601,"Please login first.","/login.html"));
            return "message";
        }
        TCar car = carService.selectById(infoBean.getCarId());
        if(!car.getStatus().equals(TCar.STATUS_NORMAL)){
            model.put("res", Result.build(600,"This car is rent by other.","/cars.html"));
            return "message";
        }
        CustomerRent customerRent = infoBean.toCustomerRent(new CustomerRent());
        customerRent.setRentStatus(CustomerRent.STATUS_RENTING);
        customerRent.setCost(BigDecimal.ZERO);
        customerRent.setCustomerId(customer.getId());
        customerRent.setRentTime(new Date());
        iCustomerRentService.insert(customerRent);
        car.setStatus(TCar.STATUS_RENT);
        carService.updateById(car);
        model.put("res", Result.build(200,"Rent car success, please return car in time","/index.html"));
        return "message";
    }

    @RequestMapping("/return")
    public String returnCar(CustomerRentInfoBean infoBean){
        Integer id = infoBean.getId();
        CustomerRent customerRent = iCustomerRentService.selectById(id);
        customerRent.setRentStatus(CustomerRent.STATUS_NO_PAY);
        TCar tCar = carService.selectById(customerRent.getCarId());
        tCar.setStatus(TCar.STATUS_NORMAL);
        iCustomerRentService.updateById(customerRent);
        carService.updateById(tCar);
        return "redirect:/orders.html";
    }
}
