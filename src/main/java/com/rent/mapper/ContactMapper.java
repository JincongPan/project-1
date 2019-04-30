package com.rent.mapper;

import com.rent.entity.Contact;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rent
 * @since 2019-04-25
 */
@Mapper
@Repository
public interface ContactMapper extends BaseMapper<Contact> {

}
