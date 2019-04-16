package com.rent.service;

import com.rent.entity.TCarFeatures;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
public interface ITCarFeaturesService extends IService<TCarFeatures> {
    List<Integer> selectIdsByCar(int carId);
}
