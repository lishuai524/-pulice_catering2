<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/la/lib/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="layui-form-item"></div>
    <span class="layui-breadcrumb" lay-separator="|">
        <a href="/jsp/XT/role_management.jsp">角色列表</a>
        <a href="/WEB-INF/jsp/XT/role_management_tianjia.jsp">角色添加</a>
    </span>
<div class="layui-form-item"></div>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="fenpei">分配</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<script src="/la/js/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['table','element'], function(){
        var table = layui.table
            ,element = layui.element;

        table.render({
            elem: '#test'
            ,url: '/role/role/queryAll.do'
            ,title: '用户数据表'
            ,totalRow: true
            ,cols:
                [
                    [
                        {field:'name', title: '角色名称'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                        ,{field:'english', title: '英文名称', align: 'center'} //单元格内容水平居中
                        ,{field:'department', title: '归属机构', sort: true, align: 'right'} //单元格内容水平居中
                        ,{field:'scope', title: '数据范围', sort: true, align: 'right'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
                    ]
                ]
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get("/role/role/delete.do?id="+data.id,function (ret) {
                        if(ret){
                            layer.msg("角色删除成功");
                        }else{
                            layer.msg("角色正在使用中,不能删除");
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                location.href = 'http://localhost:8080/role/role/toUpdate.do?id=' + data.id;
            } else if(obj.event === 'fenpei') {
                location.href = 'http://localhost:8080/role/role/toFenpei.do?id=' + data.id;
            }
        });
    });
</script>

</body>
</html>
