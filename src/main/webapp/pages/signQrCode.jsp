<%--
  Created by IntelliJ IDEA.
  User: 84929
  Date: 2019/3/16
  Time: 22:00
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
    <title>签到二维码</title>
    <script>var contextPath = "${pageContext.request.contextPath}";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.qrcode.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/signQrCode.js"></script>
    <style>
        .tips{
            font-size:20px;
            width:400px;
            display: block;
            text-align:center;
            margin-left:calc( 50% - 200px );
            margin-top:30px;
        }
        #qrcode{
            margin-left:calc( 50% - 200px );
            margin-top:100px;
        }
        #btn{
            display: inline-block;
            height: 38px;
            line-height: 38px;
            padding: 0 18px;
            background-color: #009688;
            color: #fff;
            white-space: nowrap;
            text-align: center;
            font-size: 14px;
            border: none;
            border-radius: 2px;
            cursor: pointer;
            margin-left:calc( 50% - 46px );
            margin-top:100px;
        }
    </style>
</head>
<body>
<div class="tips">使用手机扫码打卡</div>
<div class="tips" style="color:gray;">(提示：二维码每分钟重置一次)</div>
<div id="qrcode"></div>
<div id="btn">新页面打开</div>
</body>
</html>