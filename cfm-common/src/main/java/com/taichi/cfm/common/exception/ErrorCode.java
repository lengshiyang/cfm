/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package com.taichi.cfm.common.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyang.leng
 * on 2019/05/30
 * ClassDescription： 错误编码
 */
public enum ErrorCode {

    SUCCESS("0000", "处理成功"),
    FAILED("3000", "处理失败"),
    OTHER_ERR("9999", "其他错误");

    /** 枚举值 */
    private final String code;

    /** 枚举描述 */
    private final String message;

    /**
     * 构造一个<code>ErrorCode</code>枚举对象
     *
     * @param code
     * @param message
     */
    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code.
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return ErrorCode
     */
    public static ErrorCode getByCode(String code) {
        for (ErrorCode _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ErrorCode>
     */
    public List<ErrorCode> getAllEnum() {
        List<ErrorCode> list = new ArrayList<ErrorCode>();
        for (ErrorCode _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (ErrorCode _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

}