package com.icis.commonmapper.service.impl;

import com.icis.commonmapper.mapper.UserInfoMapper;
import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LYQ
 */
@Service
public class IUserInfoServiceImpl implements IUserInfoService {

    //注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    //查询所有用户
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }


}
