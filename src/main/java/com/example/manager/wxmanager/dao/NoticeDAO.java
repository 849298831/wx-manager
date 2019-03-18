package com.example.manager.wxmanager.dao;

import com.example.manager.wxmanager.model.NoticeModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NoticeDAO extends Mapper<NoticeModel> {

    List<NoticeModel> query(NoticeModel noticeModel);
}
