var form,layer;
$(function(){
    layui.use(['form','layer'],function(){
        form = layui.form;
        layer = layui.layer;

    });
    getUserInfo();
});

function updateUserForm(index,layero){
    var trueName = $(".trueName").val();
    if(trueName == null || trueName == ''){
        layer.msg('真实姓名不能为空', {
            icon: 2,
            time: 1000
        });
        return false;
    }
    var userPhone = $(".userPhone").val();
    if(userPhone == null || userPhone == ''){
        layer.msg('手机号不能为空', {
            icon: 2,
            time: 1000
        });
        return false;
    }
    var userCode = $(".userCode").val();
    var isAdmin = $(".isAdmin").val();
    $.ajax({
        url:contextPath+"/user/saveUser",
        type:"post",
        dataType:"json",
        data:{
            trueName:trueName,
            userPhone:userPhone,
            userCode:userCode,
            isAdmin:isAdmin
        },
        success:function(res){
            if(res.success){
                layer.msg('更新成功', {
                    icon: 1,
                    time: 1000
                },function(){
                    parent.location.reload();
                    layero.close(index);
                });
            }else{
                layer.msg('更新失败', {
                    icon: 2,
                    time: 1000
                })
            }
        }
    })
}
function getUserInfo(){
    $.ajax({
        url:contextPath+"/user/getAdminMsg",
        type:"post",
        dataType:"json",
        success:function(res){
            if(res.success){
                $(".trueName").val(res.data.trueName);
                $(".userPhone").val(res.data.userPhone);
                $(".userCode").val(res.data.userCode);
                $(".isAdmin").val(res.data.isAdmin);
            }else{
                if(res.status == 1){
                    //未登录
                    window.location.href = contextPath+"/pages/login.jsp";
                }
            }
        }
    })
}


