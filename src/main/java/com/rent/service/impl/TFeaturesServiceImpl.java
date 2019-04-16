package com.rent.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.entity.TFeatures;
import com.rent.form.TFeaturesInfoBean;
import com.rent.mapper.TFeaturesMapper;
import com.rent.service.ITFeaturesService;
import com.rent.utils.PageBean;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
@Service

public class TFeaturesServiceImpl extends ServiceImpl<TFeaturesMapper, TFeatures> implements ITFeaturesService {
    @Override
    public Result findTFeaturess(TFeaturesInfoBean infoBean) {
        Page<TFeatures> page = infoBean.getPage();
        if (page == null) {
            page = infoBean.createPage();
        }
        page.setRecords(baseMapper.selectPage(page, infoBean.toWrapper()));
        return Result.ok(new PageBean<>(page));
    }

    @Override
    public List<TFeatures> findTFeaturesByCar(Integer id) {
        return baseMapper.findTFeaturesByCar(id);
    }
}

