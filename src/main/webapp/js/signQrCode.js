var url = "http://192.168.0.22:8080/sign/add"; //扫描二维码后请求后台地址
$(function(){
    initQrCode();
    initQrCodeEvent();
    reloadQrCode();
});

function initQrCode(){
    var timestamp = Date.parse(new Date());
    jQuery('#qrcode').qrcode({
        render: "canvas", //也可以替换为table
        width: 400,
        height: 400,
        text: "http://192.168.0.22:8080/sign/add?timestamp="+timestamp
    });
}

//事件
function initQrCodeEvent(){
    $("#btn").click(function(){
        window.open(contextPath+'/pages/signQrCode.jsp');
    })
}

function reloadQrCode(){
    $("body").everyTime("60s",function(){
        $("#qrcode").empty();
        initQrCode();
    })
}