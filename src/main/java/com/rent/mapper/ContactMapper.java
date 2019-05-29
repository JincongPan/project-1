package com.rent.mapper;

import com.rent.entity.Contact;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * <p>
 *  Mapper interface
 * </p>
 *
 * @author rent
 */
@Mapper
@Repository
public interface ContactMapper extends BaseMapper<Contact> {

}
