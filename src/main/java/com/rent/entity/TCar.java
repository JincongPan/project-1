package com.rent.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 *
 * @author rent
 */
@TableName("t_car")
public class TCar implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int STATUS_NORMAL = 1;
    public static final int STATUS_RENT = 2;
    public static final int STATUS_DISABLED = 3;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("car_brand")
    private String carBrand;
    @TableField("license_plate")
    private String licensePlate;
    @TableField("rent_cost")
    private BigDecimal rentCost;
    private BigDecimal longitude;
    private BigDecimal dimension;
    private String address;
    @TableField("create_time")
    private Date createTime;
    private Integer status;
    private String image;
    private String description;
    private String model;
    @TableField("body_style")
    private String bodyStyle;
    private Integer seats;
    @TableField("fuel_type")
    private String fuelType;
    private String transmission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public BigDecimal getRentCost() {
        return rentCost;
    }

    public void setRentCost(BigDecimal rentCost) {
        this.rentCost = rentCost;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getDimension() {
        return dimension;
    }

    public void setDimension(BigDecimal dimension) {
        this.dimension = dimension;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public String getStatusStr(){
        String res= "";
        if(this.status.equals(STATUS_NORMAL)) {
            res = "available";
        }
        if(this.status.equals(STATUS_RENT)) {
            res = "renting";
        }
        if(this.status.equals(STATUS_DISABLED)) {
            res = "disable";
        }
        return res;
    }
    @Override
    public String toString() {
        return "TCar{" +
        "id=" + id +
        ", carBrand=" + carBrand +
        ", licensePlate=" + licensePlate +
        ", rentCost=" + rentCost +
        ", longitude=" + longitude +
        ", dimension=" + dimension +
        ", address=" + address +
        ", createTime=" + createTime +
        ", status=" + status +
        ", image=" + image +
        ", description=" + description +
        ", model=" + model +
        ", bodyStyle=" + bodyStyle +
        ", seats=" + seats +
        ", fuelType=" + fuelType +
        ", transmission=" + transmission +
        "}";
    }
}
