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
    <legend>资产信息添加</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/asset_information/asset-information/add.do"  method="post">

    <div class="layui-form-item">
        <label class="layui-form-label">资产类型</label>
        <div class="layui-input-inline">
            <select name="type" lay-filter="aihao" lay-verify="required">
                <option value="">选择类型</option>
                <option value="101">固定资产</option>
                <option value="102">低值易消耗品</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属门店</label>
        <div class="layui-input-inline">
            <select name="belong_to_shop" lay-filter="aihao">
                <option value="">选择状态</option>
                <c:forEach items="${list}" var="i">
                    <option value="${i.id}">${i.shop_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">资产名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">资产数量</label>
        <div class="layui-input-inline">
            <input type="text" name="margin" lay-verify="required|number" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">计量单位</label>
        <div class="layui-input-inline">
            <input type="text" name="unit" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上次补给时间</label>
        <div class="layui-input-inline">
            <input type="text" name="supplydate" id="date" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>



    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单价</label>
        <div class="layui-input-inline">
            <input type="text" name="unit_price" lay-verify="required|number" placeholder="请输入" autocomplete="off" class="layui-input" >
        </div>
    </div>



    <div class="layui-form-item">
        <label class="layui-form-label">补给建议</label>
        <div class="layui-input-block">
            <textarea name="suggest" placeholder="请输入内容" class="layui-textarea"></textarea>
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
    layui.use(['form','table', 'laydate'], function(){
        var form = layui.form;
        var layer = layui.layer;
        var table = layui.table
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
            ,type:'datetime'
        });
        laydate.render({
            elem: '#date1'
        });

        //监听提交
        form.on('submit(demo2)', function(data){
            layer.msg("添加成功")
        });

    });
</script>
</body>
</html>
