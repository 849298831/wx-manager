package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.AddressDAO;
import com.example.manager.wxmanager.dao.SignDAO;
import com.example.manager.wxmanager.model.AddressModel;
import com.example.manager.wxmanager.model.SignInModel;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.Distance;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.SignService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignDAO signDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Override
    public ResultModel add(SignInModel signInModel) throws ParseException {
        //计算是否是过期的二维码
        String s = DateUtil.timeStampToDate(Long.valueOf(signInModel.getTimestamp())); //二维码时间
        String nowBeforeMin = DateUtil.getNowBeforeMin(new Date(), 1L); //现在时间向前推一分钟
        if(DateUtil.getDate(nowBeforeMin).compareTo(DateUtil.getDate(s)) > 0){
            return new ResultModel(false,"二维码已过期");
        }
        Example example = new Example(AddressModel.class);
        example.createCriteria().andEqualTo("addressCode",signInModel.getAddressCode());
        List<AddressModel> addressModels = addressDAO.selectByExample(example);
        if(CollectionUtils.isEmpty(addressModels)){
            return new ResultModel(false,"签到失败，无此坐标点");
        }
        AddressModel addressModel = addressModels.get(0);
        //计算距离
        double distance = Distance.getDistance(signInModel.getAddressLongitude().doubleValue(),
                signInModel.getAddressLatitude().doubleValue(),
                addressModel.getAddressLongitude().doubleValue(),
                addressModel.getAddressLatitude().doubleValue());
        if(new BigDecimal(distance).compareTo(new BigDecimal(100)) > 0){
            return new ResultModel(false,"签到失败，不在签到范围之内");
        }
        //签到成功，记录签到
        signInModel.setSignCode(String.valueOf(new Date().getTime()));
        signInModel.setCreateTime(DateUtil.getDate(new Date()));
        signInModel.setDataFlag(0L);
        signDAO.insert(signInModel);
        return new ResultModel(true,"签到成功");
    }

    @Override
    public ResultModel update(SignInModel signInModel) {
        return null;
    }

    @Override
    public PageInfo<SignInModel> query(SignInModel signInModel) {
        PageHelper.startPage(signInModel);
        List<SignInModel> query = signDAO.query(signInModel);
        PageInfo<SignInModel> pageInfo = new PageInfo<SignInModel>(query);
        return pageInfo;
    }
}
