package com.example.manager.wxmanager.service.impl;

import com.example.manager.wxmanager.dao.TestDAO;
import com.example.manager.wxmanager.model.TestModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDAO testDAO;

    @Override
    public ResultModel testModel() {

        TestModel testModel = new TestModel();
        testModel.setAgo(1L);
        testModel.setName("郭硕硕");
        testDAO.insertTest(testModel);

        List<TestModel> testModels = testDAO.selectTest();
        return new ResultModel(true,"",testModels);
    }
}
