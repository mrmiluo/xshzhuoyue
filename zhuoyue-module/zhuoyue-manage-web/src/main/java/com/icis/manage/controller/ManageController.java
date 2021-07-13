package com.icis.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icis.pojo.BaseAttrInfo;
import com.icis.pojo.BaseCatalog1;
import com.icis.pojo.BaseCatalog2;
import com.icis.pojo.BaseCatalog3;
import com.icis.user.interfacepg.IManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LYQ
 */
@Controller
@CrossOrigin
public class ManageController {

    //引用服务 接口
    @Reference
    private IManageService iManageService;

    //查询一级分类    返回json数据
    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getBaseCatalog1(){
        return iManageService.findAllBaseCatalog1();
    }

    //根据一级分类获得二级分类
    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getBaseCatalog2(String catalog1Id){
        return iManageService.findBaseCatalog2ByCatalog1Id(catalog1Id);
    }

    //根据二级分类获得三级分类
    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getBaseCatalog3(String catalog2Id){
        return iManageService.findBaseCatalog3ByCatalog2Id(catalog2Id);
    }

    //根据三级分类获得商品信息  http://localhost:8082/attrInfoList?catalog3Id=1
    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id){
        return iManageService.getAttrList(catalog3Id);
    }

    //http://localhost:8082/getAttrValueList?attrId=23
    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public BaseAttrInfo getAttrValueList(String attrId){
        return iManageService.getAttrInfo(attrId);
    }

    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        // 调用服务层做保存方法
        iManageService.saveAttrInfo(baseAttrInfo);
    }
}
