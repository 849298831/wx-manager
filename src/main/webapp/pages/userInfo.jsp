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
    <title>个人信息</title>
    <script>var contextPath = "${pageContext.request.contextPath}";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/userInfo.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block" style="width:70%;margin-top:30px;">
            <input type="text" name="trueName" lay-verify="required" autocomplete="off" placeholder="请输入真实姓名" class="layui-input trueName">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block" style="width:70%;">
            <input type="text" name="userPhone" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input userPhone">
        </div>
    </div>
    <input type="hidden" name="userCode" class="userCode">
    <input type="hidden" name="isAdmin" class="isAdmin">
</form>

</body>
</html>