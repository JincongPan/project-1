package com.rent.service;

import com.rent.entity.TFeatures;
import com.baomidou.mybatisplus.service.IService;
import com.rent.form.TFeaturesInfoBean;
import com.rent.utils.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
public interface ITFeaturesService extends IService<TFeatures> {
     Result findTFeaturess(TFeaturesInfoBean infoBean);

     List<TFeatures> findTFeaturesByCar(Integer id);
}
