package com.sino.godlike.service.inter;

import com.sino.godlike.model.po.CityPo;

import java.util.List;

/**
 * Created by pierce-deng on 2015/9/5.
 */
public interface CityService {
    List<CityPo> findall();

    void update(CityPo cityPo);
}
