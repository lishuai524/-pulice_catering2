<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="gb">关闭</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">提交</button>
    </div>
</script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,toolbar: '#toolbarDemo'
            ,defaultToolbar:['','']
            ,url:'/tangkou_information/tangkou-information/queryfood.do'
            ,cols: [[
                {type:'radio',}
                ,{field:'name', title: '类别名称'}
            ]]
            ,page: false
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    // layer.alert(JSON.stringify(data));
                    if(data.length == 0){
                        layer.msg("请至少选中一行",{icon:5});
                    }else {
                        $.ajax({
                            type:"post",
                            url:"/tangkou_information/tangkou-information/jieShou.do",
                            data:{"json":JSON.stringify(data)},
                            dataType:"json",
                            success:function (result) {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);//关闭当前页
                            }

                        });
                    }
                    break;
                case 'gb':
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);//关闭当前页
                    break;
            };
        });

    });
</script>

</body>
</html>