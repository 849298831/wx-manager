package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.TestModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.TestService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {


    @Autowired
    private TestService testService;


    @RequestMapping("")
    public String index(){
        return "index";
    }


    @RequestMapping("/test1")
    @ResponseBody
    public ResultModel test1(){

      return testService.testInsertModel();
    }

    @RequestMapping("/test2")
    @ResponseBody
    public ResultModel test2(){

        return testService.testSelectModel();
    }

    @RequestMapping("/test3")
    @ResponseBody
    public ResultModel test3(TestModel testModel){
        PageInfo<TestModel> testModelPageInfo = testService.testSelectModelPage(testModel);
        return new ResultModel(true,"",testModelPageInfo);
    }
}