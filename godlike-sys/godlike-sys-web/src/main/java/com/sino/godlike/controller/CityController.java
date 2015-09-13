package com.sino.godlike.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sino.godlike.model.po.CityPo;
import com.sino.godlike.service.inter.CityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pierce-deng on 2015/8/19.
 */
@Controller
@RequestMapping("/cityController")
public class CityController {
    @Reference(version = "1.0.0")
    CityService cityService;
    public static Logger logger;

    static {
        logger = Logger.getLogger(CityController.class.getName());
    }

    @RequestMapping("/findall")
    public String findall(HttpServletRequest request) {
        List list = cityService.findall();
        logger.debug("*****************************************************************************************************");
        System.out.println(list);
        return "/aa/aa";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request) {
        CityPo cityPo = new CityPo();
        cityPo.setName("长治市");
        cityPo.setCode("888888");
        cityService.update(cityPo);
        //todo 给缓存系统发送同步通知
        return "/aa/aa";
    }
}
