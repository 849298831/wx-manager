package com.example.manager.wxmanager.controller;

import com.example.manager.wxmanager.model.RepairModel;
import com.example.manager.wxmanager.model.UserModel;
import com.example.manager.wxmanager.model.common.ResultModel;
import com.example.manager.wxmanager.service.RepairService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 报修控制器
 */
@RestController
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
     * 添加报修
     */
    @RequestMapping("/add")
    public ResultModel add(RepairModel repairModel){
        return repairService.add(repairModel);
    }
    /**
     * 更新报修
     */
    @RequestMapping("/update")
    public ResultModel update(RepairModel repairModel){
        return repairService.update(repairModel);
    }
    /**
     * 查询所有报修
     */
    @RequestMapping("/query")
    public ResultModel query(RepairModel repairModel,HttpSession httpSession){
        if(repairModel.getPage() != null){
            repairModel.setPageNum(repairModel.getPage());
            repairModel.setPageSize(repairModel.getLimit());
            UserModel userModel = (UserModel) httpSession.getAttribute("user");
            if(userModel != null && userModel.getIsAdmin() != 2){
                repairModel.setAddressCode(userModel.getUserAddressCode());
            }
           
        }
        PageInfo<RepairModel> query = repairService.query(repairModel);
        return new ResultModel(true,"",query);
    }
    @RequestMapping("upload")
    public ResultModel upload(HttpServletRequest request,RepairModel repairModel,@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        String trueFileName = "";
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        System.out.println("执行图片上传");
        String user = request.getParameter("user");
        System.out.println("user:"+user);
        if(!file.isEmpty()) {
            System.out.println("成功获取照片");
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            System.out.println("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + "/uploads/" + trueFileName;
                    File file1 = new File(path);
                    System.out.println(file1.isDirectory());
                    System.out.println("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    new ResultModel(false,"","");
                }
            }else {
                System.out.println("文件类型为空");
                new ResultModel(false,"","");
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return new ResultModel(false,"","");
        }
        return new ResultModel(true,"",trueFileName);
    }
}
