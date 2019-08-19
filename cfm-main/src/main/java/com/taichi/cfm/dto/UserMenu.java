
package com.taichi.cfm.dto;

import java.io.Serializable;
import java.util.List;

public class UserMenu implements Serializable{

    private static final long serialVersionUID = 7994834691232397618L;
    /*菜单编码*/
    private String code;
    /*菜单名*/
    private String name;
    /*菜单url*/
    private String path;
    /*子菜单*/
    private List<UserMenu> routes;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<UserMenu> getRoutes() {
        return routes;
    }

    public void setRoutes(List<UserMenu> routes) {
        this.routes = routes;
    }
}