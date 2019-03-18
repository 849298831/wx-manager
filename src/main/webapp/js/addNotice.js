var layer;
layui.use(['layer'],function() {
    layer = layui.layer;

    $(".addNotice").click(function(){
        addNotice();
        return false;
    })
});

function addNotice(){
    var content = $(".content").val();
    console.log(content);
    if(content == null || content == ""){
        layer.msg('内容不能为空', {
            icon: 2,
            time: 1000 //1秒关闭（如果不配置，默认是3秒）
        }, function () {//
        });
        return false;
    }

    $.ajax({
        url:contextPath+"/notice/add",
        type:"post",
        dataType:"json",
        data:{
            content:content
        },
        success:function(res){
            layer.msg(res.msg);
        }
    })
}
