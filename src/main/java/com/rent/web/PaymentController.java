package com.rent.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.rent.entity.CustomerRent;
import com.rent.entity.TCar;
import com.rent.entity.TCustomer;
import com.rent.form.CustomerRentInfoBean;
import com.rent.service.ICustomerRentService;
import com.rent.service.ITCarService;
import com.rent.service.impl.PaypalService;
import com.rent.utils.PaypalPaymentIntent;
import com.rent.utils.PaypalPaymentMethod;
import com.rent.utils.URLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/paypal")
public class PaymentController {
    public static final String PAYPAL_SUCCESS_URL = "/paypal/success";
    public static final String PAYPAL_CANCEL_URL = "paypal/cancel";
    @Autowired
    private ICustomerRentService iCustomerRentService;
    @Autowired
    private ITCarService carService;
    @Autowired
    private PaypalService paypalService;

    @RequestMapping("/pay")
    public String pay(CustomerRentInfoBean infoBean, HttpServletRequest request) {
        System.out.println("pay start");
        TCustomer customer = (TCustomer) request.getSession().getAttribute("customer");
        if (customer == null) {
            return "redirect:/login.html";
        }
        if (infoBean.getId() == null) {
            return "";
        }
        CustomerRent customerRent = iCustomerRentService.selectOne(new EntityWrapper<CustomerRent>()
                .eq("customer_id", customer.getId())
                .eq("id", infoBean.getId()));
        if (customerRent == null) {
            return "";
        }
        String cancelUrl = URLUtils.getBaseURl(request) + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request)  + PAYPAL_SUCCESS_URL + "?id=" + customerRent.getId();
        try {
            Payment payment = paypalService.createPayment(
                    customerRent.getCost().doubleValue(),
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/login.html";
    }

    @GetMapping("cancel")
    public String cancelPay() {
        System.out.println("paypal cancel.....");
        return "redirect:/orders.html";
    }

    @GetMapping("success")
    public String successPay(HttpSession session,@RequestParam("id") Integer id,
                             @RequestParam("paymentId") String paymentId,
                             @RequestParam("PayerID") String payerId) {
        try {
            System.out.println("paypal callback");
            System.out.println("rent id " + id);
            System.out.println("paymentId " + paymentId);
            System.out.println("payerId " + payerId);




            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {


                TCustomer customer = (TCustomer) session.getAttribute("customer");
                if (customer == null) {
                    return "redirect:/login.html";
                }
                CustomerRent customerRent = iCustomerRentService.selectOne(new EntityWrapper<CustomerRent>()
                        .eq("customer_id", customer.getId())
                        .eq("id", id));
                if (customerRent == null) {
                    return "";
                }
                customerRent.setRentStatus(CustomerRent.STATUS_RETURN);
                iCustomerRentService.updateById(customerRent);
                TCar car = carService.selectById(customerRent.getCarId());
                car.setStatus(TCar.STATUS_NORMAL);
                carService.updateById(car);
                return "redirect:/orders.html";
            }
        } catch (PayPalRESTException e) {
        }
        return "redirect:/login.html";
    }

}