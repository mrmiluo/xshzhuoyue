package com.icis.user.service;


import com.icis.pojo.UserInfo;
import com.icis.user.interfacepg.IUserInfoService;
import com.icis.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public UserInfo findUserByPrimaryKey(UserInfo userInfo) {
        return userInfoMapper.selectByPrimaryKey(userInfo);
    }

    //根据条件查询
    @Override
    public List<UserInfo> findUserByUserProperty(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    //模糊查询
    @Override
    public List<UserInfo> findUserByLikeName(UserInfo userInfo) {
        // 封装条件 %value%
        // 模板 查询条件通过模板封装
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //根据名字 模糊查询
        criteria.andLike("name", "%" + userInfo.getName() + "%");
        criteria.andGreaterThan("id", userInfo.getId());
        return userInfoMapper.selectByExample(example);
    }

}
