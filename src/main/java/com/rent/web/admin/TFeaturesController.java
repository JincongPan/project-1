package com.rent.web.admin;


import com.rent.entity.TFeatures;
import com.rent.form.TCarInfoBean;
import com.rent.form.TFeaturesInfoBean;
import com.rent.service.ITFeaturesService;
import com.rent.utils.ResponseCode;
import com.rent.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
@Controller
@RequestMapping("/admin/features")


public class TFeaturesController {

    @Autowired
    private ITFeaturesService iTFeaturesService;


    /**
     * 创建
     *
     * @return
     */
    @PostMapping(value = "/create")
    @ResponseBody
    public String create(@Validated TFeaturesInfoBean infoBean
            , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            System.out.println(errorList.toString());
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if (iTFeaturesService.insert(
                infoBean.toTFeatures(new TFeatures()))) {
            return ResultBuilder.buildOk();
        } else {
            return ResultBuilder.buildResponseCode(ResponseCode.DATABASE_FAIL);
        }
    }


    /**
     * 更新
     *
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public String update(TFeaturesInfoBean infoBean) {
        TFeatures entity = iTFeaturesService.selectById(infoBean.getId());
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        if (iTFeaturesService.updateById(
                infoBean.toTFeatures(entity))) {
            return ResultBuilder.buildOk();
        } else {
            return ResultBuilder.buildResponseCode(ResponseCode.DATABASE_FAIL);
        }
    }

    /**
     * 关闭
     *
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        TFeatures entity = iTFeaturesService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.DATA_NOT_EXIST);
        }
        if (iTFeaturesService.deleteById(id)) {
            return ResultBuilder.buildOk();
        } else {
            return ResultBuilder.buildResponseCode(ResponseCode.DATABASE_FAIL);
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Map<String, Object> map, @RequestParam(required = false) TFeaturesInfoBean infoBean) {
        if (infoBean == null) {
            infoBean = new TFeaturesInfoBean();
        }
        map.put("result", iTFeaturesService.findTFeaturess(infoBean));
        return "admin1/features";
    }
}
