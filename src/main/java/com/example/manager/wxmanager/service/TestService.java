package com.example.manager.wxmanager.service;

import com.example.manager.wxmanager.model.TestModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.github.pagehelper.PageInfo;

public interface TestService {

    /**
     * 测试通用mapper insert
     */
    ResultModel testInsertModel();

    /**
     * 测试通用mapper select
     */
    ResultModel testSelectModel();

    /**
     * 测试通用mapper select   +  分页插件
     */
    PageInfo<TestModel> testSelectModelPage(TestModel testModel);
}
