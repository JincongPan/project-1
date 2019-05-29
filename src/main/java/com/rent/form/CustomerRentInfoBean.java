package com.rent.form;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.CustomerRent;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author rent
 */


public class CustomerRentInfoBean extends BaseInfoBean {

    private Integer id;
    private Integer customerId;
    private Integer carId;
    private BigDecimal cost;
    private Date rentTime;
    private Integer rentStatus;
    private Date returnTime;
    private String remark;
    private String limitTime;

    public CustomerRent toCustomerRent(CustomerRent entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.customerId != null) {
            entity.setCustomerId(this.customerId);
        }
        if (this.carId != null) {
            entity.setCarId(this.carId);
        }
        if (this.cost != null) {
            entity.setCost(this.cost);
        }
        if (this.rentTime != null) {
            entity.setRentTime(this.rentTime);
        }
        if (this.rentStatus != null) {
            entity.setRentStatus(this.rentStatus);
        }
        if (this.returnTime != null) {
            entity.setReturnTime(this.returnTime);
        }
        if(this.limitTime != null){
            try {
                entity.setLimitTime(format.parse(this.limitTime));
            } catch (ParseException e) {
                entity.setLimitTime(null);

            }
        }
        if (this.remark != null) {
            entity.setRemark(this.remark);
        }
        return entity;
    }


    public Wrapper<CustomerRent> toWrapper() {
        Wrapper<CustomerRent> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id", this.id);
        }
        if (this.customerId != null) {
            wrapper.eq("customer_id", this.customerId);
        }
        if (this.carId != null) {
            wrapper.eq("car_id", this.carId);
        }
        if (this.cost != null) {
            wrapper.eq("cost", this.cost);
        }
        if (this.rentTime != null) {
            wrapper.eq("rent_time", this.rentTime);
        }
        if (this.rentStatus != null) {
            wrapper.eq("rent_status", this.rentStatus);
        }
        if (this.returnTime != null) {
            wrapper.eq("return_time", this.returnTime);
        }
        if (this.remark != null) {
            wrapper.like("remark", this.remark);
        }
        return wrapper;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getRentTime() {
        return rentTime;
    }

    public void setRentTime(Date rentTime) {
        this.rentTime = rentTime;
    }

    public Integer getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Integer rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CustomerRent{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", cost=" + cost +
                ", rentTime=" + rentTime +
                ", rentStatus=" + rentStatus +
                ", returnTime=" + returnTime +
                ", remark=" + remark +
                "}";
    }
}
