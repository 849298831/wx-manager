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
    <title></title>
    <script>
        var contextPath = "${pageContext.request.contextPath}";
        var addressLongitude = "<%=request.getParameter("addressLongitude")%>";
        var addressLatitude = "<%=request.getParameter("addressLatitude")%>";
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/addPoint.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">经度</label>
        <div class="layui-input-block" style="width:70%;margin-top:30px;">
            <input type="text" name="addressLongitude" readonly lay-verify="required" autocomplete="off" class="layui-input addressLongitude">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">纬度</label>
        <div class="layui-input-block" style="width:70%;">
            <input type="text" name="addressLatitude" readonly lay-verify="required" autocomplete="off" class="layui-input addressLatitude">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">坐标点名称</label>
        <div class="layui-input-block" style="width:70%;">
            <input type="text" name="addressName" lay-verify="required" autocomplete="off" class="layui-input addressName">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">详细地址</label>
        <div class="layui-input-block" style="width:70%;">
            <input type="text" name="addressDetail" lay-verify="required" autocomplete="off" class="layui-input addressDetail">
        </div>
    </div>
</form>

</body>
</html>