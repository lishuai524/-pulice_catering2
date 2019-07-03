<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/05/13
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this" id="yd">堂口列表</li>
        <li >信息添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">队列类型</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">桌台容量</label>
                        <div class="layui-input-inline">
                            <select name="category" lay-filter="aihao">
                                <option value="a">选择状态</option>
                                <c:forEach items="${list}" var="i">
                                    <option value="${i.fcid}">${i.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </div>
            </form>

            <table class="layui-hide" id="test" lay-filter="test"></table>
        </div>
        <div class="layui-tab-item">
            <iframe src="/tangkou_information/tangkou-information/toadd.do" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'table','element', 'layedit', 'laydate'], function () {
        var form = layui.form;
        var table = layui.table
            ,element = layui.element //Tab的切换功能，切换事件监听等，需要依赖element模块
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        $("#yd").click(function () {
            table.reload("test")
        });

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
            // ,type:'datetime'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');


        $('.site-demo-active').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });


        //监听提交
        form.on('submit(formDemo)', function (data) {
            var list = data.field
            table.reload("test", {
                where: {
                    name:list.name,
                    category:list.category
                }
            })
            return false;
        });
        table.render({
            elem: '#test'
            , url: '/tangkou_information/tangkou-information/queryAll.do'
            , cols: [[
                {field: 'name', width: '16.7%', title: '堂口名称  '}
                , {field: 'category', width: '16.7%', title: '菜品类别',templet: '<div>{{d.categorys.name}}</div>'}
                , {field: 'printer', width: '16.7%', title: '打印机名称'}
                , {field: 'executive_chef', width: '16.7%', title: '总厨'}
                , {field: 'remarks', width: '16.7%', title: '备注'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '16.7%'}
            ]]
            , page: true
            , limit: 9
        });
        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    $.get({
                        url: "/tangkou_information/tangkou-information/delete/" + data.id + ".do",
                        success: function (data) {
                            if (data) {
                                layer.msg("删除成功")
                                table.reload("test")
                            }
                        }
                    });
                    layer.close(index);
                });

            } else if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    area: ["600px", "800px"],
                    offset: "100px",
                    fixed: true,
                    content: "/tangkou_information/tangkou-information/toupdate/" + data.id + ".do",
                    cancel: function (index, layero) {
                        if (confirm('确定要关闭么')) { //只有当点击confirm框的确定时，该层才会关闭
                            table.reload("test")
                            layer.close(index)
                        }
                    },
                    end: function () {
                        location.reload();
                    }
                });
            }
        });

    });
</script>

</body>
</html>