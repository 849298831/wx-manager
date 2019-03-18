package com.example.manager.wxmanager.dao;

import com.example.manager.wxmanager.model.SignInModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SignDAO extends Mapper<SignInModel> {
    List<SignInModel> query(SignInModel signInModel);
}
