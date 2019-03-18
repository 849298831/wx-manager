package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.AddressModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;

import javax.servlet.jsp.tagext.PageData;

public interface AddressService {
    ResultModel add(AddressModel addressModel);
    ResultModel del(AddressModel addressModel);
    PageInfo<AddressModel> query(AddressModel addressModel);
}
