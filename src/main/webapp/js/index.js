var element,layer;
$(function(){
    layui.use(['element','layer'],function() {
        element = layui.element;
        ayer = layui.layer;
    });


    //初始化
    init();
});


function init(){
    var i = 0;
    $('#animation-left-nav').click(function(){
        //这里定义一个全局变量来方便判断动画收缩的效果,也就是放在最外面
        if(i==0){
            $(".layui-side").animate({width:'toggle'});
            $(".layui-body").animate({left:'0px'});
            i++;
        }else{
            $(".layui-side").animate({width:'toggle'});
            $(".layui-body").animate({left:'200px'});
            i--;
        }
    });
    //左侧导航栏收缩提示
    $('#animation-left-nav').hover(function(){
        layer.tips('收缩左侧导航栏', '#animation-left-nav', {tips:[4,'#2F4056'],time:0});
    },function(){
        layer.closeAll('tips');
    });



    //触发事件
    var active = {
        tabAdd: function(data,url){
            //新增一个Tab项
            element.tabAdd('demo', {
                title: data //用于演示
                ,content:'<iframe data-frameid="'+url+'" frameborder="0" name="content" width="100%"  src="'+url+'"></iframe>'
                ,id: url //实际使用一般是规定好的id，这里以时间戳模拟下
            })
            FrameWH();
        }
        ,tabDelete: function(othis){
            //删除指定Tab项
            element.tabDelete('demo', '44'); //删除：“商品管理”
            othis.addClass('layui-btn-disabled');
        }
        ,tabChange: function(id){
            //切换到指定Tab项
            element.tabChange('demo', id); //切换到：用户管理
        }
    };
    function   FrameWH() {
        var h = $(window).height() - 100;
        $("iframe").css("height", h + "px");
    }
    $('.site-demo-active').on('click', function(){
        var url = $(this).prev().val();
        var id = $(".layui-tab-title").children("li");
        var mark = true;
        for(var i =0 ; i<id.length ;i++){
            if(id.eq(i).attr("lay-id") == url){
                mark = false;
                break;
            }
        }
        if(mark){
            var text = $(this).text();
            active.tabAdd(text,url);
        }
        active.tabChange(url);
        return false;
    });

    $(".layui-tab-title").on("click","li",function(){
        var id = $(this).attr("lay-id");

        var url = $(".layui-nav-child").children("dd");
        for(var i =0 ; i<url.length;i++){
            if(url.eq(i).attr("class") == "layui-this"){
                url.eq(i).attr("class","");
                url.eq(i).parent().parent().attr("class","layui-nav-item");
            }
            if(url.eq(i).children("input").val() == id){
                url.eq(i).attr("class","layui-this");
                url.eq(i).parent().parent().attr("class","layui-nav-item layui-nav-itemed")
            }
        }

    })
}