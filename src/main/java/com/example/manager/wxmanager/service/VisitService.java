package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.VisitModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;

public interface VisitService {
    ResultModel add(VisitModel visitModel);

    PageInfo<VisitModel> query(VisitModel visitModel);
}
