

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li class="layui-this" id="i1">菜品列表</li>
        <li>菜品添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">

            <form class="layui-form" method="post">
                <div class="layui-form-item">

                    <div class="layui-inline">
                        <label class="layui-form-label">菜品名称</label>
                        <div class="layui-input-block">
                            <input type="tel" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">菜品类别</label>
                        <div class="layui-input-inline">
                            <select name="type">
                                <option value="-1">请选择</option>
                                <option value="1">热菜</option>
                                <option value="2">凉菜</option>
                                <option value="3">汤</option>
                            </select>
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
        </div>
        <div class="layui-tab-item">
            <iframe width="100%" height="80%" src="${pageContext.request.contextPath}/caiping/toadd.do"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="toolbarDemo">
    <%--<div class="layui-btn-container">--%>
    <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>--%>
    <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
    <%--<button class="layui-btn layui-btn-sm" lay-event="add">会员信息添加</button>--%>
    <%--</div>--%>
</script>
<script src="/layui/jquery-3.3.1.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <%--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>

<script type="text/html" id="titleTpl">
        {{# if(d.caidanid == '1'){}}
        咿呀菜单
        {{# } else {}}
        其他
        {{# } }}
</script>



<script src="/layui/lib/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['table','form','element','laydate'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form=layui.form;
        var $ = layui.jquery,
            laydate = layui.laydate
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        // laydate.render({
        //     elem: '#date1'
        //     ,type:'date'
        // });

        $("#i1").click(function () {
            table.reload("test");
        });

        //渲染表格

        form.on('submit(demo1)',function (data) {

            table.reload("test",{
                where:{
                    name : data.field.name,
                    type : data.field.type
                }
            })
            return false;
        });

        table.render({
            elem: '#test'
            , url: '/caiping/querycaiping.do'
            , toolbar: '#toolbarDemo'
            , title: '菜品表'
            // , totalRow: true
            , cols:
                [
                    [
                        // {type: 'checkbox', fixed: 'left'}
                        {field: 'img', title: '菜品图片', width: '7%',templet: '<div><img style="height:40px;width:40px;border-radius:50%;line-height:50px!important;" src="{{d.img}}"></div>'}
                        , {field: 'caidanid', title: '所属菜单', width: '7%',templet:'#titleTpl'}
                        , {field: 'name', title: '菜品名称', width: '7%'}
                        , {field: 'type', title: '菜品类别', width: '7%',templet: '<div>{{d.caipingtype.type}}</div>'}
                        , {field: 'cailiao', title: '原材料', width: '7%'}
                        , {field: 'number', title: '数量', width: '7%'}
                        , {field: 'danwei', title: '单位', width: '7%',templet: '<div>{{d.danwei1.name}}</div>'}
                        , {field: 'maker', title: '厨师', width: '7%'}
                        , {field: 'price', title: '价格', width: '7%'}
                        , {field: 'xiugai', title: '修改日期', width: '10%'}
                        , {field: 'tesecai', title: '特色菜', width: '7%'}
                        , {field: 'test', title: '备注', width: '10%'}
                        , {title: '操作', width: '10%', toolbar: '#barDemo'}
                    ]
                ]
            , page: true
            , limit:6
            , limits: [10, 20, 30]
        });

        // 监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var data = obj.data;
            // if (obj.event === 'add') {
            //     layer.open({
            //         type: 2,
            //         area: ['700px', '800px'],
            //         offset: ['0px', '350px'],
            //         content: "",
            //         cancel: function (index, layero) {
            //             if (confirm('确定要关闭么')) { //只有当点击confirm框的确定时，该层才会关闭
            //                 table.reload("test");
            //             }
            //         }
            //     })
            // }
            // if (obj.event === 'getCheckData') {
            //     var checkStatus = table.checkStatus(obj.config.id);
            //     var data = checkStatus.data;
            //     if (data.length == 0){
            //         layer.msg("请至少选中一行",{icon:2},{time:3000});
            //     }else{
            //         var arry=new Array();
            //         for (var i=0;i<data.length;i++){
            //             var id= data[i].id;
            //             arry[i] = id;
            //         }
            //         $.ajax({
            //             url: '/deleteByids.do',
            //             contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            //             type: 'POST',
            //             data: {ids:arry},
            //             traditional:true,
            //             dataType: 'json',
            //             success:function(data) {
            //                 if (data){
            //                     layer.msg("删除成功")
            //                     table.reload("test");
            //                 } else{
            //                     layer.msg("删除失败")
            //                 }
            //             }
            //         });
            //     }
            //
            // }
        });

        // 监听行工具栏事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    area: ['700px', '800px'],
                    offset: ['0px', '400px'],
                    content: "/caiping/toupdate.do?id=" + data.id,
                    cancel: function (index, layero) {
                        table.reload("test");
                    },
                    end: function () {
                        location.reload();
                    }
                })
            }
                // else if (obj.event === 'del') {
            //     layer.confirm('真的删除行么', function (index) {
            //         $.get("/caiping/del.do?id=" + data.id, function (data) {
            //             if (data) {
            //                 layer.msg("删除成功")
            //                 table.reload("test");
            //             }else{
            //                 layer.msg("删除失败")
            //             }
            //         });
            //     });
            // }
        });


    });
</script>

</body>
</html>

