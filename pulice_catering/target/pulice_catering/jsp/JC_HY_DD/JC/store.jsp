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
    <link rel="stylesheet" href="/layui/css/modules/laydate/default/laydate.css" media="all">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this" id="dj">排队列表</li>
        <li >信息添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">门店名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="shop_name" autocomplete="off" class="layui-input">
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
        </div>
        <div class="layui-tab-item">
            <iframe src="/jsp/JC_HY_DD/JC/addStore.jsp" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="qr">
    <div><img style="width: 50px;height:50px " src=${pageContext.request.contextPath }"{{d.ewmcode}}"></div>
</script>

<script type="text/html" id="img">
<div><img style="width: 50px;height:50px " src=${pageContext.request.contextPath }"{{d.picture}}"></div>
</script>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script>
    layui.use(['form','table','element'], function(){
        var form = layui.form
            , table = layui.table
            ,element = layui.element
            , layer = layui.layer

        $("#dj").click(function () {
            table.reload("test")
        });
        table.render({
            elem: '#test'
            ,url:'/stores_information/stores-information/queryAll.do'
            ,cols: [
                [
                    {field:'shop_name', width:'8%', title: '<font size="2px">门店名称<font>'}
                    ,{field:'picture', width:'8%', title: '<font size="2px">展示图片<font>',templet: '#img'}
                    ,{field:'manager', width:'7%', title: '<font size="2px">门店经理<font>'}
                    ,{field:'business_min', width:'13%', title: '<font size="2px">营业时间</font>'
                    ,templet: function(d){
                        return d.business_min+'-'+d.business_max
                    }}
                    ,{field:'phone', width:'10%', title: '<font size="2px">联系电话<font>'}
                    ,{field:'email', width:'12%', title: '<font size="2px">电子邮箱<font>'}
                    ,{field:'shop_site', width:'10%', title: '<font size="2px">门店地址<font>'}
                    ,{field:'ewmcode', width:'8%',event:'ewm', title: '<font size="2px">二维码<font>',templet: '#qr'}
                    ,{field:'update_data', width:'14%', title: '<font size="2px">修改日期<font>'}
                    ,{fixed: 'right', title:'<font size="2px">操作<font>', toolbar: '#barDemo', width:'10%'}
                ]
            ]
            ,page: true
            ,limit:9
        });

        //监听提交
        form.on('submit(formDemo)', function (data) {
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // })
            var list = data.field
            table.reload("test",{
                where:{
                    shop_name:list.shop_name
                }
            })
            return false;
        });

        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get({
                        url:"/stores_information/stores-information/delete/"+data.id+".do",
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
                    content: "/stores_information/stores-information/toupdate/"+data.id+".do",
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
            }else if(obj.event === 'ewm'){
                layer.open({
                    type: 2,
                    area:["500px","500px"],
                    offset:"100px",
                    content: data.ewmcode,
                });
            }
        });
    });
</script>
</body>
</html>