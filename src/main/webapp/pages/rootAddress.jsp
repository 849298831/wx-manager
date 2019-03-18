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
    <script src="${pageContext.request.contextPath}/js/common/map-util.js"></script>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=EvQXrq1tUMLIu2d1tGpQIeNZSTe6LG6y"></script>
    <script src="${pageContext.request.contextPath}/js/rootAddress.js"></script>
</head>
<body style="width:100%;">
<table class="layui-hide" id="addressManageTable" lay-filter="addressTableBar"></table>
<div id="containerMap" style="height:520px;margin-top:30px;"></div>
<script type="text/html" id="addressTabBar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>