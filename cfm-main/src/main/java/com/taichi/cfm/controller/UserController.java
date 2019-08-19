
package com.taichi.cfm.controller;

import com.taichi.cfm.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);



    @RequestMapping("api/login/account")
    @ResponseBody
    public UserLoginResult loginHandler(@RequestBody UserLoginInfo loginInfo) {
        UserLoginResult result = new UserLoginResult();
        if("account".equals(loginInfo.getType()) && "1234".equals(loginInfo.getPassword())){
            result.setStatus("ok");
            result.setType(loginInfo.getType());
            result.setCurrentAuthority("admin");
            return result;
        }
        result.setStatus("error");
        result.setType(loginInfo.getType());
        result.setCurrentAuthority("admin");
        return result;
    }

    @RequestMapping(value="/api/currentUser")
    @ResponseBody
    public UserInfo currentUser(HttpServletRequest request) {
        return getDefaultUser();
    }
    private UserInfo getDefaultUser(){
        UserInfo user = new UserInfo();
        user.setName("Serati Ma");
        user.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
        user.setUserid("00000001");
        user.setEmail("shiyang.leng");
        user.setSignature("海纳百川，有容乃大");
        user.setTitle("交互专家");
        user.setGroup("蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED");
        List<UserAdditionalInfo> tags = new ArrayList<>();
        UserAdditionalInfo tag1 = new UserAdditionalInfo();
        tag1.setKey("0001");
        tag1.setLabel("彪悍");
        tags.add(tag1);
        user.setTags(tags);

        user.setUnreadCount(11);
        user.setNotifyCount(12);
        user.setCountry("中国");

        Geographic geographic = new Geographic();
        UserAdditionalInfo province = new UserAdditionalInfo();
        province.setKey("330000");
        province.setLabel("浙江省");

        UserAdditionalInfo city = new UserAdditionalInfo();
        city.setKey("330100");
        city.setLabel("杭州市");
        geographic.setCity(city);
        user.setGeographic(geographic);
        user.setAddress("西湖区工专路 77 号");
        user.setPhone("0752-268888888");
        return user;
    }
}