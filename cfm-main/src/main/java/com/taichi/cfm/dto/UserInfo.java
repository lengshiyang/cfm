
package com.taichi.cfm.dto;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    /**姓名*/
    private String name;
    /**头像*/
    private String avatar;
    /**id*/
    private String userid;
    /**邮箱*/
    private String email;
    /**个性签名*/
    private String signature;
    /**职级*/
    private String title;
    /**部门*/
    private String group;
    /**标签*/
    private List<UserAdditionalInfo> tags;

    private int notifyCount = 12;
    private int unreadCount = 11;
    private String country;
    private Geographic geographic;
    private String address;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<UserAdditionalInfo> getTags() {
        return tags;
    }

    public void setTags(List<UserAdditionalInfo> tags) {
        this.tags = tags;
    }

    public int getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(int notifyCount) {
        this.notifyCount = notifyCount;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Geographic getGeographic() {
        return geographic;
    }

    public void setGeographic(Geographic geographic) {
        this.geographic = geographic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}