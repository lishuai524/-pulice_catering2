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


<script type="text/javascript"  src="jquery-3.3.1.js" ></script>
<form class="layui-form"  method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">优惠劵名</label>
            <div class="layui-input-inline">
                <input type="tel" name="name"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-block">
                <input type="date" name="start"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <input type="date" name="end"  autocomplete="off" class="layui-input">
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
        <li class="layui-this" >优惠劵管理</li>
        <li>添加优惠劵</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show"><table  class="layui-hide" id="test" lay-filter="test"></table></div>
        <div class="layui-tab-item" >
            <iframe height="88%" width="98%" src="youhuiinsert.jsp"></iframe>
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
                    start : data.field.start,
                    end : data.field.end
                }
            })
            return false;
        });

        table.render({
            elem:'#test'
            ,url:'/youhui/queryAll.do'
            ,toolbar:'#toolbarDemo'
            ,title:'交接表'
            ,cols:[[
                {field:'name', title:'优惠券名', width:'9.1%', edit: 'text'}
                ,{field:'money', title:'优惠券金额', width:'9.1%'}
                ,{field:'start', title:'有效期起始日期', width:'15%'}
                ,{field:'end', title:'有效期截止日期', width:'15%'}
                ,{field:'test', title:'备注', width:'9.1%'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'9.1%'}
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
                    $.get("/youhui/delect.do?id="+data.id,function(data,status){

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
                    content:'/youhui/queryByID.do?id='+data.id,

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