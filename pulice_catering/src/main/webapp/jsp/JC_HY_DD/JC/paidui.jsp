<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/05/13
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/modules/laydate/default/laydate.css" media="all">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this" id="dj">排队列表</li>
        <li >信息添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">排队号码</label>
                        <div class="layui-input-inline">
                            <input type="text" name="number" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">桌台容量</label>
                        <div class="layui-input-inline">
                            <select name="capacity" lay-filter="aihao">
                                <option value="a">选择容量</option>
                                <option value="101">1-2人</option>
                                <option value="102">3-6人</option>
                                <option value="103">7-10人</option>
                                <option value="104">11人以上</option>
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
            <iframe src="/queuing_management/queuing-management/toadd.do" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script type="text/javascript">
    $(function () {

    })
</script>

<script>
    layui.use(['form','table','element'], function(){
        var form = layui.form
        , table = layui.table
            ,element = layui.element
        , layer = layui.layer

        $("#dj").click(function () {
            table.reload("test")
        });

        $('.site-demo-active').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        table.render({
            elem: '#test'
            ,url:'/queuing_management/queuing-management/queryAll.do'
            ,cols: [
                [
                    {field:'queue_type', width:'6.4%', title: '<font size="2px">队列类型<font>',templet: '<div>{{d.queue.type}}</div>'}
                    ,{field:'number', width:'6.4%', title: '<font size="2px">排队号码<font>'}
                    ,{field:'name', width:'8.4%', title: '<font size="2px">就餐人姓名<font>'}
                    ,{field:'people', width:'6%', title: '<font size="2px">人数'}
                    ,{field:'capacity', width:'8.4%', title: '<font size="2px">桌台容量<font>',templet: '<div>{{d.cap.cname}}</div>'}
                    ,{field:'Desk_type', width:'8.4%', title: '<font size="2px">桌台类型<font>',templet: '<div>{{d.zhuotaitype.zname}}</div>'}
                    ,{field:'data', width:'13.4%', title: '<font size="2px">取号时间<font>'}
                    ,{field:'await_number', width:'6.4%', title: '<font size="2px">等待桌数<font>'}
                    ,{field:'latency_time', width:'10.4%', title: '<font size="2px">预计等待时间<font>'}
                    ,{field:'qsid', width:'8.4%', title: '<font size="2px">状态<font>',templet: '<div>{{d.queue_state.name}}</div>'}
                    ,{field:'remark', width:'8.4%', title: '<font size="2px">备注<font>'}
                    ,{fixed: 'right', title:'<font size="2px">操作<font>', toolbar: '#barDemo', width:'9.8%'}
                ]
            ]
            ,page: true
            ,limit:9
        });

        //监听提交
        form.on('submit(formDemo)', function (data) {
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // })
            var list = data.field
            table.reload("test",{
                where:{
                    number:list.number,
                    capacity:list.capacity
                }
            })
            return false;
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.get({
                        url:"/queuing_management/queuing-management/delete/"+data.id+".do",
                        success:function (data) {
                            if (data) {
                                layer.msg("删除成功")
                                table.reload("test")
                            }
                        }
                    });
                    layer.close(index);
                });

            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    area:["600px","800px"],
                    offset:"100px",
                    fixed:true,
                    content: "/queuing_management/queuing-management/toupdate/"+data.id+".do",
                    cancel: function(index, layero){
                        if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                            table.reload("test")
                            layer.close(index)
                        }
                    },
                    end:function () {
                        location.reload();
                    }
                });
            }
        });
    });
</script>
</body>
</html>