package com.example.manager.wxmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.manager.wxmanager.dao.RepairDAO;
import com.example.manager.wxmanager.dao.UserDAO;
import com.example.manager.wxmanager.model.RepairModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.CommonUtil;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.RepairService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RepairDAO repairDAO;
    @Override
    public ResultModel add(RepairModel repairModel) {
        //查询报修人的位置和宿舍号是否绑定，未绑定不能发起报修
        UserModel userModel = new UserModel();
        userModel.setUserCode(repairModel.getUserCode());
        userModel = userDAO.selectOne(userModel);
        if(CommonUtil.isNull(userModel.getDormitoryCode())){
            return new ResultModel(false,"用户未填写宿舍号","",2);
        }
        if(CommonUtil.isNull(userModel.getUserAddressCode())){
            return new ResultModel(false,"用户未选择位置","",2);
        }
        if(CommonUtil.isNull(repairModel.getRepairContent())){
            return new ResultModel(false,"报修描述不能为空","",1);
        }
        repairModel.setCreateTime(DateUtil.getDate(new Date()));
        repairModel.setDataFlag(0L);
        repairModel.setRepairCode(String.valueOf(new Date().getTime()));
        repairModel.setRepairStatus(0L);
        int insert = repairDAO.insert(repairModel);
        if(insert == 0){
            return new ResultModel(false,"发起失败");
        }
        return new ResultModel(true,"发起成功");
    }

    @Override
    public ResultModel update(RepairModel repairModel) {
        Example example = new Example(RepairModel.class);
        example.createCriteria().andEqualTo("repairCode",repairModel.getRepairCode());
        repairModel.setModifyTime(DateUtil.getDate(new Date()));
        int i = repairDAO.updateByExampleSelective(repairModel, example);
        if(i == 0){
            return new ResultModel(false,"更新失败");
        }
        return new ResultModel(true,"更新成功");
    }

    @Override
    public PageInfo<RepairModel> query(RepairModel repairModel) {
        PageHelper.startPage(repairModel);
        List<RepairModel> query = repairDAO.query(repairModel);
        query.forEach(repairModel1 -> {
            repairModel1.setRepairImgList((List<String>)JSONObject.parse(repairModel1.getRepairImgs()));
        });
        PageInfo<RepairModel> pageInfo = new PageInfo<RepairModel>(query);
        return pageInfo;
    }
}
