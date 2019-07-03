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
    <script src="/la/lib/layui/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>

<div class="layui-row">
    <div class="layui-col-md3">
        <div class="grid-demo"><i class="layui-icon">&#xe62b;</i>组织机构：</div>
        <div id="test5" class="demo-tree"></div>
    </div>

    <div class="layui-col-md9">
        <div class="layui-form-item"></div>
            <span class="layui-breadcrumb" lay-separator="|">
                <a href="/jsp/XT/staffs.jsp">员工列表</a>
                <a href="/staffs/staffs/toInsert_staffs.do">员工添加</a>
            </span>
        <div class="layui-form-item"></div>
        <form class="layui-form" id="staffsForm" onsubmit="return false">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">归属公司: </label>
                    <div class="layui-input-inline">
                        <select id="company" name="company" readonly>
                            <option value="">请选择公司</option>
                            <option value="星期五餐饮总公司">星期五餐饮总公司</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">登录名: </label>
                    <div class="layui-input-inline">
                        <input type="text" id="login" name="login" placeholder="请输入" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">归属部门: </label>
                    <div class="layui-input-inline">
                        <select id="department" name="department" readonly>
                            <option value="">请选择部门</option>
                            <option value="总门店人员">总门店人员</option>
                            <option value="平台管理员">平台管理员</option>
                            <option value="门店人员">门店人员</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">姓名: </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" placeholder="请输入" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
                    </div>
                </div>
            </div>
        </form>
        <table class="layui-hide" id="test" lay-filter="test"></table>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<script src="/la/js/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['form','table','element','tree', 'util'], function () {
        var tree = layui.tree
            , layer = layui.layer
            , util = layui.util
            ,table = layui.table
            ,element = layui.element
            ,form = layui.form

            //模拟数据
            , data = [{
                title: '星期五餐饮总平台'
                , id: 101
                ,spread:tree
                , children: [{
                    title: '平台管理员'
                    , id: 1011
                }, {
                    title: '总门店平台管理'
                    , id: 102
                    ,spread:tree
                    , children: [{
                        title: '总门店人员'
                        , id: 1021
                    }, {
                        title: '门店管理'
                        , id: 103
                        ,spread:tree
                        , children: [{
                            title: '门店人员'
                            , id: 1031
                        }
                        ]
                    }
                    ]
                }]
            }
            ]

        table.render({
            elem: '#test'
            ,url: '/staffs/staffs/queryAll.do'
            ,title: '员工列表'
            ,totalRow: true
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols:
                [
                    [
                        {field:'company', title: '归属公司'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                        ,{field:'department', title: '归属部门', align: 'center'} //单元格内容水平居中
                        ,{field:'login', title: '登录名', sort: true, align: 'right'} //单元格内容水平居中
                        ,{field:'name', title: '姓名', sort: true, align: 'right'}
                        ,{field:'shop', title: '归属门店', align: 'center'}
                        ,{field:'phone', title: '电话', sort: true, align: 'right'}
                        ,{field:'mobile_phone', title: '手机', sort: true, align: 'right'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
                    ]
                ]
            ,page: true
            ,limit:7
        });

        //点击节点新窗口跳转
        tree.render({
            elem: '#test5'
            , data: data
            , showLine: false  //是否开启连接线
            , onlyIconControl: true  //是否仅允许节点左侧图标控制展开收
            , click: function (obj) {
                table.reload('test', {
                    url: '/staffs/staffs/queryByDepartmentToo.do'
                    ,where: {department:obj.data.title} //设定异步数据接口的额外参数
                });
            }
            , isJump: true  //跳转
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            table.reload('test', {
                url: '/staffs/staffs/queryByForm.do'
                ,where: {
                    company:$("#company").val()
                    ,login:$("#login").val()
                    ,department:$("#department").val()
                    ,name:$("#name").val()
                } //设定异步数据接口的额外参数
            });
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get("/staffs/staffs/delete.do?id="+data.id,function (ret) {
                        if(ret){
                            layer.msg("角色删除成功");
                        }else{
                            layer.msg("角色删除失败");
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                location.href = 'http://localhost:8080//staffs/staffs/toUpdate.do?id=' + data.id;
            }
        });
    });
</script>
</body>
</html>