<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<script src="/la/js/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->


<div class="layui-form-item"></div>
    <div class="layui-breadcrumb" lay-separator="|" style="border: 1px solid #5c798f;width: 100%;height: 30px">
        <a href="#">门店初始化步骤</a>
    </div>
<div class="layui-form-item"></div>

<div class="layui-form-item"></div>
    <div class="layui-breadcrumb" lay-separator="|" style="border: 1px solid #5c798f;width: 100%;height: 30px">
        <a href="#">第一步:门店基础信息设置</a>
        <a href="#">第二步:添加菜单</a>
        <a href="#">第三步:销售计划制定</a>
        <a href="#">第四步:完成</a>
    </div>
<div class="layui-form-item"></div>

<div class="layui-form-item">
    <label class="layui-form-label">门店名称</label>
    <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
</div>

<div class="layui-form-item"></div>
    <div class="layui-breadcrumb" lay-separator="|" style="border: 1px solid #5c798f;width: 100%;height: 30px">
        <a href="#">堂口设置</a>
        <span style="float: right"><button class="layui-btn layui-btn-xs layui-btn-normal" onclick="onadd()">新增</button ><button class="layui-btn layui-btn-xs layui-btn-normal" onclick="onupd()">删除</button></span>
    </div>
<div class="layui-form-item"></div>

<div class="layui-form-item"></div>
    <table width="100%" border="1" id="tables">
        <tr><td>堂口名称</td><td>菜品名称</td><td>传递打印机</td><td>后厨打印机</td><td>收银打印机</td></tr>
        <tr id="tr"><td>堂口名称</td><td>菜品名称</td><td>传递打印机</td><td>后厨打印机</td><td>收银打印机</td></tr>

    </table>
<div class="layui-form-item"></div>





<script>
    layui.use(['form','element'], function(){
        var element = layui.element
            ,form = layui.form;
    });

    var t1 = "";
    var onadd = function () {
       $("#tables").appendChild($("#tr").parentNode.parentNode.nextSibling.cloneNode(ture));
    }
</script>

</body>
</html>
