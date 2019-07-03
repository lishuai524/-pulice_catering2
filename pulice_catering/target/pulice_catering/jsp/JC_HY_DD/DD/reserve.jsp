<%--
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
        <li class="layui-this" id="yd">预定列表</li>
        <li >预定添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">预留手机号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="reserved" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">下单时间</label>
                        <div class="layui-input-inline">
                            <input type="text" name="order_date" id="date1" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </div>
            </form>

            <table class="layui-hide" id="test" lay-filter="test"></table>
        </div>
        <div class="layui-tab-item">
           <iframe src="/reserve_tables_list/reserve-tables-list/toadd.do" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script type="text/html" id="img">
    <div><img style="height:35px;width:35px;border-radius:50%;line-height:50px!important;" src="{{d.head_portrait}}">
    </div>
</script>

<script type="text/html" id="titleTpl">
    {{#  if(d.sex == '1'){ }}
    男
    {{#  } else { }}
    女
    {{#  } }}
</script>
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
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });


        //触发事件
        var active = {
            tabAdd: function () {
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项' + (Math.random() * 1000 | 0) //用于演示
                    , content: '内容' + (Math.random() * 1000 | 0)
                    , id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
            }
            , tabDelete: function (othis) {
                //删除指定Tab项
                element.tabDelete('demo', '44'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            , tabChange: function () {
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };

        $('.site-demo-active').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function (elem) {
            location.hash = 'test=' + $(this).attr('lay-id');
        });


        //监听提交
        form.on('submit(formDemo)', function (data) {
            var list = data.field
            table.reload("test", {
                where: {
                    reserved:list.reserved,
                    order_date:list.order_date
                }
            })
            return false;
        });
        table.render({
            elem: '#test'
            , url: '/reserve_tables_list/reserve-tables-list/queryAll.do'
            , cols: [[
                {field: 'number', width: '9.1%', title: '编号', sort: true}
                , {field: 'name', width: '11.1%', title: '姓名'}
                , {field: 'people', width: '6.1%', title: '人数'}
                , {field: 'reserved', width: '11.1%', title: '预留手机号'}
                , {field: 'order_date', width: '15.1%', title: '下单日期'}
                , {field: 'scheduled_time', width: '15.1%', title: '预定时间'}
                , {field: 'order_status', width: '11.1%', title: '状态', templet: '<div>{{d.order_status.name}}</div>'}
                , {field: 'remark', width: '11.1%', title: '备注'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '12%'}
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
                        url: "/reserve_tables_list/reserve-tables-list/delete/" + data.id + ".do",
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
                    content: "/reserve_tables_list/reserve-tables-list/toupdate/" + data.id + ".do",
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