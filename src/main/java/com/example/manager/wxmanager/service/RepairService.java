package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.RepairModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;

public interface RepairService {
    ResultModel add(RepairModel repairModel);

    ResultModel update(RepairModel repairModel);

    PageInfo<RepairModel> query(RepairModel repairModel);
}
