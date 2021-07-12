package com.icis.user.interfacepg;

import com.icis.pojo.UserAddress;

import java.util.List;

/**
 * @author LYQ
 * 用户地址服务接口
 */
public interface IUserAddressService {

    //根据用户id  查询用户地址列表
    List<UserAddress> getUserAddressByUserId(String uid);
}
