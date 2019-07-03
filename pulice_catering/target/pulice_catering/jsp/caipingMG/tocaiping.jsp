<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>菜品修改</legend>
</fieldset>

<form class="layui-form" action="/caiping/update.do" method="post" enctype="multipart/form-data">

    <div class="layui-form-item">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="hidden" name="id" value="${list.id}" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">菜品图片</label>
        <div class="layui-input-block">
            <div class="layui-input-block">
                <img src="/img/${list.img}" style="height:80px;width:80px;border-radius:50%;">
            </div>
            <div class="layui-input-block layui-upload">
                <input type="file" name="filename" size="100px" autocomplete="off">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">所属菜单</label>
        <div class="layui-input-block">
            <select name="caidanid">
                <c:forEach items="${clist}" var="li">
                <option value="${li.caidanid}" ${li.caidanid eq list.caidanid ? 'selected':''}>${li.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">菜品名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" value="${list.name}" lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">菜品类别</label>
        <div class="layui-input-block">
            <select name="type">
                <c:forEach items="${tlist}" var="li">
                    <option value="${li.id}" ${li.id eq list.type ? 'selected':''}>${li.type}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">原材料</label>
        <div class="layui-input-block">
            <input type="text" name="cailiao" value="${list.cailiao}" lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">数量</label>
        <div class="layui-input-block">
            <input type="text" name="number" value="${list.number}" lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单位</label>
        <div class="layui-input-block">
            <select name="danwei">
                <c:forEach items="${dlist}" var="li">
                    <option value="${li.id}" ${li.id eq list.danwei ? 'selected':''}>${li.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">厨师</label>
        <div class="layui-input-block">
            <input type="text" name="maker" value="${list.maker}" lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input type="text" name="price" value="${list.price}" lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">修改日期</label>
        <div class="layui-input-block">
            <input type="text" name="xiugai" value="${list.xiugai}" id="date1" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">特色菜</label>
        <div class="layui-input-block">
            <input type="radio" name="tesecai" value="是" ${list.tesecai eq '是'? 'checked':''} title="是">
            <input type="radio" name="tesecai" value="否" ${list.tesecai eq '否'? 'checked':''} title="否">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-inline">
            <textarea name="test" style="width: 1000px;" maxlength="250" rows="5" class="layui-textarea">${list.test}</textarea>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" id="f1" lay-filter="demo1">修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="/layui/jquery-3.3.1.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        // laydate.render({
        //     elem: '#date1'
        //     ,type:'datetime'
        // });
        //
        // laydate.render({
        //     elem: '#date2'
        //     ,type:'datetime'
        // });


        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        // //自定义验证规则
        // form.verify({
        //     title: function(value){
        //         if(value.length < 5){
        //             return '标题至少得5个字符啊';
        //         }
        //     }
        //     ,pass: [
        //         /^[\S]{6,12}$/
        //         ,'密码必须6到12位，且不能出现空格'
        //     ]
        //     ,content: function(value){
        //         layedit.sync(editIndex);
        //     }
        // });


        // //监听提交
        // form.on('submit(demo1)', function (data) {
        //     layer.alert(JSON.stringify(data.field), {
        //         title: '最终的提交信息'
        //     })
        //     return false;
        // });

        //表单初始赋值
        // form.val('example', {
        //     "username": "贤心" // "name": "value"
        //     , "password": "123456"
        //     , "interest": 1
        //     , "like[write]": true //复选框选中状态
        //     , "close": true //开关状态
        //     , "sex": "女"
        //     , "desc": "我爱 layui"
        // })

    });
    $("#f1").click(function () {
        var index=parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });
</script>

</body>
</html>
