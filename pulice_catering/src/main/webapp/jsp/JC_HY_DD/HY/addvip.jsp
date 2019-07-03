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
    <legend>会员添加</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/member_management/member-management/add.do" enctype="multipart/form-data" method="post">


    <%--<div class="layui-upload">--%>
        <%--<button type="button" class="layui-form-label" id="test1">头像</button>--%>
        <%--<div class="layui-upload-list">--%>
            <%--<img class="layui-upload-img" id="demo1" width="80px" height="80px">--%>
            <%--<p id="demoText"></p>--%>
        <%--</div>--%>
    <%--</div>--%>


    <div class="layui-form-item">
        <label class="layui-form-label">头像</label>
        <div class="layui-input-inline">
            <input type="file" name="filename" size="100px" lay-verify="required" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会员姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-inline">
            <input type="radio" name="sex" value="1" title="男" checked="">
            <input type="radio" name="sex" value="2" title="女">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">会员生日</label>
            <div class="layui-input-block">
                <input type="text" name="birthday" id="date1" autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-inline">
            <input type="text" name="number" lay-verify="required|phone|number" placeholder="请输入手机号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">会员地址</label>
        <div class="layui-input-inline">
            <input type="text" name="site"  lay-verify="size" placeholder="请输入" autocomplete="off" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">余额</label>
        <div class="layui-input-inline">
            <input type="text" name="balance" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">会员等级</label>
        <div class="layui-input-inline">
            <select name="cla" lay-filter="aihao" lay-verify="required">
                <option value="">请选择</option>
                <option value="1">一级</option>
                <option value="2">二级</option>
                <option value="3">三级</option>
                <option value="4">四级</option>
                <option value="5">五级</option>
                <option value="6">六级</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="demo2">提交</button>
    </div>
</form>

<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate','upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,$ = layui.jquery
            ,upload = layui.upload;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            size: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '地址不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '地址首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '地址不能全为数字';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

    });
</script>

</body>
</html>







