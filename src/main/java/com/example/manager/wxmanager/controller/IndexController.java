package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.TestService;
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


    @RequestMapping("/test")
    @ResponseBody
    public ResultModel test(){

        return testService.testModel();
    }
}