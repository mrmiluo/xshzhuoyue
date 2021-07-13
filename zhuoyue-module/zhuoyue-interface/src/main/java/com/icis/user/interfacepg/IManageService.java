package com.icis.user.interfacepg;

import com.icis.pojo.BaseAttrInfo;
import com.icis.pojo.BaseCatalog1;
import com.icis.pojo.BaseCatalog2;
import com.icis.pojo.BaseCatalog3;

import java.util.List;

/**
 * @author LYQ
 */
public interface IManageService {
    //查询所有一级分类
    List<BaseCatalog1> findAllBaseCatalog1();

    //查询所有二级分类
    List<BaseCatalog2> findBaseCatalog2ByCatalog1Id(String catalog1Id);

    //查询所有三级分类
    List<BaseCatalog3> findBaseCatalog3ByCatalog2Id(String catalog2Id);

    //显示商品的信息内容
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    //修改基本信息
    BaseAttrInfo getAttrInfo(String attrId);

    //添加属性
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
