package com.icis.commonmapper.controller;

import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LYQ
 */
/*@Controller
@ResponseBody   //作用域该类下面的所有的方法*/
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    //查询所有用户列表
    @RequestMapping("/getAll")
    public List<UserInfo> findAllUser(){
        return iUserInfoService.findAll();
    }

    //根据主键查询一个用户
    @RequestMapping("/getUserByPrimaryKey")
    public UserInfo getUserByPrimaryKey(String uid){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(uid);
        return iUserInfoService.findUserByPrimaryKey(userInfo);
    }

    //根据给出的属性查询数据
    @RequestMapping("/findByProperty")
    public List<UserInfo> getUserByProperty(UserInfo userInfo){
        return iUserInfoService.findUserByUserProperty(userInfo);
    }

    //根据名字模糊查询
    @GetMapping("/findByLikeName")
    public List<UserInfo> findByUserLikeName(UserInfo userInfo){
        return iUserInfoService.findUserByLikeName(userInfo);
    }
}
