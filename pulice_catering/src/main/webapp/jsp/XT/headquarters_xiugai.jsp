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
        <a href="/jsp/XT/headquarters.jsp">总店信息列表</a>
        <a href="/headquarters/headquarters/toInsert_headquarters.do">总店信息添加</a>
    </span>
<div class="layui-form-item"></div>

<div class="layui-form-item">
    <label class="layui-form-label">展示图片;</label>
    <div class="layui-upload">
        <div class="layui-upload-list">
            <img class="layui-upload-img" id="demo1" src="${headquarters.head_portrait}" style="height: 80px;width: 80px">
        </div>
    </div>
    <label class="layui-form-label"></label>
    <div class="layui-upload">
        <div class="layui-upload-list">
            <p id="demoText"></p>
            <button type="button" class="layui-btn layui-btn-xs layui-btn-normal" id="test1">上传图片</button>
        </div>
    </div>
</div>

<form class="layui-form" onsubmit="return false">
    <input type="hidden" id="head_portrait" name="head_portrait" value="${headquarters.head_portrait}">
    <input type="hidden" id="id" name="id" value="${headquarters.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">总店经理;</label>
        <div class="layui-input-inline">
            <select name="manager">
                <c:forEach var="staffs" items="${staffsList}">
                    <option value="${staffs.name}" ${staffs.name == headquarters.manager ? "selected":'' }>${staffs.name}(${staffs.job_number}-${staffs.role}-${staffs.department})</option>
                </c:forEach>
            </select>
        </div>
        <div id="staffsNameOne"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">总店名称;</label>
        <div class="layui-input-inline">
            <input type="text" name="name" value="${headquarters.name}" placeholder="请输入" class="layui-input">
            (*必填项)
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">营业时间;</label>
        <div class="layui-input-inline">
            <input type="time" name="start_business_hours" value="${headquarters.start_business_hours}" placeholder="请输入" class="layui-input">
            <input type="time" name="end_business_hours" value="${headquarters.end_business_hours}" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话;</label>
        <div class="layui-input-inline">
            <input type="text" name="phone" value="${headquarters.phone}" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电子邮箱;</label>
        <div class="layui-input-inline">
            <input type="text" name="email" value="${headquarters.email}" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">采购方式;</label>
        <div class="layui-input-inline">
            <select name="method">
                <option value="门店采购" ${headquarters.method == '门店采购' ? "selected":'' }>门店采购</option>
                <option value="集中采购" ${headquarters.method == '集中采购' ? "selected":'' }>集中采购</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">总店地址;</label>
        <div class="layui-input-inline">
            <input type="text" name="site" value="${headquarters.site}" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">总店管理员;</label>
        <div class="layui-input-inline">
            <select name="administrator">
                <c:forEach var="staffs" items="${staffsList}">
                    <option value="${staffs.name}" ${staffs.name == headquarters.administrator ? "selected":'' }>${staffs.name}(${staffs.job_number}-${staffs.role}-${staffs.department})</option>
                </c:forEach>
            </select>
        </div>
        <div id="staffsNameTwo"></div>
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
                url: '/headquarters/headquarters/update_headquarters.do',
                type: 'post',
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                data:dataForm,
                success: function(ret){
                    if(ret){
                        layer.msg("修改成功");
                    }else {
                        layer.msg("修改失败");
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