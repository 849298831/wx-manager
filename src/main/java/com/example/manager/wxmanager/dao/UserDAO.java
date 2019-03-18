package com.example.manager.wxmanager.dao;

import com.example.manager.wxmanager.model.UserModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDAO extends Mapper<UserModel> {

    UserModel getUeryByLogin(UserModel userModel);

    List<UserModel> query(UserModel userModel);

    List<UserModel> queryUserByAddress(UserModel userModel);
}
