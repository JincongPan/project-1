package com.rent.mapper;

import com.rent.entity.TFeatures;
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
public interface TFeaturesMapper extends BaseMapper<TFeatures> {
    List<TFeatures> findTFeaturesByCar(@Param("id") Integer id);
}
