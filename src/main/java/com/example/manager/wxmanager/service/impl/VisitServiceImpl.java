package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.VisitDAO;
import com.example.manager.wxmanager.model.RepairModel;
import com.example.manager.wxmanager.model.VisitModel;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.VisitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitDAO visitDAO;
    @Override
    public ResultModel add(VisitModel visitModel) {
        visitModel.setCreateTime(DateUtil.getDate(new Date()));
        visitModel.setDataFlag(0L);
        visitModel.setVisitCode(DateUtil.getCode());
        int insert = visitDAO.insert(visitModel);
        if(insert == 0){
            return new ResultModel(false,"添加失败");
        }
        return new ResultModel(true,"添加成功");
    }

    @Override
    public PageInfo<VisitModel> query(VisitModel visitModel) {
        PageHelper.startPage(visitModel);
        List<VisitModel> visitModelList = visitDAO.query(visitModel);
        PageInfo<VisitModel> pageInfo = new PageInfo<VisitModel>(visitModelList);
        return pageInfo;
    }
}
