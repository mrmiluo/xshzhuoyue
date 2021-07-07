package com.icis.commonmapper.controller;

import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LYQ
 */
@Controller
@ResponseBody   //作用域该类下面的所有的方法
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    //查询所有用户列表
    @RequestMapping("/getAll")
    public List<UserInfo> findAllUser(){
        return iUserInfoService.findAll();
    }
}
