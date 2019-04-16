package com.rent.mapper;

import com.rent.entity.TCarFeatures;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
@Mapper
@Repository
public interface TCarFeaturesMapper extends BaseMapper<TCarFeatures> {

    List<Integer> selectIdsByCar(@Param("id") int carId);

}
