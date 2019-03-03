<%--
  Created by IntelliJ IDEA.
  User: QQKJ
  Date: 2018/8/16
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理</div>
        <div class="layui-logo"><i class="layui-icon"  id="animation-left-nav" style="position: fixed;left:10px;">&#xe65c;</i></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">顶部菜单一</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">顶部菜单二</a>
                <dl class="layui-nav-child">
                    <dd><a href="">子菜单一</a></dd>
                    <dd><a href="">子菜单二</a></dd>
                    <dd><a href="">子菜单三</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    硕哥
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->

            <ul class="layui-nav layui-nav-tree"  lay-filter="test"  lay-shrink="all">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">支付Demo</a>

                    <dl class="layui-nav-child">
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/aliPay.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">aliPay</a></dd>
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/wxPay.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">wxPay</a></dd>
                    </dl>

                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">短信服务</a>
                    <dl class="layui-nav-child">
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/aliSms.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">aliSms</a></dd>
                    </dl>
                </li>


            </ul>
        </div>
    </div>

        <div class="layui-tab  layui-body" lay-filter="demo" lay-allowclose="true"  style="margin-top:-3px;">
            <ul class="layui-tab-title">
            </ul>
            <div class="layui-tab-content">
            </div>
        </div>

        <div class="layui-footer">
            底部固定区域
        </div>
</div>
</body>
</html>
