package com.rent.form;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.TFeatures;

/**
 *
 * @author rent
 */


public class TFeaturesInfoBean extends BaseInfoBean {

    private Integer id;
    private String name;


    public TFeatures toTFeatures(TFeatures entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.name != null) {
            entity.setName(this.name);
        }
        return entity;
    }


    public Wrapper<TFeatures> toWrapper() {
        Wrapper<TFeatures> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id", this.id);
        }
        if (this.name != null) {
            wrapper.like("name", this.name);
        }
        return wrapper;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TFeatures{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
