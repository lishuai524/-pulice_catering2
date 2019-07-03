<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
    <legend>个人密码修改</legend>
</fieldset>
<form class="layui-form layui-form-pane"  method="post">
    <input type="hidden" name="id" value="">
    <div class="layui-form-item">
        <label class="layui-form-label">旧密码</label>
        <div class="layui-input-inline">
            <input type="password" name="pwd" id="pwd" lay-verify="required" autocomplete="off" class="layui-input" >
        </div>
        <div class="layui-form-mid layui-word-aux"><span id="span" style="color: #CF1900"></span></div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="xpwd" id="xpwd" lay-verify="pass" placeholder="请输入新密码" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">确认新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="qxpwd" id="qxpwd" lay-verify="pass" placeholder="请确认新密码" autocomplete="off" class="layui-input" >
        </div>
        <div class="layui-form-mid layui-word-aux"><span id="span1" style="color: #CF1900"></span></div>
    </div>

    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="demo2">修改密码</button>
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


        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(demo2)', function(data){
            var pwd = $("#pwd").val();
            var xpwd = $("#xpwd").val();
            var qxpwd = $("#qxpwd").val();
            if(xpwd === qxpwd){
                $.get({
                    url: "/staffs/staffs/updatepwd.do?pwd="+pwd+"&xpwd="+xpwd,
                    success: function (data) {
                        if(data === "true"){
                            layer.msg("修改成功");
                            $("#pwd").val('');
                            $("#xpwd").val('');
                            $("#qxpwd").val('');
                            $("#span").html("");
                            $("#span1").html("");
                        }else {
                            $("#span").html("旧密码错误！");
                            $("#pwd").val('');
                        }
                    }
                });
            }else {
                $("#span1").html("两次新密码不一致");
                $("#qxpwd").val('');
            }
            return false;
        });

    });
</script>
</body>
</html>
