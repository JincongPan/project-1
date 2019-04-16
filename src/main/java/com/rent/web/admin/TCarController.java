package com.rent.web.admin;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rent.entity.TCar;
import com.rent.entity.TCarFeatures;
import com.rent.entity.TFeatures;
import com.rent.form.TCarInfoBean;
import com.rent.service.ITCarFeaturesService;
import com.rent.service.ITCarService;
import com.rent.service.ITFeaturesService;
import com.rent.utils.ResponseCode;
import com.rent.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rent
 * @since 2019-04-09
 */
@Controller
@RequestMapping("/admin/car")
public class TCarController {

    @Autowired
    private ITCarService iTCarService;

    @Autowired
    private ITFeaturesService itFeaturesService;
    @Autowired
    private ITCarFeaturesService carFeaturesService;

    /**
     * 创建
     *
     * @return
     */
    @PostMapping(value = "/create", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String create(@Validated TCarInfoBean infoBean
            , BindingResult bindingResult) throws IOException {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            System.out.println(errorList.toString());
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }

        if (infoBean.getFile() != null) {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(), "static/images/upload/");
            if (!upload.exists()) {
                upload.mkdirs();
                System.out.println(upload.getAbsolutePath());
            }

            MultipartFile file = infoBean.getFile();
            String name = file.getOriginalFilename();
            String filename = UUID.randomUUID().toString().replaceAll("-", "") + name.substring(name.lastIndexOf("."), name.length());
            String finalPath = upload.getAbsolutePath() + File.separator + filename;

            System.out.println(finalPath);
            File target = new File(finalPath);
            file.transferTo(target);
            infoBean.setImage(filename);
        }

        infoBean.setStatus(TCar.STATUS_NORMAL);
        if (iTCarService.add(infoBean)) {
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
    @RequestMapping(value = "/update")
    public String update(TCarInfoBean infoBean) {
        TCar entity = iTCarService.selectById(infoBean.getId());
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        iTCarService.updateById(
                infoBean.toTCar(entity));
        return "redirect:/admin/car/index";

    }


    /**
     * 更新
     *
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(TCarInfoBean infoBean) throws IOException {
        TCar entity = iTCarService.selectById(infoBean.getId());
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }

        if (infoBean.getFile() != null) {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(), "static/images/upload/");
            File old = new File(path.getAbsolutePath(), "static/images/upload/" + entity.getImage());
            if(old.exists()){
                old.delete();
            }
            if (!upload.exists()) {
                upload.mkdirs();
                System.out.println(upload.getAbsolutePath());
            }

            MultipartFile file = infoBean.getFile();
            String name = file.getOriginalFilename();
            String filename = UUID.randomUUID().toString().replaceAll("-", "") + name.substring(name.lastIndexOf("."), name.length());
            String finalPath = upload.getAbsolutePath() + File.separator + filename;
            File target = new File(finalPath);
            file.transferTo(target);
            infoBean.setImage(filename);
        }
        if (iTCarService.updateCar(entity,infoBean)) {
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
    @RequestMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable("id") Integer id, Map<String,Object> model) {
        TCar entity = iTCarService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.PARAMS_WRONG);
        }
        model.put("car",entity);
        List<TFeatures> featuresList = itFeaturesService.selectList(new EntityWrapper<TFeatures>());

        model.put("features",carFeaturesService.selectIdsByCar(entity.getId()));
        model.put("featuresList", featuresList);

        return "admin/editCar";

    }
    /**
     * 关闭
     *
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        TCar entity = iTCarService.selectById(id);
        if (entity == null) {
            return ResultBuilder.buildResponseCode(ResponseCode.DATA_NOT_EXIST);
        }
        if (iTCarService.deleteById(id)) {
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
    public String index(Map<String, Object> map, @RequestParam(required = false) TCarInfoBean infoBean) {
        if (infoBean == null) {
            infoBean = new TCarInfoBean();
        }
        map.put("result", iTCarService.findTCars(infoBean));
        return "admin/cars";
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Map<String,Object> model) {
        model.put("features",itFeaturesService.selectList(new EntityWrapper<TFeatures>()));
        return "admin/addCar";
    }
}
