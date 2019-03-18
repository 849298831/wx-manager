package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.AddressModel;
import com.example.manager.wxmanager.model.NoticeModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.NoticeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 公告实体类
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    /**
     * 发起公告
     */
    @RequestMapping("/add")
    public ResultModel add(NoticeModel noticeModel,HttpSession httpSession){
        UserModel userModel = (UserModel) httpSession.getAttribute("user");
        if(userModel == null){
            return new ResultModel(false,"未登录","",1);
        }
        if(userModel.getIsAdmin() != 2){
            noticeModel.setAddressCode(userModel.getUserAddressCode());
        }
        noticeModel.setUserCode(userModel.getUserCode());
        return noticeService.add(noticeModel);
    }
    /**
     * 查询公告
     */
    @RequestMapping("/query")
    public ResultModel query(NoticeModel noticeModel,HttpSession httpSession){
        if(noticeModel.getPage() != null){
            noticeModel.setPageNum(noticeModel.getPage());
            noticeModel.setPageSize(noticeModel.getLimit());
            UserModel userModel = (UserModel) httpSession.getAttribute("user");
            if(userModel != null && userModel.getIsAdmin() != 2){
                noticeModel.setAddressCode(userModel.getUserAddressCode());
            }
        }
        PageInfo<NoticeModel> query = noticeService.query(noticeModel);
        return new ResultModel(true,"",query);
    }
    /**
     * 删除公告
     */
    @RequestMapping("/del")
    public ResultModel del(NoticeModel noticeModel){
        return  noticeService.del(noticeModel);
    }

}
