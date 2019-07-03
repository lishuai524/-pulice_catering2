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
        <a href="/jsp/XT/headquarters.jsp">总店信息列表</a>
        <a href="/headquarters/headquarters/toInsert_headquarters.do">总店信息添加</a>
    </span>
<div class="layui-form-item"></div>

<form class="layui-form" id="staffsForm" onsubmit="return false">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">总店经理: </label>
            <div class="layui-input-inline">
                <input type="text" id="manager" name="manager" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">总店名称: </label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
            </div>
        </div>
    </div>
</form>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<script src="/la/js/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['form','table','element'], function(){
        var table = layui.table
            ,element = layui.element
            ,form = layui.form;

        table.render({
            elem: '#test'
            ,url: '/headquarters/headquarters/queryAll.do'
            ,title: '用户数据表'
            ,totalRow: true
            ,cols:
                [
                    [
                        {field:'manager', title: '总店经理'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                        ,{field:'name', title: '总店名称', align: 'center'} //单元格内容水平居中
                        ,{field:'head_portrait', title: '展示图片', sort: true, align: 'right',templet:'<div><img src="{{d.head_portrait}}"></div>'} //单元格内容水平居中
                        ,{field:'start_business_hours', title: '总店营业时间', sort: true, align: 'right',templet:'<div>{{d.start_business_hours}}-{{d.end_business_hours}}</div>'}
                        ,{field:'site', title: '总店地址', sort: true, align: 'right'}
                        ,{field:'qr_code', title: '二维码', sort: true, align: 'right',templet:'<div><img src="{{d.qr_code}}"></div>'}
                        ,{field:'administrator', title: '总店管理员', sort: true, align: 'right'}
                        ,{field:'date_changed', title: '修改日期', sort: true, align: 'right'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
                    ]
                ]
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            table.reload('test', {
                url: '/headquarters/headquarters/queryByForm.do'
                ,where: {
                    company:$("#manager").val()
                    ,name:$("#name").val()
                } //设定异步数据接口的额外参数
            });
            return false;
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get("/headquarters/headquarters/delete.do?id="+data.id,function (ret) {
                        if(ret){
                            layer.msg("总店删除成功");
                        }else{
                            layer.msg("总店正在使用中,不能删除");
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                location.href = 'http://localhost:8080/headquarters/headquarters/toUpdate.do?id=' + data.id;
            }
        });
    });
</script>

</body>
</html>
