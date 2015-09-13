package com.sino.godlike.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sino.godlike.dao.mapper.CityPOMapper;
import com.sino.godlike.model.po.CityPo;
import com.sino.godlike.service.inter.CityService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pierce-deng on 2015/8/19.
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {
    @Resource
    CityPOMapper cityPOMapper;

    public static Logger logger;

    static {
        logger = Logger.getLogger(CityServiceImpl.class.getName());
    }

    @Override
    public List<CityPo> findall() {
        logger.debug("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return cityPOMapper.findall();
    }

    @Override
    public void update(CityPo cityPo) {
        cityPOMapper.update(cityPo);
    }
}
