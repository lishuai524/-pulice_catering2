<%--
  Created by IntelliJ IDEA.
  User: 李敏捷
  Date: 2019/06/12
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>单据管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<script src="/layui/jquery-3.3.1.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<form class="layui-form" method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-inline">
                <input type="tel" name="bianhao"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--<div class="layui-inline">
            <label class="layui-form-label">发票种类</label>
            <div class="layui-input-block">
                <input type="tel" name="type"  autocomplete="off" class="layui-input">
            </div>
        </div>--%>

        <div class="layui-inline">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="demo1">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>
<script type="text/html" id="toolbarDemo">
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<div class="layui-tab layui-tab-card">
    <ul class="layui-tab-title">
        <li class="layui-this">单据管理</li>
        <li>订单管理</li>
    </ul>
    <div class="layui-tab-content" style="height: 100%;">
        <div class="layui-tab-item layui-show">
            <table  class="layui-hide" id="test" lay-filter="test"></table>
        </div>
        <div class="layui-tab-item" >
        </div>
    </div>
</div>


<script>
    layui.use(['table','form','element'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form=layui.form;
        var element = layui.element;
        //渲染表格

        form.on('submit(demo1)',function (data) {
            table.reload("test",{
                where:{
                    bianhao : data.field.bianhao,
                    //  type : data.field.type
                }
            })
            return false;
        });

        table.render({
            elem:'#test'
            ,url:'/danju/queryAll.do'
            ,toolbar:'#toolbarDemo'
            ,title:'用户数据表'
            ,cols:[[
                {field:'bianhao', title:'订单编号', width:'20%', edit: 'text'}
                ,{field:'money', title:'订单金额', width:'20%'}
                ,{field:'type', title:'订单类别', width:'20%'}
                ,{field:'test', title:'备注', width:'20%'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'20%'}
            ]]
            ,limit:8
            ,limits:[10,20,30]
            ,page: true
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get("/danju/delect.do?id="+data.id,function(data,status){

                    })
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });

            } else if(obj.event === 'edit'){
                alert(data.id)
                layer.open({
                    type: 2,
                    area: ['700px', '600px'],
                    content:'/danju/queryByID.do?id='+data.id,

                    cancel: function(index, layero){
                        if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                            layer.close(index)
                        }
                        return false;
                    },
                    end: function () {
                        location.reload();
                    }
                });
            }
        });
        /*table.on('toolbar(test)', function(obj){
            var data = obj.data;
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;
            };*/
        /* if(obj.event === 'add')
             layer.open({
                 type: 2,
                 area: ['700px', '600px'],
                 content:'/student/toAdd.do',
                 cancel: function(index, layero){
                     if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                         layer.close(index)
                     }
                     return false;
                 },
                 end: function () {
                     location.reload();
                 }
             });
         var checkStatus = table.checkStatus(obj.config.id);
         switch(obj.event){
             case 'getCheckData':
                 var data = checkStatus.data;
                 layer.alert(JSON.stringify(data));
                 break;
             case 'getCheckLength':
                 var data = checkStatus.data;
                 layer.msg('选中了：'+ data.length + ' 个');
                 break;
             case 'isAll':
                 layer.msg(checkStatus.isAll ? '全选': '未全选');
                 break;
         };
     });*/
    });
</script>
</body>
</html>