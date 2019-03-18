<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="wesleyan">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>签到/打卡记录</title>
    <script>var contextPath = "${pageContext.request.contextPath}";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/userManage.js"></script>
    <style>

    </style>
</head>
<body>
<div class="userTable">
    位置:
    <div class="layui-form-item layui-form" style="display:inline-block;margin-bottom:-15px;">
        <div class="layui-input-inline">
            <select name="addressCode" id="addressCode">
                <option value="">选择位置</option>
            </select>
        </div>
    </div>
    职位:
    <div class="layui-form-item layui-form" style="display:inline-block;margin-bottom:-15px;">
        <div class="layui-input-inline">
            <select name="isAdmin" id="isAdmin">
                <option value="">选择职位</option>
                <option value="0">学生</option>
                <option class="superAdmin" value="1">管理员</option>
            </select>
        </div>
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<table class="layui-hide" id="userManageTable" lay-filter="userTableBar"></table>
<script type="text/html" id="isAdminTem">
    {{# if(d.isAdmin == 0){d.isAdmin = '学生'}}
    <span>{{d.isAdmin}}</span>
    {{# } else if(d.isAdmin == 1){d.isAdmin = "管理员"}}
    <span>{{d.isAdmin}}</span>
    {{# } else {d.isAdmin = '超级管理员'}}
    <span>{{d.isAdmin}}</span>
    {{# } }}
</script>
</body>
</html>