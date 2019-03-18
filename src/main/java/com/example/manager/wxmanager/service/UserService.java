package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;

public interface UserService {

    /**
     * 根据openId查询用户信息
     */
    UserModel getUserByOpenId(UserModel userModel);

    UserModel insertUser(UserModel userModel);

    ResultModel updateUser(UserModel userModel);

    ResultModel register(UserModel userModel);

    ResultModel adminLogin(UserModel userModel);

    /**
     * 根据userCode查询用户信息
     */
    UserModel getUserByCode(UserModel userModel);

    PageInfo<UserModel> query(UserModel userModel);
}
