var layer;
layui.use(['layer'],function() {
    layer = layui.layer;

    $(".addVisit").click(function(){
        addVisit();
        return false;
    })
});

function addVisit(){
    var visitName = $(".visitName").val();
    if(visitName == null || visitName == ""){
        layer.msg('来访人姓名不能为空', {
            icon: 2,
            time: 1000 //1秒关闭（如果不配置，默认是3秒）
        }, function () {//
        });
        return false;
    }
    var visitPhone = $(".visitPhone").val();
    if(visitPhone == null || visitPhone == ""){
        layer.msg('来访人手机号不能为空', {
            icon: 2,
            time: 1000 //1秒关闭（如果不配置，默认是3秒）
        }, function () {//
        });
        return false;
    }
    var visitReason = $(".visitReason").val();
    if(visitReason == null || visitReason == ""){
        layer.msg('来访原因不能为空', {
            icon: 2,
            time: 1000 //1秒关闭（如果不配置，默认是3秒）
        }, function () {//
        });
        return false;
    }

    $.ajax({
        url:contextPath+"/visit/add",
        type:"post",
        dataType:"json",
        data:{
            visitName:visitName,
            visitPhone:visitPhone,
            visitReason:visitReason
        },
        success:function(res){
            layer.msg(res.msg);
            if(!res.success && res.status == 1){
                window.location.href = contextPath+"/pages/login.jsp"
            }
        }
    })
}
