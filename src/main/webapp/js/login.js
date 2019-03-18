$(function(){
    layui.use(['form','jquery','laydate'], function() {
        var $ = layui.jquery;
        var form = layui.form;
        var laydate = layui.laydate;
        //监听提交
        form.on('submit(loginForm)', function (data) {
            //layer.msg(JSON.stringify(data.field));
            //这里可以发起ajax请求进行登录验证
            $.ajax({
                url: "/user/adminLogin",  //后台程序地址
                type: "POST",
                data: data.field,  //需要post的数据
                dataType:"json",
                success: function (res) {             //后台程序返回的标签，比如我喜欢使用1和0 表示成功或者失败
                    layer.msg(res.msg);
                    if (res.success) {   //如果成功了
                        // 在js代码中使用el表达式的方式：在双引号当中直接使用即可
                        $("body").oneTime("1s",function(){
                            window.location.href = contextPath+'/';
                        })
                    }
                }
            });
            return false;//return false 表示不通过页面刷新方式提交表单
        });

        //修正登录框margin


        // 监听注册按钮
        $('#df_register').on('click', function () {
            layer.open({
                title: '注册 - 宿舍管理系统'
                , area: ['400px', '330px']
                , type: 2 //content内容为一个连接
                , content: contextPath+'/pages/register.jsp'
            });
        });
    });
});