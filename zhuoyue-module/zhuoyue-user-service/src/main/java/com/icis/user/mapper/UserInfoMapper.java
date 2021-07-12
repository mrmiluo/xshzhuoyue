package com.icis.user.mapper;

import com.icis.pojo.UserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author LYQ
 * 用户接口 继承通用mapper接口
 */
public interface UserInfoMapper extends Mapper<UserInfo> {

    // 查询所有用户的方法
    List<UserInfo> findAll();

    //根据逐渐查询一个用户
    UserInfo findUserByPrimaryKey(UserInfo userInfo);
}
