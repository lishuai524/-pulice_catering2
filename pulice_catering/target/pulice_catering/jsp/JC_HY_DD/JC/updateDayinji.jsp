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
    <legend>信息修改</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/dayinji/dayinji/update.do"  method="post">
    <input type="hidden" name="id" value="${dayin.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">设备名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" value="${dayin.name}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <input type="hidden" name="update_data">

    <div class="layui-form-item">
        <label class="layui-form-label">用途</label>
        <div class="layui-input-inline">
            <input type="text" name="yontu" value="${dayin.yontu}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">IP地址</label>
        <div class="layui-input-inline">
            <input type="text" name="ip" value="${dayin.ip}" lay-verify="ip" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">端口号</label>
        <div class="layui-input-inline">
            <input type="text" name="duanko" value="${dayin.duanko}" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择模板</label>
        <div class="layui-input-inline">
            <select name="dayin" lay-filter="aihao">
                <option value="">选择容量</option>
                <option value="101" ${'101' eq dayin.dayin ? 'selected':''}>后厨模板</option>
                <option value="102" ${'102' eq dayin.dayin ? 'selected':''}>收银模板</option>
                <option value="103" ${'103' eq dayin.dayin? 'selected':''}>前台模板</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <%--<input  class="layui-btn" lay-filter="demo1" type="submit" value="提交">--%>
            <button class="layui-btn" lay-submit lay-filter="demo1">提交</button>
    </div>
</form>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>


    $("#f").click(function () {
        // alert("+")
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);//关闭当前页
    });

    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        form.verify({
            ip: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))").test(value)){
                    return 'IP地址不正确';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });
        //监听提交
        form.on('submit(demo1)', function(data){
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);//关闭当前页
        });

    });
</script>
</body>
</html>
