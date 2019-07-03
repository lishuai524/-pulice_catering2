<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="/la/js/jquery.min.js"></script>

<div class="layui-form-item"></div>
<span class="layui-breadcrumb" lay-separator="|">
        <a href="/jsp/XT/staffs.jsp">员工列表</a>
        <a href="/staffs/staffs/toInsert_staffs.do">员工添加</a>
    </span>
<div class="layui-form-item"></div>

<div class="layui-form-item">
    <label class="layui-form-label">头像;</label>
    <div class="layui-upload">
        <div class="layui-upload-list">
            <img class="layui-upload-img" id="demo1" style="height: 80px;width: 80px">
        </div>
    </div>
    <label class="layui-form-label"></label>
    <div class="layui-upload">
        <div class="layui-upload-list">
            <p id="demoText"></p>
            <button type="button" class="layui-btn layui-btn-xs layui-btn-normal" id="test1">上传头像</button>
        </div>
    </div>
</div>
<form class="layui-form" onsubmit="return false">
    <input type="hidden" id="head_portrait" name="head_portrait">
    <div class="layui-form-item">
        <label class="layui-form-label">工号;</label>
        <div class="layui-input-inline">
            <input type="text" name="job_number" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            (*必填项)
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名;</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            (*必填项)
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">登录名;</label>
        <div class="layui-input-inline">
            <input type="text" name="login" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            (*必填项)
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码;</label>
        <div class="layui-input-inline">
            <input type="text" name="psd" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            (*必填项)
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码;</label>
        <div class="layui-input-inline">
            <input type="text" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            (*必填项)
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱;</label>
        <div class="layui-input-inline">
            <input type="text" name="email" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话;</label>
        <div class="layui-input-inline">
            <input type="text" name="phone" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机;</label>
        <div class="layui-input-inline">
            <input type="text" name="mobile_phone" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别;</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址;</label>
        <div class="layui-input-inline">
            <input type="text" name="site" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">QQ;</label>
        <div class="layui-input-inline">
            <input type="text" name="qq" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">微信号;</label>
        <div class="layui-input-inline">
            <input type="text" name="vx" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证;</label>
        <div class="layui-input-inline">
            <input type="text" name="identity_card" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄;</label>
        <div class="layui-input-inline">
            <input type="text" name="age" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色选择;</label>
        <div class="layui-input-block">
            <c:forEach var="role" items="${roleList}" varStatus="status">
                <input type="checkbox" name="role" value="${role.name}" title="${role.name}" ${status.index == 0 ? "checked":'' }>
            </c:forEach>
            (*必选项,至少选择一个)
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域;</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
        </div>
    </div>
</form>

<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form','element','upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,element = layui.element
            ,upload = layui.upload

        //监听提交
        form.on('submit(demo1)', function(data){
            var dataForm=JSON.stringify(data.field);
            alert(dataForm);
            $.ajax({
                url: '/staffs/staffs/insert_staffs.do',
                type: 'post',
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                data:dataForm,
                success: function(ret){
                    if(ret){
                        layer.msg("添加成功");

                    }else {
                        layer.msg("添加失败");
                    }
                },
            });
        });
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '/staffs/staffs/fileuploadExecl.do'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }else {
                    $("#head_portrait").val(res.url);
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });

</script>

</body>
</html>