package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.UserDAO;
import com.example.manager.wxmanager.model.NoticeModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.CommonUtil;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserModel getUserByOpenId(UserModel userModel) {
        Example example = new Example(UserModel.class);
        example.createCriteria().andEqualTo("wxOpenId",userModel.getWxOpenId());
        List<UserModel> userModels = userDAO.selectByExample(example);
        if (CollectionUtils.isEmpty(userModels)) {
            return null;
        }
        return userModels.get(0);
    }

    @Override
    public UserModel insertUser(UserModel userModel) {
        userModel.setUserCode(DateUtil.getCode());
        userModel.setDataFlag(0L);
        userModel.setCreateTime(DateUtil.getDate(new Date()));
        userDAO.insert(userModel);
        return userModel;
    }

    @Override
    public ResultModel updateUser(UserModel userModel) {
        if(userModel.getIsAdmin() == null || userModel.getIsAdmin() == 0){
            if(CommonUtil.isNull(userModel.getUserStudentCode())){
                return new ResultModel(false,"学号为空");
            }
            if(CommonUtil.isNull(userModel.getUserPhone())){
                return new ResultModel(false,"手机号为空");
            }
            if(CommonUtil.isNull(userModel.getTrueName())){
                return new ResultModel(false,"姓名为空");
            }
            if(CommonUtil.isNull(userModel.getDormitoryCode())){
                return new ResultModel(false,"宿舍号为空");
            }
            if(CommonUtil.isNull(userModel.getUserAddressCode())){
                return new ResultModel(false,"打卡位置为空");
            }
        }
        Example example = new Example(UserModel.class);
        example.createCriteria().andEqualTo("userCode",userModel.getUserCode());
        int i = userDAO.updateByExampleSelective(userModel, example);
        if( i == 0 ){
            return new ResultModel(false,"保存失败");
        }
        return new ResultModel(true,"保存成功");
    }

    @Override
    public ResultModel register(UserModel userModel) {
        //查看登录名是否已存在
        Example example = new Example(UserModel.class);
        example.createCriteria().andEqualTo("userName",userModel.getUserName())
                .andEqualTo("dataFlag",0L);
        List<UserModel> userModels = userDAO.selectByExample(example);
        if(!CollectionUtils.isEmpty(userModels)){
            return new ResultModel(false,"用户名已存在");
        }
        if(StringUtils.isEmpty(userModel.getUserAddressCode())){
            return new ResultModel(false,"打卡位置不能为空");
        }
        Example example1 = new Example(UserModel.class);
        example1.createCriteria().andEqualTo("userAddressCode",userModel.getUserAddressCode())
                .andEqualTo("isAdmin",1L)
                .andEqualTo("dataFlag",0L);
        List<UserModel> userModels1 = userDAO.selectByExample(example1);
        if(!CollectionUtils.isEmpty(userModels1)){
            return new ResultModel(false,"已存在管理员绑定该打卡点");
        }
        userModel.setUserCode(String.valueOf(new Date().getTime()));
        userModel.setTrueName(userModel.getTrueName());
        userModel.setUserPwd(encrypt(userModel.getUserPwd()));
        userModel.setCreateTime(DateUtil.getDate(new Date()));
        userModel.setDataFlag(0L);
        userModel.setIsAdmin(1L);
        userDAO.insert(userModel);
        return new ResultModel(true,"注册成功");
    }

    @Override
    public ResultModel adminLogin(UserModel userModel) {
        userModel.setUserPwd(encrypt(userModel.getUserPwd()));
        UserModel userModels1 = userDAO.getUeryByLogin(userModel);
        if(userModels1 == null){
            return new ResultModel(false,"账号或密码错误",userModels1);
        }
        return new ResultModel(true,"登录成功",userModels1);
    }

    @Override
    public UserModel getUserByCode(UserModel userModel) {
        userModel.setDataFlag(0L);
        return userDAO.selectOne(userModel);
    }

    @Override
    public PageInfo<UserModel> query(UserModel userModel) {
        PageHelper.startPage(userModel);
        List<UserModel> userModels = userDAO.query(userModel);
        PageInfo<UserModel> pageInfo = new PageInfo<>(userModels);
        return pageInfo;
    }

    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + "xtxy";
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
