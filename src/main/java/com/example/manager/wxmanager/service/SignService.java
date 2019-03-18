package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.RepairModel;
import com.example.manager.wxmanager.model.SignInModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;

public interface SignService {

    ResultModel add(SignInModel signInModel) throws ParseException;

    ResultModel update(SignInModel signInModel);

    PageInfo<SignInModel> query(SignInModel signInModel);
}
