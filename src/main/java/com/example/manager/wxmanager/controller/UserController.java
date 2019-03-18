package com.example.manager.wxmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.manager.wxmanager.common.winxin.WxConfig;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.CommonUtil;
import com.example.manager.wxmanager.model.common.DateUtil;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping("/loginByWx")
    public ResultModel loginByWeixin(HttpServletRequest request) {
        JSONObject jsonParam = CommonUtil.getJsonRequest(request);
        Map<String,Object> fullUserInfo = null;
        String code = "";
        if (!StringUtils.isEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
        if (null != jsonParam.get("userInfo")) {
            Map<String,Object> userInfo = (Map<String,Object>)jsonParam.get("userInfo");
            fullUserInfo = (Map<String,Object>)userInfo.get("detail");
//            fullUserInfo = jsonObject.getObject("userInfo",FullUserInfo.class);
        }
        if (null == fullUserInfo) {
            return  new ResultModel(false,"登录失败");
        }
        Map<String,Object> userInfo = (Map<String,Object>)fullUserInfo.get("userInfo");
        String requestUrl = new Formatter().format(WxConfig.webAccessTokenhttps,WxConfig.appId,WxConfig.secret,code).toString();
        JSONObject sessionData = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null == sessionData || StringUtils.isEmpty(sessionData.getString("openid"))) {
            return  new ResultModel(false,"登录失败");
        }
        String sha1 = CommonUtil.getSha1(fullUserInfo.get("rawData") + sessionData.getString("session_key"));
        if (!fullUserInfo.get("signature").equals(sha1)) {
            return new ResultModel(false,"登录失败");
        }
        UserModel userVo = userService.getUserByOpenId(new UserModel(sessionData.getString("openid")));
        if (null == userVo) {
            UserModel userModel = new UserModel();
            userModel.setUserName(userInfo.get("nickName").toString());
            userModel.setCreateTime(DateUtil.getDate(new Date()));
            userModel.setWxOpenId(sessionData.getString("openid"));
            userModel.setWxUserPhoto(userInfo.get("avatarUrl").toString());
            userModel.setIsAdmin(0L);
            userVo = userService.insertUser(userModel);
        }
        Map<String, Object> tokenMap = CommonUtil.createToken(userVo.getId());
        String token = (String) tokenMap.get("token");
        if (null == userInfo || StringUtils.isEmpty(token)) {
            return  new ResultModel(false,"登录失败");
        }
        Map<String,Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", userVo);
        result.put("userCode", userVo.getUserCode());
        request.getSession().setAttribute("userMsg",userInfo);
        //判断用户信息是否填写完整如果不完整需要填写完毕才能打卡
        if(StringUtils.isEmpty(userVo.getTrueName()) || StringUtils.isEmpty(userVo.getUserAddressCode())
                || StringUtils.isEmpty(userVo.getUserPhone()) || StringUtils.isEmpty(userVo.getUserStudentCode())
                || StringUtils.isEmpty(userVo.getDormitoryCode())){
            return new ResultModel(true,"登录成功",result,2);
        }
       return new ResultModel(true,"登录成功",result,1);
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/saveUser")
    public ResultModel saveUser(UserModel userModel){
        return userService.updateUser(userModel);
    }

    /**
     * 管理员注册
     */
    @RequestMapping("/register")
    public ResultModel register(UserModel userModel){
        return userService.register(userModel);
    }
    /**
     * 管理员登录
     */
    @RequestMapping("/adminLogin")
    public ResultModel adminLogin(UserModel userModel,HttpSession httpSession){
        ResultModel resultModel = userService.adminLogin(userModel);
        if(resultModel.isSuccess()){
            UserModel userModel1 = (UserModel) resultModel.getData();
            httpSession.setAttribute("user",userModel1);
        }
        return resultModel;
    }

    /**
     * 获取管理员信息
     */
    @RequestMapping("/getAdminMsg")
    public ResultModel getAdminMsg(HttpSession httpSession){
        UserModel userModel1 = (UserModel) httpSession.getAttribute("user");
        if(userModel1 == null){
            return new ResultModel(false,"用户未登录","",1);
        }
        UserModel userByCode = userService.getUserByCode(new UserModel(userModel1.getUserCode(), null));
        if(userByCode == null){
            return new ResultModel(false,"该用户不存在");
        }
        return new ResultModel(true,"",userByCode);
    }

    /**
     * 推出登录
     */
    @RequestMapping("/logOff")
    public ResultModel logOff(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return new ResultModel(true,"退出登录成功");
    }

    /**
     * 查询用户信息
     */
    @RequestMapping("/query")
    public ResultModel query(HttpSession httpSession,UserModel userModel){
        if(userModel.getPage() != null){
            userModel.setPageNum(userModel.getPage());
            userModel.setPageSize(userModel.getLimit());
            UserModel session = (UserModel) httpSession.getAttribute("user");
            if(session != null && session.getIsAdmin() != 2){
                userModel.setUserAddressCode(userModel.getUserAddressCode());
                userModel.setIsAdmin(0L);
            }
        }
        PageInfo<UserModel> pageInfo = userService.query(userModel);
        return new ResultModel(true,"",pageInfo);
    }

}
