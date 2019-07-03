<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<span span class="layui-breadcrumb" lay-separator="|">
    <a href="/jsp/XT/role_management.jsp">角色列表</a>
    <a href="/jsp/XT/role_management_fenpei.jsp">角色分配</a>
</span>
<div class="layui-form-item"></div>

<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">角色名称: </label>
        <div class="layui-input-inline">
            <input value="${role.name}" id="name" class="layui-input" style="border:none" readonly>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">英文名称: </label>
        <div class="layui-input-inline">
            <input value="${role.english}" class="layui-input" style="border:none" readonly>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">归属机构: </label>
        <div class="layui-input-inline">
            <input value="${role.department}" class="layui-input" style="border:none" readonly>
        </div>
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">角色类型: </label>
        <div class="layui-input-inline">
            <input value="${role.role}" class="layui-input" style="border:none" readonly>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">数据范围: </label>
        <div class="layui-input-inline">
            <input value="${role.scope}" class="layui-input" style="border:none" readonly>
        </div>
    </div>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">分配角色</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">移除</a>
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
            ,url: '/staffs/staffs/queryAllByRole.do'
            ,toolbar: '#toolbarDemo'
            ,title: '角色列表'
            ,totalRow: true
            ,where:{role:$("#name").val()}
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols:
                [
                    [
                        {field:'company', title: '归属公司'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                        ,{field:'department', title: '归属部门', align: 'center'} //单元格内容水平居中
                        ,{field:'login', title: '登录名', sort: true, align: 'right'} //单元格内容水平居中
                        ,{field:'name', title: '姓名', sort: true, align: 'right'}
                        ,{field:'phone', title: '电话', sort: true, align: 'right'}
                        ,{field:'mobile_phone', title: '手机', sort: true, align: 'right'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
                    ]
                ]
            ,page: true
            ,limit:7
        });

        //工具栏事件
        table.on('toolbar(test)', function(obj){
            layer.open({
                type: 2,
                area: ['1000px', '500px'],
                content: '/staffs/staffs/toInsert.do?role='+$("#name").val() //这里content是一个url
                ,cancel: function(index, layero){
                    if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                        layer.close(index)
                        table.reload("test");//刷新父页面
                    }
                    return false;
                }
            });
            return false;
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的移除行么', function(index){
                    $.get("/staffs/staffs/deleteById.do?id="+data.id,function (ret) {
                        if(ret){
                            layer.msg("该员工的此项角色移除成功");
                        }else{
                            layer.msg("该员工的此项角色为唯一角色,不能移除");
                        }
                    });
                });
            }
        });
    });
</script>

</body>
</html>
