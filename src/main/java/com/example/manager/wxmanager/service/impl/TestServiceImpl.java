package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.TestDAO;
import com.example.manager.wxmanager.model.TestModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.TestService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDAO testDAO;

    @Override
    public ResultModel testInsertModel() {
        TestModel testModel = new TestModel();
        testModel.setAgo(1L);
        testModel.setName("郭硕硕");
        testDAO.insertTest(testModel);
        return new ResultModel(true,"",testModel);
    }

    @Override
    public ResultModel testSelectModel() {
        Example example =new Example(TestModel.class);
        example.createCriteria().andEqualTo("name","郭硕硕");
        List<TestModel> testModels = testDAO.selectByExample(example);
        return new ResultModel(true,"",testModels);
    }

    @Override
    public  PageInfo<TestModel> testSelectModelPage(TestModel testModel) {
        Page<?> objects = PageHelper.startPage(testModel);
        List<TestModel> testModels = testDAO.selectAll();
        PageInfo<TestModel> testModelPageInfo = new PageInfo<>(testModels);
        return testModelPageInfo;
    }

}
