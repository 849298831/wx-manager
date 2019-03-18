package com.example.manager.wxmanager.dao;

import com.example.manager.wxmanager.model.RepairModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RepairDAO extends Mapper<RepairModel> {
    List<RepairModel> query(RepairModel repairModel);
}
