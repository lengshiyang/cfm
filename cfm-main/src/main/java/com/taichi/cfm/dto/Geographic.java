package com.taichi.cfm.dto;

/**
 * Created by shiyang.leng
 * on 2019/6/3
 * ClassDescription：
 */
public class Geographic {
    private UserAdditionalInfo province;
    private UserAdditionalInfo city;

    public UserAdditionalInfo getProvince() {
        return province;
    }

    public void setProvince(UserAdditionalInfo province) {
        this.province = province;
    }

    public UserAdditionalInfo getCity() {
        return city;
    }

    public void setCity(UserAdditionalInfo city) {
        this.city = city;
    }
}
