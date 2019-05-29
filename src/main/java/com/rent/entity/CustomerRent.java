package com.rent.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import jdk.net.SocketFlow;

import java.io.Serializable;

/**
 *
 * @author rent
 */
@TableName("customer_rent")
public class CustomerRent implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int STATUS_RENTING = 1;
    public static final int STATUS_NO_PAY = 2;
    public static final int STATUS_RETURN = 3;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("customer_id")
    private Integer customerId;
    @TableField("car_id")
    private Integer carId;
    private BigDecimal cost;
    @TableField("rent_time")
    private Date rentTime;
    @TableField("rent_status")
    private Integer rentStatus;
    @TableField("return_time")
    private Date returnTime;
    @TableField("limit_time")
    private Date limitTime;
    private String remark;
    @TableField(exist = false)
    private String customerName;
    @TableField(exist = false)
    private TCar car;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public TCar getCar() {
        return car;
    }

    public void setCar(TCar car) {
        this.car = car;
    }

    public Date getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Date limitTime) {
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

    public String getRentStatusStr() {
        String result = "";
        if (rentStatus == STATUS_RENTING) {
            result = "renting";
        }
        if (rentStatus == STATUS_NO_PAY) {
            result = "unpaid";
        }
        if (rentStatus == STATUS_RETURN) {
            result = "return";
        }
        return result;
    }

    public BigDecimal getRealCost() {
        if (rentStatus == STATUS_RENTING) {
            Instant now = Instant.now();
            Instant instant = rentTime.toInstant();
            long seconds = Duration.between(instant, now).getSeconds();

            if (car != null) {
                long hours = seconds / 3600;
                if (seconds % 3600 != 0) {
                    hours += 1;
                }
                return BigDecimal.valueOf(hours).multiply(car.getRentCost());
            }
        }

        return cost;
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
