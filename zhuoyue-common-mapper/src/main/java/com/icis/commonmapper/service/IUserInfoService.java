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
}
