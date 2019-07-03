<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改交接</title>
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
<form class="layui-form" method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">会员名称</label>
            <div class="layui-input-inline">
                <input type="tel" name="name"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-block">
                <input type="tel" name="phone"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="demo1">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>


<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>




<script>
    layui.use(['table','form'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form=layui.form;
        //渲染表格

        form.on('submit(demo1)',function (data) {

            table.reload("test",{
                where:{
                    name : data.field.name,
                    phone : data.field.phone
                }
            })
            return false;
        });

        table.render({
            elem: '#test'
            , url: '/huiyuanWWC/queryAll.do'
            , toolbar: '#toolbarDemo'
            , title: '会员信息表'
            , cols:
                [
                    [
                        {field: 'name', title: '会员名称', width: '8%'}
                        , {field: 'sex', title: '会员性别', width: '8%', edit: 'text', sort: true}
                        , {field: 'birthday', title: '会员生日', width: '10%', sort: true}
                        , {field: 'phone', title: '电话', width: '10%'}
                        , {field: 'address', title: '地址', width: '15%'}
                        , {field: 'money', title: '余额', width: '8%' ,sort: true}
                        , {field: 'test', title: '备注', width: '15%'}
                        , {title: '操作', width: '20%', toolbar: '#barDemo'}
                    ]
                ]
            , page: true
            , limit:9
            , limits: [10,20,30]
        });

        // 监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'add') {
                layer.open({
                    type: 2,
                    area: ['700px', '800px'],
                    offset: ['0px', '350px'],
                    content: "/jsp/huiyuanMG/addhuiyuan.jsp",
                    cancel: function (index, layero) {
                        if (confirm('确定要关闭么')) { //只有当点击confirm框的确定时，该层才会关闭
                            table.reload("test");
                        }
                    }
                })
            }
            if (obj.event === 'getCheckData') {
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                if (data.length == 0){
                    layer.msg("请至少选中一行",{icon:2},{time:3000});
                }else{
                    var arry=new Array();
                    for (var i=0;i<data.length;i++){
                        var id= data[i].id;
                        arry[i] = id;
                    }
                    $.ajax({
                        url: '/huiyuan/deleteByids.do',
                        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
                        type: 'POST',
                        data: {ids:arry},
                        traditional:true,
                        dataType: 'json',
                        success:function(data) {
                            if (data){
                                layer.msg("删除成功")
                                table.reload("test");
                            } else{
                                layer.msg("删除失败")
                            }
                        }
                    });
                }

            }
        });

        // 监听行工具栏事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    area: ['700px', '800px'],
                    offset: ['0px', '350px'],
                    content: "/huiyuan/toupdate.do?id=" + data.id,
                    cancel: function (index, layero) {
                        table.reload("test");
                    },
                    end: function () {
                        location.reload();
                    }
                })
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    $.get("/huiyuan/del.do?id=" + data.id, function (data) {
                        if (data) {
                            layer.msg("删除成功")
                            table.reload("test");
                        }else{
                            layer.msg("删除失败")
                        }
                    });
                });
            }
        });


    });
</script>

</body>
</html>
