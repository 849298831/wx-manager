package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.NoticeDAO;
import com.example.manager.wxmanager.model.NoticeModel;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDAO noticeDAO;
    @Override
    public ResultModel add(NoticeModel noticeModel) {
        noticeModel.setCreateTime(DateUtil.getDate(new Date()));
        noticeModel.setDataFlag(0L);
        noticeModel.setNoticeCode(DateUtil.getCode());
        int insert = noticeDAO.insert(noticeModel);
        if(insert == 0){
            return new ResultModel(false,"发布失败");
        }
       return new ResultModel(true,"发布成功");
    }

    @Override
    public PageInfo<NoticeModel> query(NoticeModel noticeModel) {
        PageHelper.startPage(noticeModel);
        List<NoticeModel> noticeModels = noticeDAO.query(noticeModel);
        PageInfo<NoticeModel> pageInfo = new PageInfo<>(noticeModels);
        return pageInfo;
    }

    @Override
    public ResultModel del(NoticeModel noticeModel) {
        Example example = new Example(NoticeModel.class);
        example.createCriteria().andEqualTo("noticeCode",noticeModel.getNoticeCode());
        int i = noticeDAO.updateByExampleSelective(noticeModel, example);
        if(i == 0){
            return new ResultModel(false,"删除失败");
        }
        return new ResultModel(true,"删除成功");
    }
}
