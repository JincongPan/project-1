package com.rent.form;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.Contact;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author rent
 * @since 2019-04-25
 */


public class ContactInfoBean extends BaseInfoBean {

    private Integer id;
    private String name;
    private String email;
    private String telephone;
    private String message;
    private Date createTime;


    public Contact toContact(Contact entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.name != null) {
            entity.setName(this.name);
        }
        if (this.email != null) {
            entity.setEmail(this.email);
        }
        if (this.telephone != null) {
            entity.setTelephone(this.telephone);
        }
        if (this.message != null) {
            entity.setMessage(this.message);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        return entity;
    }


    public Wrapper<Contact> toWrapper() {
        Wrapper<Contact> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id" , this.id);
        }
        if (this.name != null) {
            wrapper.like("name" , this.name);
        }
        if (this.email != null) {
            wrapper.like("email" , this.email);
        }
        if (this.telephone != null) {
            wrapper.like("telephone" , this.telephone);
        }
        if (this.message != null) {
            wrapper.like("message" , this.message);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time" , this.createTime);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", telephone=" + telephone +
                ", message=" + message +
                ", createTime=" + createTime +
                "}" ;
    }
}
