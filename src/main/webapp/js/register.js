var form,layer;
$(function(){
    layui.use(['form','jquery','layer'], function(){
        form = layui.form;
        layer = layui.layer;

        initAddress();

        //监听提交
        form.on('submit(registerForm)', function(params){
            //表单数据
            //等同于上面注释掉的部分
            var pwd=$("#userPwd").val();
            var newPwd=$("#userPwd1").val();
            if(pwd == newPwd) {
                var data = $("form").serializeArray();
                $.ajax({
                    type: "POST",
                    url: "/user/register",  //后台程序地址
                    data: data,  //需要post的数据
                    success: function (data) {           //后台程序返回的标签，比如我喜欢使用1和0 表示成功或者失败
                        if (data.success) {   //如果成功了, 则关闭当前layer
                            layer.msg('注册成功', {
                                icon: 1,
                                time: 1000 //1秒关闭（如果不配置，默认是3秒）
                            }, function () {//

                                //do something
                                //注册成功后，自动关闭当前注册页面
                                //先得到当前iframe层的索引
                                $("body").oneTime("1s",function(){
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(index);
                                })
                                //parent.layer.closeAll("iframe");
                            });
                        } else {
                            layer.msg('注册失败:'+data.msg, {
                                icon: 2,
                                time: 1000 //1秒关闭（如果不配置，默认是3秒）
                            }, function () {//
                                //do something
                                //注册成功后，自动关闭当前注册页面
                                //先得到当前iframe层的索引
                                //parent.layer.closeAll("iframe");
                            });
                        }

                    }
                });
            }else{
                layer.msg('两次密码输入不一致', {
                    icon: 2,
                    time: 1000 //1秒关闭（如果不配置，默认是3秒）
                }, function () {//
                });
            }
            return false;//return false 表示不通过页面刷新方式提交表单
        });
    });
});

/**
 * 初始化打卡位置
 */
function initAddress(){
    $.ajax({
        url:contextPath+"/address/query",
        type:"post",
        dataType:"json",
        data:{
            "pageNum":1,
            "pageSize":30
        },
        success:function(res){
            if(res.data.total < 1){
                layer.msg("打卡点为空，请管理员设置打卡点");
            }
            for(var i = 0 ; i < res.data.list.length ; i++){
                $("#userAddressCode").append('<option value="'+res.data.list[i].addressCode+'">'+res.data.list[i].addressName+'</option>')

            }
            form.render();
        }
    })
}
