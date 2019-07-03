<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2019/05/13
Time: 17:02
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
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
</blockquote>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>桌台信息添加</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/stores_information/stores-information/add.do" enctype="multipart/form-data" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">门店名称</label>
        <div class="layui-input-inline">
            <input type="text" name="shop_name" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">展示图片</label>
        <div class="layui-input-inline">
            <input type="file" name="filename" lay-verify="required" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">门店经理</label>
        <div class="layui-input-inline">
            <input type="text" name="manager" lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">营业时间</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="business_min" id="date1" lay-verify="required" placeholder="营业" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="business_max" id="date" lay-verify="required" placeholder="下班" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="phone" lay-verify="required|phone|number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电子邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" lay-verify="required|email" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">门店地址</label>
        <div class="layui-input-inline">
            <input type="text" name="shop_site" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="demo2">提交</button>
    </div>
</form>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
            ,type:'time'
        });
        laydate.render({
            elem: '#date1'
            ,type:'time'
        });

            //自定义验证规则
            form.verify({
                email: function(value, item){ //value：表单的值、item：表单的DOM对象
                    if(!new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").test(value)){
                        return '邮箱格式不正确';
                    }
                }
            });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        //监听提交
        form.on('submit(demo2)', function(data){
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // })
            // return false;
            layer.msg("添加成功",5000)
        });



    });
</script>

</body>
</html>