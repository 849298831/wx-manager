package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.VisitModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.VisitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 人员来访控制器
 */
@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;

    /**
     * 添加来访
     */
    @RequestMapping("/add")
    public ResultModel add(VisitModel visitModel, HttpSession httpSession) {
        UserModel userModel = (UserModel) httpSession.getAttribute("user");
        if(userModel == null){
            return new ResultModel(false,"未登录","",1);
        }
        if(userModel.getIsAdmin() == 2){
            return new ResultModel(false,"超级管理员不能添加来访");
        }
        visitModel.setAddressCode(userModel.getUserAddressCode());
        return visitService.add(visitModel);
    }

    /**
     * 查询来访人员信息
     */
    @RequestMapping("/query")
    public ResultModel query(HttpSession httpSession,VisitModel visitModel){
        if(visitModel.getPage() != null){
            visitModel.setPageNum(visitModel.getPage());
            visitModel.setPageSize(visitModel.getLimit());
            UserModel session = (UserModel) httpSession.getAttribute("user");
            if(session != null && session.getIsAdmin() != 2){
                visitModel.setAddressCode(session.getUserAddressCode());
            }
        }
        PageInfo<VisitModel> pageInfo = visitService.query(visitModel);
        return new ResultModel(true,"",pageInfo);
    }
}
