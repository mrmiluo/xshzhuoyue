package com.icis.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.manage.mapper.*;
import com.icis.pojo.*;
import com.icis.user.interfacepg.IManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LYQ
 */
@Service
public class IManageServiceImpl implements IManageService {

    //注入一级分类的mapper
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;

    //注入二级级分类的mapper
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;

    //注入三级级分类的mapper
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    //注入基本信息的mapper
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseCatalog1> findAllBaseCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> findBaseCatalog2ByCatalog1Id(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> findBaseCatalog3ByCatalog2Id(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        return baseAttrInfoMapper.select(baseAttrInfo);
    }

    @Override
    public BaseAttrInfo getAttrInfo(String attrId) {
        BaseAttrInfo attrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrInfo.getId());
        List<BaseAttrValue> attrValues = baseAttrValueMapper.select(baseAttrValue);
        attrInfo.setAttrValueList(attrValues);
        return attrInfo;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //如果有主键就进行更新，如果没有就插入
        if (baseAttrInfo.getId() != null && baseAttrInfo.getId().length() > 0){
            baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        }else {
            baseAttrInfo.setId(null);
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        //把原属性值全部清空
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValue);

        //重新插入属性值
        if (baseAttrInfo.getAttrValueList() != null && baseAttrInfo.getAttrValueList().size() > 0){
            for (BaseAttrValue attrValue : baseAttrInfo.getAttrValueList()) {
                //防止主键被附上一个字符串
                attrValue.setId(null);
                attrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(attrValue);
            }
        }
    }
}
