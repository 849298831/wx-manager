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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/noticeManage.js"></script>
    <style>

    </style>
</head>
<body>
<div class="noticeTable">
    位置:
    <div class="layui-form-item layui-form" style="display:inline-block;margin-bottom:-15px;">
        <div class="layui-input-inline">
            <select name="addressCode" id="addressCode">
                <option value="">选择位置</option>
            </select>
        </div>
    </div>

    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<table class="layui-hide" id="noticeManageTable" lay-filter="noticeTableBar"></table>
<script type="text/html" id="tabBar">
    {{# if(d.dataFlag == 0){ }}
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="del">删除</a>
    {{# }else{} }}
</script>
</body>
</html>