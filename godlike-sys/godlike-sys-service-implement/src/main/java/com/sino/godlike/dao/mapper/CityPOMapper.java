package com.sino.godlike.dao.mapper;

import com.sino.godlike.model.po.CityPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pierce-deng on 2015/8/18.
 */
@Repository
public interface CityPOMapper {
    List<CityPo> findall();

    void update(CityPo cityPo);
}
