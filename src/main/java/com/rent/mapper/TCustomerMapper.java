package com.rent.mapper;

import com.rent.entity.TCustomer;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * <p>
 *  Mapper interface
 * </p>
 *
 */
@Mapper
@Repository
public interface TCustomerMapper extends BaseMapper<TCustomer> {

}
