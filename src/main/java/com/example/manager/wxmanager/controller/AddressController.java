package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.AddressModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.AddressService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 坐标点控制器
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    /**
     * 添加坐标点
     */
    @RequestMapping("/add")
    public ResultModel add(AddressModel addressModel){
        return addressService.add(addressModel);
    }
    /**
     * 删除坐标点
     */
    @RequestMapping("/del")
    public ResultModel del(AddressModel addressModel){
        return addressService.del(addressModel);
    }
    /**
     * 查询所有坐标点
     */
    @RequestMapping("/query")
    public ResultModel query(AddressModel addressModel,HttpSession httpSession){
        UserModel userModel = (UserModel) httpSession.getAttribute("user");
        if(userModel != null && userModel.getIsAdmin() != 2){
            addressModel.setAddressCode(userModel.getUserAddressCode());
        }
        if(addressModel.getPage() != null){
            addressModel.setPageNum(addressModel.getPage());
            addressModel.setPageSize(addressModel.getLimit());
        }
        PageInfo<AddressModel> query = addressService.query(addressModel);
        return new ResultModel(true,"",query);
    }
}
