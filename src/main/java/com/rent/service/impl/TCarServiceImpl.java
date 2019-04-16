package com.rent.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rent.entity.TCar;
import com.rent.entity.TCarFeatures;
import com.rent.form.BaseInfoBean;
import com.rent.mapper.TCarMapper;
import com.rent.service.ITCarFeaturesService;
import com.rent.service.ITCarService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.service.ITFeaturesService;
import com.rent.utils.PageBean;
import com.rent.utils.Result;
import com.rent.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.rent.form.TCarInfoBean;

import java.util.ArrayList;
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

public class TCarServiceImpl extends ServiceImpl<TCarMapper, TCar> implements ITCarService {
    @Autowired
    private ITFeaturesService itFeaturesService;
    @Autowired
    private ITCarFeaturesService carFeaturesService;

    @Override
    public Result findTCars(TCarInfoBean infoBean) {

        Page<TCar> page = infoBean.getPage();
        if (page == null) {
            page = infoBean.createPage(BaseInfoBean.DEFAULT_PAGE_NUM,5);
        }
        Wrapper<TCar> wrapper =
                infoBean.toWrapper();
        wrapper.eq("status", TCar.STATUS_NORMAL);
        page.setRecords(baseMapper.selectPage(page, wrapper));
        return Result.ok(new PageBean<>(page));
    }

    @Override
    public boolean add(TCarInfoBean infoBean) {
        TCar tCar = infoBean.toTCar(new TCar());
        try {
            insert(tCar);
            Integer[] ids = infoBean.getIds();
            List<TCarFeatures> list = new ArrayList<>();
            for (Integer id : ids) {
                TCarFeatures carFeatures = new TCarFeatures();
                carFeatures.setCarId(tCar.getId());
                carFeatures.setFeaturesId(id);
                list.add(carFeatures);
            }
            if (!list.isEmpty()) {
                carFeaturesService.insertBatch(list);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean updateCar(TCar entity, TCarInfoBean infoBean) {

        try {

            carFeaturesService.delete(new EntityWrapper<TCarFeatures>().eq("car_id",entity.getId()));
            Integer[] ids = infoBean.getIds();
            List<TCarFeatures> list = new ArrayList<>();
            for (Integer id : ids) {
                TCarFeatures carFeatures = new TCarFeatures();
                carFeatures.setCarId(entity.getId());
                carFeatures.setFeaturesId(id);
                list.add(carFeatures);
            }
            if (!list.isEmpty()) {
                carFeaturesService.insertBatch(list);
            }
            this.updateById(infoBean.toTCar(entity));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String findCars(TCarInfoBean infoBean) {
        Page<TCar> page = infoBean.getPage();
        if (page == null) {
            page = infoBean.createPage(BaseInfoBean.DEFAULT_PAGE_NUM,5);
        }
        Wrapper<TCar> wrapper =
                infoBean.toWrapper();
        wrapper.eq("status", TCar.STATUS_NORMAL);
        page.setRecords(baseMapper.selectPage(page, wrapper));
        return ResultBuilder.buildData(new PageBean<>(page));
    }
}

