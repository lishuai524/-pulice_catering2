<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2019/05/13
Time: 17:02
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <legend>个人信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/staffs/staffs/update.do" enctype="multipart/form-data" method="post">
    <input type="hidden" name="id" value="${list.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">头像</label>
        <div class="layui-input-inline">
            <img src="${list.head_portrait}" width="50px" height="50px">
            <input type="file" name="filename" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">归属公司</label>
        <div class="layui-input-inline">
            <input readonly="readonly" name=""  autocomplete="off" class="layui-input" value="${list.company}"/>
        </div>
        <div class="layui-form-mid layui-word-aux"><i style="color: #CF1900">不可修改</i></div>
    </div>

    <div class="layui-form-item">
            <label class="layui-form-label">归属部门</label>
            <div class="layui-input-inline">
                <input readonly="readonly" name=""  autocomplete="off" class="layui-input" value="${list.department}"/>
            </div>
        <div class="layui-form-mid layui-word-aux"><i style="color: #CF1900">不可修改</i></div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">归属店铺</label>
        <div class="layui-input-inline">
                <input readonly="readonly" name=""  autocomplete="off" class="layui-input" value="${list.shop}"/>
        </div>
        <div class="layui-form-mid layui-word-aux"><i style="color: #CF1900">不可修改</i></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
                <input type="text" name="name"  autocomplete="off" class="layui-input" value="${list.name}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email"  autocomplete="off" class="layui-input" value="${list.email}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
                <input type="text" name="phone" lay-verify="required|dianhua" autocomplete="off" class="layui-input" value="${list.phone}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-inline">
                <input type="text" name="mobile_phone" lay-verify="required|phone|number" autocomplete="off" class="layui-input" value="${list.mobile_phone}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-inline">
                <textarea name="remark" placeholder="请输入内容" class="layui-textarea">${list.remark}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户角色</label>
        <div class="layui-input-inline">
            <input type="text" name="email"  autocomplete="off" class="layui-input" value="${list.role}"/>
        </div>
        <div class="layui-form-mid layui-word-aux"><i style="color: #CF1900">不可修改</i></div>
    </div>

    <div class="layui-form-item">
        <input id="f" class="layui-btn" lay-filter="demo1" type="submit" value="提交">
    </div>
</form>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    $("#f").click(function () {
        // alert("+++++");
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);//关闭当前页
    });

    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });


        //自定义验证规则
        form.verify({
            email: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").test(value)){
                    return '邮箱格式不正确';
                }
            }
            ,dianhua: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("[0-9-()()]{7,18}").test(value)){
                    return '电话格式不正确';
                }
            }
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //监听提交
        form.on('submit(demo2)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
        });

    });
</script>

</body>
</html>
