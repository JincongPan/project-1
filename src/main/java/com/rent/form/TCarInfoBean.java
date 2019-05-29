package com.rent.form;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.TCar;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author rent
 */


public class TCarInfoBean extends BaseInfoBean {

    private Integer id;
    private String carBrand;
    private String licensePlate;
    private BigDecimal rentCost;
    private BigDecimal longitude;
    private BigDecimal dimension;
    private String address;
    private Date createTime;
    private Integer status;
    private String image;
    private String description;
    private String model;
    private String bodyStyle;
    private Integer seats;
    private String fuelType;
    private String transmission;
    private MultipartFile file;
    private Integer[] ids;

    private String keyword;
    public TCar toTCar(TCar entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.carBrand != null) {
            entity.setCarBrand(this.carBrand);
        }
        if (this.licensePlate != null) {
            entity.setLicensePlate(this.licensePlate);
        }
        if (this.rentCost != null) {
            entity.setRentCost(this.rentCost);
        }
        if (this.longitude != null) {
            entity.setLongitude(this.longitude);
        }
        if (this.dimension != null) {
            entity.setDimension(this.dimension);
        }
        if (this.address != null) {
            entity.setAddress(this.address);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        if (this.status != null) {
            entity.setStatus(this.status);
        }
        if (this.image != null) {
            entity.setImage(this.image);
        }
        if (this.description != null) {
            entity.setDescription(this.description);
        }
        if (this.model != null) {
            entity.setModel(this.model);
        }
        if (this.bodyStyle != null) {
            entity.setBodyStyle(this.bodyStyle);
        }
        if (this.seats != null) {
            entity.setSeats(this.seats);
        }
        if (this.fuelType != null) {
            entity.setFuelType(this.fuelType);
        }
        if (this.transmission != null) {
            entity.setTransmission(this.transmission);
        }
        return entity;
    }


    public Wrapper<TCar> toWrapper() {
        Wrapper<TCar> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id", this.id);
        }
        if (this.carBrand != null) {
            wrapper.like("car_brand", this.carBrand);
        }
        if (this.licensePlate != null) {
            wrapper.like("license_plate", this.licensePlate);
        }
        if (this.rentCost != null) {
            wrapper.eq("rent_cost", this.rentCost);
        }
        if (this.longitude != null) {
            wrapper.eq("longitude", this.longitude);
        }
        if (this.dimension != null) {
            wrapper.eq("dimension", this.dimension);
        }
        if (this.address != null) {
            wrapper.like("address", this.address);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time", this.createTime);
        }
        if (this.status != null) {
            wrapper.eq("status", this.status);
        }
        if (this.image != null) {
            wrapper.like("image", this.image);
        }
        if (this.description != null) {
            wrapper.like("description", this.description);
        }
        if (this.model != null) {
            wrapper.like("model", this.model);
        }
        if (this.bodyStyle != null) {
            wrapper.like("body_style", this.bodyStyle);
        }
        if (this.seats != null) {
            wrapper.eq("seats", this.seats);
        }
        if (this.fuelType != null) {
            wrapper.like("fuel_type", this.fuelType);
        }
        if (this.transmission != null) {
            wrapper.like("transmission", this.transmission);
        }
        return wrapper;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
