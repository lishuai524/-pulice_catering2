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
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form class="layui-form"  method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">订单编号</label>
            <div class="layui-input-inline">
                <input type="text" name="order_reference"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">预留手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="cell_phone_number"  autocomplete="off" class="layui-input">
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

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script type="text/html" id="titleTpl">
    {{#  if(d.sex == '1'){ }}
    男
    {{#  } else { }}
    女
    {{#  } }}
</script>

<script>

    layui.use(['form','table'], function(){
        var form = layui.form;
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/take_out/take-out/queryAll.do'
            ,cols: [
                [
                    {field:'order_reference', width:'7%', title: '订单编号', sort: true}
                    ,{field:'name', width:'7%', title: '姓名'}
                    ,{field:'cell_phone_number', width:'7%', title: '手机号'}
                    ,{field:'greens_name', width:'7%', title: '菜品名称'}
                    ,{field:'unit_price', width:'7%', title: '单价'}
                    ,{field:'unit', width:'7%', title: '计量单位'}
                    ,{field:'quantity', width:'7%', title: '数量'}
                    ,{field:'prices', width:'7%', title: '总价'}
                    ,{field:'discount_coupon', width:'7%', title: '优惠卷金额'}
                    ,{field:'time', width:'7%', title: '下单时间'}
                    ,{field:'osid', width:'7%', title: '订单状态'}
                    ,{field:'site', width:'7%', title: '送餐地址'}
                    ,{field:'remark', width:'8%', title: '备注'}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'9%'}
                ]
            ]
            ,page: true
            ,limit:9
        });

        //监听提交
        form.on('submit(formDemo)', function (data) {
            var list = data.field
            table.reload("test",{
                where:{
                    order_reference:list.order_reference,
                    cell_phone_number:list.cell_phone_number
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
                        url:"/take_out/take-out/delete/"+data.id+".do",
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
                    content: "/take_out/take-out/toupdate/"+data.id+".do",
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