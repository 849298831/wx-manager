var layer,table,form;
$(function(){
   layui.use(['layer','table','form'],function(){
       layer = layui.layer;
       table = layui.table;
       form = layui.form;

       //初始化select
       initSignAddress();
       //初始化表格
       table.render({
           elem:'#signHistoryTable'
           ,id: 'signHistoryTableReload'
           ,height: 759
           ,url:contextPath+"/sign/query"
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
               ,{field:'trueName', title: '姓名',align: 'center'}
               ,{field:'userStudentCode', title: '学号', sort: true, align: 'center'}
               ,{field:'addressName', title: '签到位置', align: 'center'}
               ,{field:'createTime', title: '签到时间', sort: true, align: 'center'}
               ,{field:'dormitoryCode', title: '宿舍号', sort: true, align: 'center'}
           ]]
       });
   });
    var $ = layui.$, active = {
        reload: function(){
            var addressCode = $("#addressCode").val();
            var userStudentCode = $("#userStudentCode").val();
            //执行重载
            table.reload('signHistoryTableReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    addressCode: addressCode,
                    userStudentCode:userStudentCode
                }
            });
        }
    };
    $('.signTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});

/**
 * 初始化打卡位置
 */
function initSignAddress(){
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
                layer.msg("打卡点为空，请超级管理员设置打卡点");
            }
            for(var i = 0 ; i < res.data.list.length ; i++){
                $("#addressCode").append('<option value="'+res.data.list[i].addressCode+'">'+res.data.list[i].addressName+'</option>')

            }
            form.render();
        }
    })
}

