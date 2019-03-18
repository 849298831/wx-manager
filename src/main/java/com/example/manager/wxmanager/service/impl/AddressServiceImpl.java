package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.AddressDAO;
import com.example.manager.wxmanager.dao.UserDAO;
import com.example.manager.wxmanager.model.AddressModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.CommonUtil;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private UserDAO userDAO;
    @Override
    public ResultModel add(AddressModel addressModel) {
        //判断是否已有相同坐标点
        AddressModel query = new AddressModel();
        query.setAddressName(addressModel.getAddressName());
        query.setAddressDetail(addressModel.getAddressDetail());
        List<AddressModel> select = addressDAO.select(query);
        if(!CollectionUtils.isEmpty(select)){
            return new ResultModel(false,"已有相同坐标点");
        }
        addressModel.setAddressCode(DateUtil.getCode());
        addressModel.setCreateTime(DateUtil.getDate(new Date()));
        addressModel.setDataFlag(0L);
        addressDAO.insert(addressModel);
        return new ResultModel(true,"添加坐标点成功");
    }

    @Override
    public ResultModel del(AddressModel addressModel) {
        //判断是否可以删除坐标点
        UserModel userModel = new UserModel();
        userModel.setUserAddressCode(addressModel.getAddressCode());
        List<UserModel> userModels = userDAO.queryUserByAddress(userModel);
        if(!CollectionUtils.isEmpty(userModels)){
            return new ResultModel(false,"该坐标点不能删除，请确认是否所有学生与管理员已经解除绑定");
        }
        AddressModel del = new AddressModel();
        del.setAddressCode(addressModel.getAddressCode());
        del.setDataFlag(1L);
        Example example = new Example(AddressModel.class);
        example.createCriteria().andEqualTo("addressCode",addressModel.getAddressCode());
        int i = addressDAO.updateByExampleSelective(del, example);
        if(i > 0){
            return new ResultModel(true,"删除成功");
        }
        return new ResultModel(false,"删除失败");
    }

    @Override
    public PageInfo<AddressModel> query(AddressModel addressModel) {
        PageHelper.startPage(addressModel);
        Example example = new Example(AddressModel.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("dataFlag", 0L);
        if(!CommonUtil.isNull(addressModel.getAddressCode())){
            criteria.andEqualTo("addressCode",addressModel.getAddressCode());
        }
        List<AddressModel> addressModels = addressDAO.selectByExample(example);
        PageInfo<AddressModel> pageInfo = new PageInfo<>(addressModels);
        return pageInfo;
    }
}
