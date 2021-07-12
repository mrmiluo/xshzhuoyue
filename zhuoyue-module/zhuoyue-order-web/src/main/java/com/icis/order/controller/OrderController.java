package com.icis.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icis.pojo.UserAddress;
import com.icis.user.interfacepg.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LYQ
 * 订单控制器
 */
@Controller
public class OrderController {

    //地址接口服务
    @Reference  //注入本地的bean
    private IUserAddressService userAddressService;
    //定义一个方法    根据用户id获得用户地址
    @RequestMapping("/trade")
    @ResponseBody
    public List<UserAddress> getAddressListByUserId(String userId){
        return userAddressService.getUserAddressByUserId(userId);
    }
}
