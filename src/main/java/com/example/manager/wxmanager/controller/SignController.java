package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.SignInModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.SignService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * 签到控制器
 */
@RestController
@RequestMapping("/sign")
public class SignController{
    @Autowired
    private SignService signService;

    /**
     * 学生签到 自身位置与坐标点距离暂定各位100m
     */
    @RequestMapping("/add")
    public ResultModel add(SignInModel signInModel) throws ParseException {
        return signService.add(signInModel);
    }
    /**
     * 更新报修
     */
    @RequestMapping("/update")
    public ResultModel update(SignInModel signInModel){
        return
                signService.update(signInModel);
    }
    /**
     * 查询所有报修
     */
    @RequestMapping("/query")
    public ResultModel query(SignInModel signInModel,HttpSession httpSession){
        if(signInModel.getPage() != null){
            signInModel.setPageNum(signInModel.getPage());
            signInModel.setPageSize(signInModel.getLimit());
            UserModel userModel = (UserModel) httpSession.getAttribute("user");
            if(userModel != null && userModel.getIsAdmin() != 2){
                signInModel.setAddressCode(userModel.getUserAddressCode());
            }
        }
        PageInfo<SignInModel> query = signService.query(signInModel);
        return new ResultModel(true,"",query,0);
    }
}
