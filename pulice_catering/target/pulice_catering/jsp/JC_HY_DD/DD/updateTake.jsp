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
    <legend>外卖单修改</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/take_out/take-out/update.do"  method="post">
    <input type="hidden" name="id" value="${take.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" value="${take.name}" lay-verify="required" autocomplete="off" class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">预留手机号</label>
        <div class="layui-input-inline">
            <input type="text" name="cell_phone_number" value="${take.cell_phone_number}" lay-verify="required|phone|number"  placeholder="请输入手机号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">菜品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="greens_name" value="${take.greens_name}" lay-verify="number" placeholder="请输入数字" autocomplete="off" class="layui-input" >
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">单价</label>
            <div class="layui-input-block">
                <input type="text" name="unit_price" value="${take.unit}"  autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">计量单位</label>
            <div class="layui-input-block">
                <input type="text" name="unit" value="${take.unit}" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-block">
                <input type="text" name="quantity" value="${take.quantity}" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">总价</label>
            <div class="layui-input-block">
                <input type="text" name="prices" value="${take.prices}" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">优惠卷金额</label>
            <div class="layui-input-block">
                <input type="text" name="discount_coupon" value="${take.discount_coupon}" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">下单时间</label>
            <div class="layui-input-block">
                <input type="text" name="time" value="${take.time}" id="date1 " autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-inline">
            <input type="radio" name="osid" value="1" title="未付款" ${take.osid eq '1'? 'checked':''}>
            <input type="radio" name="osid" value="2" title="已结账" ${take.osid eq '2'? 'checked':''}>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">送餐地址</label>
        <div class="layui-input-inline">
            <input type="text" name="site" value="${take.site}" lay-verify="required" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入内容" class="layui-textarea">${manag.remark}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <%--<button class="layui-btn" lay-submit lay-filter="demo2">提交</button>--%>
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
            ,type:'datetime'
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
        });


    });
</script>
</body>
</html>
