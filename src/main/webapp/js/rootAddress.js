var layer,table,$;
layui.use(['layer','table',"jquery"],function() {
    layer = layui.layer;
    table = layui.table;
    $ = layui.$;

    initAdressed();

    table.render({
        elem:'#addressManageTable'
        ,id: 'addressManageTableReload'
        ,height: 250
        ,url:contextPath+"/address/query"
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        },response: {
            statusCode: 0 //重新规定成功的状态码为 200，table 组件默认为 0
        }
        ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.status, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.list //解析数据列表
            };
        }
        ,cols: [[
            {field:'id', title: 'ID', sort: true,align: 'center',width:'5%'}
            ,{field:'addressLatitude', title: '纬度',align: 'center',width:'10%'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ,{field:'addressLongitude', title: '经度', align: 'center',width:'10%'}
            ,{field:'addressName', title: '坐标点名称', align: 'center',width:'20%'}
            ,{field:'addressDetail', title: '详细地址', align: 'center'}
            ,{field:'createTime', title: '发起时间', sort: true, align: 'center',width:'10%'}
            ,{field:'', title: '操作', align: 'center',width:'5%',templet:'#addressTabBar'} //单元格内容水平居中
        ]]
    });
    var $ = layui.$, active = {
        reload: function(){
            //执行重载
            table.reload('addressManageTableReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }
    };
    $('.addressTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    //监听工具条
    table.on('tool(addressTableBar)', function(obj){
        var data = obj.data;
        console.log(obj);
        if(obj.event === 'del'){
            layer.confirm('确认删除吗', function(index){
                delAddress(data.addressCode,layer,index);
            });
        }
    });
});


/**
 * 加载所有坐标点
 */
function initAdressed(){
    $.ajax({
        url:contextPath+"/address/query",
        type:"post",
        dataType:"json",
        data:{
            pageNum:1,
            pageSize:30
        },
        success:function(res){
            for(var i = 0 ; i < res.data.list.length ; i++){
                var addressList = gcToDb(res.data.list[i].addressLongitude,res.data.list[i].addressLatitude);
                addPoint(addressList[0],addressList[1],contextPath+'/images/address.png',35,94,res.data.list[i].addressName,res.data.list[i].addressDetail);
            }
        }
    })
}

/**
 * 删除坐标点
 */
function delAddress(addressCode,layer,index){
    $.ajax({
        url:contextPath+"/address/del",
        type:"post",
        dataType:"json",
        data:{
            addressCode:addressCode
        },
        success:function(res){
           layer.msg(res.msg);
           if(res.success){
               layer.close(index);
               $("body").oneTime("1.5s",function(){
                   window.location.reload();
               });
           }

        }
    })
}