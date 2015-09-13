package com.sino.godlike.model.po;

import java.io.Serializable;

/**
 * Created by pierce-deng on 2015/9/5.
 */
public class CityPo implements Serializable {

    private static final long serialVersionUID = 4747832512031997771L;
    private String cityId;
    private String provinceId;
    private String name;
    private String code;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CityPo{" +
                "cityId='" + cityId + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
