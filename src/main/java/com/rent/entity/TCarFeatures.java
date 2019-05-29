package com.rent.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * @author rent
 */
@TableName("t_car_features")
public class TCarFeatures implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("car_id")
    private Integer carId;
    @TableField("features_id")
    private Integer featuresId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getFeaturesId() {
        return featuresId;
    }

    public void setFeaturesId(Integer featuresId) {
        this.featuresId = featuresId;
    }

    @Override
    public String toString() {
        return "TCarFeatures{" +
        "id=" + id +
        ", carId=" + carId +
        ", featuresId=" + featuresId +
        "}";
    }
}
