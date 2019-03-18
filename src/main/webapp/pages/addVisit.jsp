<%--
  Created by IntelliJ IDEA.
  User: 84929
  Date: 2019/3/17
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
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
    <title>发起公告</title>
    <script>var contextPath = "${pageContext.request.contextPath}";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/addVisit.js"></script>
</head>
<body style="background-color: #f5f5f5;margin-top:30px;">
<form class="layui-form" action="">
    <div class="layui-form-item layui-form-text" style="width:50%;">
        <label class="layui-form-label">来访人姓名</label>
        <div class="layui-input-block">
            <input type="text" name="visitName" lay-verify="required" autocomplete="off" placeholder="请输入来访人员姓名" class="layui-input visitName">
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="width:50%;">
        <label class="layui-form-label">来访人手机号</label>
        <div class="layui-input-block">
            <input type="text" name="visitPhone" lay-verify="required" autocomplete="off" placeholder="请输入来访人员手机号" class="layui-input visitPhone">
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="width:50%;">
        <label class="layui-form-label">来访原因</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea visitReason" style="height:300px;"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn addVisit">
                添加来访
            </button>
        </div>
    </div>
</form>

</body>
</html>