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
    <title>宿舍管理系统</title>
    <script>var contextPath = "${pageContext.request.contextPath}";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script src="${pageContext.request.contextPath}/js/init-manager.js"></script>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">宿舍管理系统</div>
        <div class="layui-logo"><i class="layui-icon"  id="animation-left-nav" style="position: fixed;left:10px;">&#xe65c;</i></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <%--<ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">顶部菜单一</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">顶部菜单二</a>
                <dl class="layui-nav-child">
                    <dd><a href="">子菜单一</a></dd>
                    <dd><a href="">子菜单二</a></dd>
                    <dd><a href="">子菜单三</a></dd>
                </dl>
            </li>
        </ul>--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" class="userMsg">
                    <img src="${pageContext.request.contextPath}/images/admin.jpg" class="layui-nav-img">
                    <span></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="#" class="updateUserMsg">基本资料</a></dd>
                    <%--<dd><a href="">安全设置</a></dd>--%>
                    <dd><a href="#" class="logOff">退出登录</a></dd>
                </dl>
            </li>
            <%--<li class="layui-nav-item"><a href="">退出登录</a></li>--%>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->

            <ul class="layui-nav layui-nav-tree"  lay-filter="test"  lay-shrink="all">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">签到打卡管理</a>
                    <dl class="layui-nav-child">
                        <dd class="pageFirst"><input type="hidden" value="${pageContext.request.contextPath}/pages/signHistory.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">签到/打卡记录</a></dd>
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/signQrCode.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">签到/打卡二维码</a></dd>
                        <dd class="addAddress"><input type="hidden" value="${pageContext.request.contextPath}/pages/rootAddress.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">设置签到/打卡点</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">报修管理</a>
                    <dl class="layui-nav-child">
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/repairManage.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">查看报修</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公告管理</a>
                    <dl class="layui-nav-child">
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/noticeManage.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">查看公告</a></dd>
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/addNotice.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">发布公告</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">人员管理</a>
                    <dl class="layui-nav-child">
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/userManage.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">人员列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">来访人员管理</a>
                    <dl class="layui-nav-child">
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/visitManage.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">来访人员列表</a></dd>
                        <dd><input type="hidden" value="${pageContext.request.contextPath}/pages/addVisit.jsp"><a class="site-demo-active"  data-type="tabAdd" href="javascript:;">添加来访</a></dd>
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
        邢台学院2019毕业设计
    </div>
</div>
</body>
</html>
