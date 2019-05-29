package com.rent.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.rent.entity.CustomerRent;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 *
 * @author rent
 */
@Mapper
@Repository
public interface CustomerRentMapper extends BaseMapper<CustomerRent> {


    List<CustomerRent> findCustomerRents(RowBounds rowBounds,@Param("ew") Wrapper<CustomerRent> customerRentWrapper);
}
