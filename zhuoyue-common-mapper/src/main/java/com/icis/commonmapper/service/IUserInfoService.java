package com.icis.commonmapper.service;

import com.icis.commonmapper.pojo.UserInfo;

import java.util.List;

/**
 * @author LYQ
 * 用户接口
 */
public interface IUserInfoService {

    // 查询所有用户的方法
    List<UserInfo> findAll();

    //根据逐渐查询一个用户
    UserInfo findUserByPrimaryKey(UserInfo userInfo);

    //根据其他字段查询数据
    List<UserInfo> findUserByUserProperty(UserInfo userInfo);

    //根据名字模糊查询
    List<UserInfo> findUserByLikeName(UserInfo userInfo);
}
