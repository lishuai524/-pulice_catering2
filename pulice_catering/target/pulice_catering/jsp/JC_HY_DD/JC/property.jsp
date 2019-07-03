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
        <li class="layui-this" id="yd">资产列表</li>
        <li >信息添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>食材库存</legend>
            </fieldset>
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">食材名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="raw_material" autocomplete="off" class="layui-input">
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

         <%--*******************************************************************************   --%>

            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>固定资产库存列表</legend>
            </fieldset>
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">所属店面</label>
                        <div class="layui-input-inline">
                            <select name="belong_to_shop" lay-filter="aihao">
                                <option value="a">选择</option>
                                <c:forEach items="${list}" var="i">
                                    <option value="${i.id}">${i.shop_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">资产名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo1">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </div>
            </form>

            <table class="layui-hide" id="test1" lay-filter="test"></table>
         <%--*******************************************************************************   --%>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>低值已消耗品库存列表</legend>
            </fieldset>
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">所属店面</label>
                        <div class="layui-input-inline">
                            <select name="belong_to_shop" lay-filter="aihao">
                                <option value="a">选择</option>
                                <c:forEach items="${list}" var="i">
                                    <option value="${i.id}">${i.shop_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">资产名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo2">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </div>
            </form>

            <table class="layui-hide" id="test2" lay-filter="test"></table>
    </div>
        <div class="layui-tab-item">
            <iframe src="/asset_information/asset-information/toadd.do" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">采购</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">盘库</a>
</script>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'table','element'], function () {
        var form = layui.form;
        var table = layui.table
            ,element = layui.element //Tab的切换功能，切换事件监听等，需要依赖element模块

        $("#yd").click(function () {
            table.reload("test")
            table.reload("test1")
            table.reload("test2")
        });

        //监听提交
        form.on('submit(formDemo)', function (data) {
            var list = data.field
            table.reload("test", {
                where: {
                    raw_material:list.raw_material
                }
            })
            return false;
        });
        //监听提交
        form.on('submit(formDemo1)', function (data) {
            var list = data.field
            table.reload("test1", {
                where: {
                    belong_to_shop:list.belong_to_shop,
                    name:list.name
                }
            })
            return false;
        });
        //监听提交
        form.on('submit(formDemo2)', function (data) {
            var list = data.field
            table.reload("test2", {
                where: {
                    belong_to_shop:list.belong_to_shop,
                    name:list.name
                }
            })
            return false;
        });
        table.render({
            elem: '#test'
            , url: '/asset_information/asset-information/queryAll.do'
            , cols: [[
                {field: 'raw_material', width: '12.5%', title:'原材料名称'}
                , {field: 'kind', width: '12.5%', title: '所属种类'}
                , {field: 'specification', width: '12.5%', title: '规格型号'}
                , {field: 'inventory', width: '12.5%', title: '当前库存数量'}
                , {field: 'consume', width: '12.5%', title: '当前消耗数量'}
                , {field: 'unit', width: '12.5%', title: '计量单位'}
                , {field: 'suggest', width: '12.5%', title: '补给建议'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '12.5%'}
            ]]
            , page: true
            , limit: 9
        });
        //************************************************************************************
        table.render({
            elem: '#test1'
            , url: '/asset_information/asset-information/queryAll1.do'
            , cols: [[
                {field: 'belong_to_shop', width: '14.3%', title:'所属店面',templet: '<div>{{d.stores_information.shop_name}}</div>'}
                , {field: 'name', width: '14.3%', title: '资产名称'}
                , {field: 'margin', width: '14.3%', title: '当前余量'}
                , {field: 'unit', width: '14.3%', title: '计量单位'}
                , {field: 'supplydate', width: '14.3%', title: '上次补给时间'}
                , {field: 'suggest', width: '14.3%', title: '补给建议'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '14.3%'}
            ]]
            , page: true
            , limit: 9
        });
        //************************************************************************************
        table.render({
            elem: '#test2'
            , url: '/asset_information/asset-information/queryAll2.do'
            , cols: [[
                {field: 'belong_to_shop', width: '14.3%', title:'所属店面',templet: '<div>{{d.stores_information.shop_name}}</div>'}
                , {field: 'name', width: '14.3%', title: '资产名称'}
                , {field: 'margin', width: '14.3%', title: '当前余量'}
                , {field: 'unit', width: '14.3%', title: '计量单位'}
                , {field: 'supplydate', width: '14.3%', title: '上次补给时间'}
                , {field: 'suggest', width: '14.3%', title: '补给建议'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '14.3%'}
            ]]
            , page: true
            , limit: 9
        });
        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            //console.log(obj)

        });

    });
</script>

</body>
</html>