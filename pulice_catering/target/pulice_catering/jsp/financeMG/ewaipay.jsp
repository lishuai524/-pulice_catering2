<%--
  Created by IntelliJ IDEA.
  User: 李敏捷
  Date: 2019/06/12
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
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
<form class="layui-form"  method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="tel" name="name"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">时间</label>
            <div class="layui-input-block">
                <input type="date" name="time"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="demo1">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this" >额外收入管理</li>
        <li>添加额外收入</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show"><table  class="layui-hide" id="test" lay-filter="test"></table></div>
        <div class="layui-tab-item" >
            <iframe height="88%" width="98%" src="ewaipayinsert.jsp"></iframe>
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
                    name : data.field.name,
                    time : data.field.time
                }
            })
            return false;
        });

        table.render({
            elem:'#test'
            ,url:'/ewaipay/queryAll.do'
            ,toolbar:'#toolbarDemo'
            ,title:'交接表'
            ,totalRow: true
            ,cols:[[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID', width:"10%", sort: true, totalRow: true}
                ,{field:'name', title:'NAME', width:"10%",sort: true, totalRow: true}
                ,{field:'money', title:'金额', width:"10%",  sort: true}
                ,{field:'test', title:'备注', width:"10%",  sort: true}
                ,{field:'time', title:'时间', width:"20%",  sort: true}
                ,{fixed: 'right',width:"20%", title:'操作', toolbar: '#barDemo', width:150}
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
                    $.get("/ewaipay/delect.do?id="+data.id,function(data,status){

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
                    content:'/ewaipay/queryByID.do?id='+data.id,

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


    });
</script>
</body>
</html>