package com.rent.form;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.TCustomer;
import java.util.Date;

/**
 *
 * @author rent
 */


public class TCustomerInfoBean extends BaseInfoBean {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Integer age;
    private Integer gender;
    private Date createTime;
    private Integer isAdmin;
    private Integer isDelete;

    private String email;
    private String phone;
    private String address;

    public TCustomer toTCustomer(TCustomer entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.username != null) {
            entity.setUsername(this.username);
        }
        if (this.firstName != null) {
            entity.setFirstName(this.firstName);
        }
        if (this.lastName != null) {
            entity.setLastName(this.lastName);
        }
        if (this.password != null) {
            entity.setPassword(this.password);
        }
        if (this.age != null) {
            entity.setAge(this.age);
        }
        if (this.gender != null) {
            entity.setGender(this.gender);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        if (this.isAdmin != null) {
            entity.setIsAdmin(this.isAdmin);
        }
        if(this.isDelete != null) {
            entity.setIsDelete(this.isDelete);
        }
        if(this.phone != null) {
            entity.setPhone(this.phone);
        }
        if(this.email != null) {
            entity.setEmail(this.email);
        }
        if(this.address != null) {
            entity.setAddress(this.address);
        }
        return entity;
    }


    public Wrapper<TCustomer> toWrapper() {
        Wrapper<TCustomer> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id", this.id);
        }
        if (this.username != null) {
            wrapper.like("username", this.username);
        }
        if (this.firstName != null) {
            wrapper.like("first_name", this.firstName);
        }
        if (this.lastName != null) {
            wrapper.like("last_name", this.lastName);
        }
        if (this.password != null) {
            wrapper.like("password", this.password);
        }
        if (this.age != null) {
            wrapper.eq("age", this.age);
        }
        if (this.gender != null) {
            wrapper.eq("gender", this.gender);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time", this.createTime);
        }
        if (this.isAdmin != null) {
            wrapper.eq("is_admin", this.isAdmin);
        }
        return wrapper;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "TCustomer{" +
                "id=" + id +
                ", username=" + username +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", password=" + password +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", isAdmin=" + isAdmin +
                "}";
    }
}
