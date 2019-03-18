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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/signHistory.js"></script>
    <style>

    </style>
</head>
<body>
<div class="signTable">
    学号：
    <div class="layui-inline">
        <input class="layui-input" name="userStudentCode" id="userStudentCode" autocomplete="off">
    </div>
    打卡位置:
    <div class="layui-form-item layui-form" style="display:inline-block;margin-bottom:-15px;">
        <div class="layui-input-inline">
            <select name="addressCode" id="addressCode">
                <option value="">选择打卡位置</option>
            </select>
        </div>
    </div>

    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<table class="layui-hide" id="signHistoryTable"></table>
</body>
</html>