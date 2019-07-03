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
    <legend>信息修改</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/stores_information/stores-information/update.do" enctype="multipart/form-data" method="post">
    <input type="hidden" name="id" value="${sto.id}">
    <input type="hidden" name="ewmcode" value="${sto.ewmcode}">
    <input type="hidden" name="update_data" value="${sto.update_data}">
    <div class="layui-form-item">
        <label class="layui-form-label">门店名称</label>
        <div class="layui-input-inline">
            <input type="text" name="shop_name" value="${sto.shop_name}" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">展示图片</label>
        <div class="layui-input-inline">
            <img src="${sto.picture}" width="50px" height="50px">
            <input type="file" name="filename1" lay-verify="required"  >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">门店经理</label>
        <div class="layui-input-inline">
            <input type="text" name="manager" value="${sto.manager}" lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">营业时间</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="hidden" id="bus" name="business_hours">
                <input type="text" name="business_min"  value="${sto.business_min}" id="date1" placeholder="营业" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="business_max" value="${sto.business_max}" id="date" placeholder="下班" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="phone" value="${sto.phone}" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电子邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" value="${sto.email}" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">门店地址</label>
        <div class="layui-input-inline">
            <input type="text" name="shop_site" value="${sto.shop_site}" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <input id="f" class="layui-btn" lay-filter="demo2" type="submit" value="提交">
    </div>
</form>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    $("#f").click(function () {
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
            ,type:'time'
        });
        laydate.render({
            elem: '#date1'
            ,type:'time'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        //监听提交
        form.on('submit(demo2)', function(data){
            return false;
        });



    });
</script>

</body>
</html>