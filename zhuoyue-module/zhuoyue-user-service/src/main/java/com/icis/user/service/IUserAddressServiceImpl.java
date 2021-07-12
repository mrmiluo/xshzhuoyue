package com.icis.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.pojo.UserAddress;
import com.icis.user.interfacepg.IUserAddressService;
import com.icis.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LYQ
 *
 */
// 一个新的注解把服务从spring本地放入到zookeeper
@Service
public class IUserAddressServiceImpl implements IUserAddressService {
    //注入mapper
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> getUserAddressByUserId(String uid) {
        //创建一个用户
        UserAddress userAddress = new UserAddress();
        userAddress.setId(uid);
        return userAddressMapper.select(userAddress);
    }
}
