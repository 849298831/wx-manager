var layer;
$(function(){
    layui.use('layer',function(){
        layer = layui.layer;
    });
    getUserMsg();
    initEvent();
});


/**
 * 获取用户信息
 */
function getUserMsg(){
    $.ajax({
        url:contextPath+"/user/getAdminMsg",
        type:"post",
        dataType:"json",
        success:function(res){
            if(res.success){
                initMenu(res.data.isAdmin);
                bindUserMsg(res.data);
            }else{
                if(res.status == 1){
                    //未登录
                    window.location.href = contextPath+"/pages/login.jsp";
                }
            }
        }
    })
}

/**
 * 绑定用户信息
 * @param user
 */
function bindUserMsg(user){
    $(".userMsg").children("span").text(user.trueName);
    if(user.userPhoto != undefined){
        $(".userMsg").children("img").attr("src",user.userPhoto);
    }
}
/**
 * 初始化菜单
 */
function initMenu(isAdmin){
    if(isAdmin != 2){
        $(".addAddress").hide();
    }
    $(".pageFirst").children("a").click();
}

/**
 * 绑定事件
 */
function initEvent(){
    //退出登录
    $(".logOff").click(function(){
        logOff();
    });
    //更新用户信息
    $(".updateUserMsg").click(function(){
        updateUserMsg();
    })
}

/**
 *
 */
function updateUserMsg(){
    var context=contextPath+"/pages/userInfo.jsp";
    layer.open({
        type: 2,
        title: "更新个人信息",
        shadeClose: false, //是否点击遮罩层关闭
        shade: 0, //是否要有蒙层
        //closeBtn: 0, //隐藏右上角关闭按钮
        area: ['25%', '30%'],
        content: context,
        btn:["更新","取消"],
        yes:function (index, layero) {
            var iframeWin = window[layero.find('iframe')[0]['name']];
            iframeWin.updateUserForm(index,layer);
        },cancel: function(){
            return true;
        }
    });
}
/**
 * 退出登录
 */
function logOff(){
    $.ajax({
        url:contextPath+"/user/logOff",
        type:"post",
        dataType:"json",
        success:function(res){
            layer.msg("退出登录成功");
            $("body").oneTime("1.5s",function(){
                window.location.href = contextPath+"/pages/login.jsp";
            })
        }
    })
}
