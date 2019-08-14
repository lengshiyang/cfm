package com.taichi.cfm.domain.model;

import com.taichi.cfm.domain.data.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @desc	使用代码生成器生成.
 * @date 	2018/11/27
 */
@Entity
@Table(name = "base_config")
public class BasicParamConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 类型  */
    @Column(name = "type" ,length = 32 ,nullable = false)
    private String type ;

    /** 参数编码  */
    @Column(name = "param_code" ,length = 64 ,nullable = false)
    private String paramCode ;

    /** 参数值  */
    @Column(name = "param_value" ,length = 255 ,nullable = false)
    private String paramValue ;

    /** 系统编码  */
    @Column(name = "system_code" ,length = 32 ,nullable = false)
    private String systemCode ;

    /** 备注  */
    @Column(name = "memo" ,length = 255)
    private String memo ;

    /** 操作人  */
    @Column(name = "operator_code" ,length = 32)
    private String operatorCode ;

    /**
     @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP) */
    @Column(name = "time_insert")
    private java.util.Date timeInsert ;

    /**
     @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP) */
    @Column(name = "time_update")
    private java.util.Date timeUpdate ;

    /** 类型 */
    public void setType (String type){
        this.type = type ;
    }

    /** 类型  */
    public String getType (){
        return this.type ;
    }

    /** 参数编码 */
    public void setParamCode (String paramCode){
        this.paramCode = paramCode ;
    }

    /** 参数编码  */
    public String getParamCode (){
        return this.paramCode ;
    }

    /** 参数值 */
    public void setParamValue (String paramValue){
        this.paramValue = paramValue ;
    }

    /** 参数值  */
    public String getParamValue (){
        return this.paramValue ;
    }

    /** 系统编码 */
    public void setSystemCode (String systemCode){
        this.systemCode = systemCode ;
    }

    /** 系统编码  */
    public String getSystemCode (){
        return this.systemCode ;
    }

    /** 备注 */
    public void setMemo (String memo){
        this.memo = memo ;
    }

    /** 备注  */
    public String getMemo (){
        return this.memo ;
    }

    /** 操作人 */
    public void setOperatorCode (String operatorCode){
        this.operatorCode = operatorCode ;
    }

    /** 操作人  */
    public String getOperatorCode (){
        return this.operatorCode ;
    }

    /**  */
    public void setTimeInsert (java.util.Date timeInsert){
        this.timeInsert = timeInsert ;
    }

    /**   */
    public java.util.Date getTimeInsert (){
        return this.timeInsert ;
    }

    /**  */
    public void setTimeUpdate (java.util.Date timeUpdate){
        this.timeUpdate = timeUpdate ;
    }

    /**   */
    public java.util.Date getTimeUpdate (){
        return this.timeUpdate ;
    }

}