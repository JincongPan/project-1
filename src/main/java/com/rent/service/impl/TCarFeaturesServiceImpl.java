package com.rent.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.entity.TCarFeatures;
import com.rent.mapper.TCarFeaturesMapper;
import com.rent.service.ITCarFeaturesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
@Service

public class TCarFeaturesServiceImpl extends ServiceImpl<TCarFeaturesMapper, TCarFeatures> implements ITCarFeaturesService {
    @Override
    public List<Integer> selectIdsByCar(int carId) {

        return baseMapper.selectIdsByCar(carId);
    }
}

