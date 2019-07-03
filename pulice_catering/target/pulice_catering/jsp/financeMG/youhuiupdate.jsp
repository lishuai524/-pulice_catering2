<%--
  Created by IntelliJ IDEA.
  User: 李敏捷
  Date: 2019/06/12
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <title>修改优惠券</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<script src="/layui/jquery-3.3.1.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改优惠</legend>
</fieldset>

<form class="layui-form" action="../youhui/update.do">
  <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="hidden" value="${youhui.id}" name="id" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">优惠劵名：</label>
        <div class="layui-input-block">
            <input type="text" value="${youhui.name}" name="name" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">优惠金额：</label>
        <div class="layui-input-block">
            <input type="text" value="${youhui.money}" name="money" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">开始时间：</label>
        <div class="layui-input-block">
            <input type="date" value="${youhui.start}" name="start" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">结束时间：</label>
        <div class="layui-input-block">
            <input type="date"  value="${youhui.end}" name="end" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注：</label>
        <div class="layui-input-block">
            <input type="text" value="${youhui.test}" name="test" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" id="sub" class="layui-btn" lay-submit lay-filter="formDemo">确定修改</button>
        </div>
    </div>
</form>

<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>


<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date1'
            ,type: 'date'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        // form.on('submit(demo1)', function(data){
        //     form.submit();
        //     return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        // });
    });
    $("#sub").click(function () {
        var index=parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });
</script>
<%--<script>
    layui.use('form', function(data){
        var form = layui.form;
        $("sub").click(function () {
            var index=parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });
        form.on('submit(*)', function(data){
        })

    });

</script>--%>
</body>
</html>