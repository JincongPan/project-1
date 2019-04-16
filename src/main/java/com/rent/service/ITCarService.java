package com.rent.service;

import com.rent.entity.TCar;
import com.baomidou.mybatisplus.service.IService;
import com.rent.form.TCarInfoBean;
import com.rent.utils.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
public interface ITCarService extends IService<TCar> {
    Result findTCars(TCarInfoBean infoBean);

    boolean add(TCarInfoBean infoBean);

    boolean updateCar(TCar entity, TCarInfoBean infoBean);

    String findCars(TCarInfoBean infoBean);
}
