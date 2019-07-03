<%--
  Created by IntelliJ IDEA.
  User: 辛辣天森
  Date: 2019/6/14 0014
  Time: 上午 09:25
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
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
</blockquote>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>会员修改</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/member_management/member-management/update.do"  enctype="multipart/form-data" method="post">
    <input type="hidden" name="id" value="${member.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">选择头像</label>
        <div class="layui-input-inline">
            <img src="${member.head_portrait}" width="50px" height="50px">
            <input type="file" name="filename" lay-verify="required" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会员姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入姓名" autocomplete="off"
                   class="layui-input" value="${member.name}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-inline">
            <input type="radio" name="sex" value="1" title="男" ${member.sex eq '1'? 'checked':''}>
            <input type="radio" name="sex" value="2" title="女" ${member.sex eq '2'? 'checked':''}>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">会员生日</label>
            <div class="layui-input-block">
                <input type="text" name="birthday" id="date1"  lay-verify="required" autocomplete="off" class="layui-input"
                       value="${member.birthday}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-inline">
            <input type="text" name="number" placeholder="请输入手机号" lay-verify="required|phone|number" autocomplete="off" class="layui-input"
                   value="${member.number}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">会员地址</label>
        <div class="layui-input-inline">
            <input type="text" name="site" lay-verify="size" placeholder="请输入" autocomplete="off"
                   class="layui-input" value="${member.site}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">余额</label>
        <div class="layui-input-inline">
            <input type="text" name="balance" lay-verify="number" placeholder="请输入" autocomplete="off"
                   class="layui-input" value="${member.balance}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">会员等级</label>
        <div class="layui-input-inline">
            <select name="cla" lay-filter="aihao" lay-verify="required">
                <option value="">请选择</option>
                <option value="1" ${'1' eq member.cla ? 'selected':''}>一级</option>
                <option value="2" ${'2' eq member.cla ? 'selected':''}>二级</option>
                <option value="3" ${'3' eq member.cla ? 'selected':''}>三级</option>
                <option value="4" ${'4' eq member.cla ? 'selected':''}>四级</option>
                <option value="5" ${'5' eq member.cla ? 'selected':''}>五级</option>
                <option value="6" ${'6' eq member.cla ? 'selected':''}>六级</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入内容" class="layui-textarea">${member.remark}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <%--<button class="layui-btn" lay-filter="demo1" >提交</button>--%>
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

    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer
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
        });
        //监听提交
        form.on('submit(demo1)', function (data) {

         });

    });
</script>

</body>
</html>







