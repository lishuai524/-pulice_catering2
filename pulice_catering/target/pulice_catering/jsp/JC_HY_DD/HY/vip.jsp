<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/05/13
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
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
<form class="layui-form"  method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="number" lay-verify="required|phone|number"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>

</form>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script type="text/html" id="img">
    <div><img style="height:35px;width:35px;border-radius:50%;line-height:50px!important;" src="{{d.head_portrait}}"></div>
</script>
<script type="text/html" id="titleTpl">
    {{#  if(d.sex == '1'){ }}
    男
    {{#  } else { }}
    女
    {{#  } }}
</script>

<script>

    layui.use(['form','table'], function(){
        var form = layui.form;
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/member_management/member-management/queryVip.do'
            ,cols: [
                [
                {field:'id', width:'4%', title: '会员编号', sort: true}
                ,{field:'head_portrait', width:'6%', title: '会员头像',templet: '#img'}
                ,{field:'name', width:'9%', title: '会员名称'}
                ,{field:'sex', width:'9%', title: '性别',templet:"#titleTpl"}
                ,{field:'birthday', width:'9%', title: '会员生日'}
                ,{field:'number', width:'9%', title: '手机号码'}
                ,{field:'site', width:'9%', title: '会员地址'}
                ,{field:'balance', width:'9%', title: '余额'}
                ,{field:'cla', width:'4%', title: '等级'}
                ,{field:'remark', width:'18.5%', title: '备注'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'14%'}
            ]
            ]
            ,page: true
            ,limit:9
        });

        //监听提交
        form.on('submit(formDemo)', function (data) {
            var list = data.field
            table.reload("test",{
                where:{
                    name:list.name,
                    number:list.number
                }
            })
            return false;
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get({
                        url:"/member_management/member-management/delete/"+data.id+".do",
                        success:function (data) {
                            if (data) {
                                layer.msg("删除成功")
                                table.reload("test")
                            }
                        }
                    });
                    layer.close(index);
                });

            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    area:["600px","800px"],
                    offset:"100px",
                    fixed:true,
                    content: "/member_management/member-management/toupdate/"+data.id+".do",
                    cancel: function(index, layero){
                        if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                            table.reload("test")
                            layer.close(index)
                        }
                    },
                    end:function () {
                        location.reload();
                    }
                });
            }
        });
    });
</script>

</body>
</html>