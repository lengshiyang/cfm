package com.taichi.cfm.service.dto;

import com.taichi.cfm.domain.annotations.Condition;
import com.taichi.cfm.domain.annotations.JpaCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * <p> 基础参数配置查询实体 ----用于查询</p>
 */
public class QueryBasicParamConfigBO implements Serializable {

    private static final long serialVersionUID = -724820871216401742L;

    /** 参数编码*/
    @JpaCondition(field = "paramCode", operator = Condition.Operator.EQ)
    private String  paramCode;

    /** 参数值*/
    @JpaCondition(field = "paramValue",operator = Condition.Operator.LIKE)
    private String  paramValue;

    /** 系统编码*/
    @JpaCondition(field = "systemCode",operator = Condition.Operator.EQ)
    private String  systemCode;

    /** 类型*/
    @JpaCondition(field = "type",operator = Condition.Operator.EQ)
    private String  type;

    /** 创建时间   timeInsert---和model中的实体类（同数据库打交道的类）的属性名一样*/
    @JpaCondition(field = "timeInsert",operator = Condition.Operator.GTE)
    private Date timeInsertStart;

    @JpaCondition(field = "timeInsert",operator = Condition.Operator.LTE)
    private Date timeInsertEnd;

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimeInsertStart() {
        return timeInsertStart;
    }

    public void setTimeInsertStart(Date timeInsertStart) {
        this.timeInsertStart = timeInsertStart;
    }

    public Date getTimeInsertEnd() {
        return timeInsertEnd;
    }

    public void setTimeInsertEnd(Date timeInsertEnd) {
        this.timeInsertEnd = timeInsertEnd;
    }
}
