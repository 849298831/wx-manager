package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.NoticeModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;


public interface NoticeService {

    ResultModel add(NoticeModel noticeModel);

    PageInfo<NoticeModel> query(NoticeModel noticeModel);

    ResultModel del(NoticeModel noticeModel);
}
