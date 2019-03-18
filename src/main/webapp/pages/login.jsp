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
    <title>登录 - 宿舍管理系统</title>
    <script>var contextPath = "${pageContext.request.contextPath}";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>

<body style="background-color: #f5f5f5;">
<fieldset class="layui-elem-field" style="width: 380px; margin:0 auto; margin-top: 15%; box-shadow: 0 0 10px #d9edf7;">
    <legend>
        登录 - 宿舍管理系统
    </legend>
    <form class="layui-form" style="margin-top:39px;">
        <div class="layui-form-item">
            <label class="layui-form-label">
                用户名
            </label>
            <div class="layui-input-inline">
                <input type="text" name="userName" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                密码
            </label>
            <div class="layui-input-inline">
                <input type="password" name="userPwd" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="loginForm">
                    登录
                </button>
                <button type="button" id="df_register" class="layui-btn layui-btn-primary">
                    注册
                </button>
            </div>
        </div>
    </form>
</fieldset>

</body>
</html>