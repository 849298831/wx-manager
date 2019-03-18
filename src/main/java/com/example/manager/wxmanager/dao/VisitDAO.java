package com.example.manager.wxmanager.dao;

import com.example.manager.wxmanager.model.VisitModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VisitDAO extends Mapper<VisitModel> {
    List<VisitModel> query(VisitModel visitModel);
}
