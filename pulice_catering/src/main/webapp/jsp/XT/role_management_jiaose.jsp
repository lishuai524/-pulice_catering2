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
<hr>
<h1 style="font-weight: bold;color: #1a1a1a;">分配角色</h1>
<hr class="layui-bg-black">

<div class="layui-col-md4" style="border-right: 1px solid #0000FF;">
    <div class="grid-demo" style="font-weight:900"><i class="layui-icon">&#xe62b;</i>所在部门：</div>
    <div id="test5" class="demo-tree"></div>
</div>

<div class="layui-col-md4" style="padding-left:16px">
    <div class="grid-demo"style="font-weight:900"><i class="layui-icon">&#xe612;</i>待选人员：</div>
    <div id="dyry" class="demo-tree"></div>
</div>

    <div class="layui-col-md4" style="padding-left:16px;border-left: 1px solid #0000FF;">
        <div class="grid-demo" style="font-weight:900"><i class="layui-icon">&#xe613;</i>已选人员(<font color="#dc143c">红色代表待添加</font>,<font color="blue">蓝色代表已存在</font>)</div>
        <table style="color: #ff0000" id="yyrytable">
            <c:forEach items="${roleList}" var="role">
                <tr><td><a class="layui-icon" href="#"><font color="blue">${role.name}</font></a></td></tr>
            </c:forEach>
            <div id="yyry" class="demo-tree"></div>
        </table>
        <div class="layui-form-item" style="position: fixed;right: 40px;bottom: 0;">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-xs layui-btn-normal" onclick="onupd()">立即添加</button>
            </div>
        </div>
    </div>


<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<script src="/la/js/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['tree', 'util'], function () {
        var tree = layui.tree
            , layer = layui.layer
            , util = layui.util

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

        //点击节点新窗口跳转
        tree.render({
            elem: '#test5'
            , data: data
            , showLine: false  //是否开启连接线
            , onlyIconControl: true  //是否仅允许节点左侧图标控制展开收缩
            , click: function (obj) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/staffs/staffs/queryByDepartment.do?department='+obj.data.title,
                    type: 'post',
                    success: function(ret){
                        var ret2 = "<table>";
                        for(var i in ret){
                            ret2 += "<tr><td id=\""+i+"\"><a class='layui-icon' href='#' ondblclick=\"onadd('"+ret[i].name+"','"+i+"','"+ret[i].id+"')\">"+ret[i].name+"</a></td></tr>";
                        }
                        ret2 += "</table>";
                        $("#dyry").html(ret2);
                    },
                });
            }
            , isJump: true  //跳转
        });
    });
    //删除数组中某个元素
    //首先可以给JS的数组对象定义一个函数，用于查找指定的元素在数组中的位置，即索引
    Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    //然后使用通过得到这个元素的索引，使用js数组自己固有的函数去删除这个元素：
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };
    //数组去重复
    function unique(arr){
        // 遍历arr，把元素分别放入tmp数组(不存在才放)
        var tmp = new Array();
        for(var i in arr){
            //该元素在tmp内部不存在才允许追加
            if(tmp.indexOf(arr[i])==-1){
                tmp.push(arr[i]);
            }
        }
        return tmp;
    }

    //a标签添加双击事件
    var i = 0;
    var staffsId = new Array();
    var yy = "";
    var dy = "";
    var onadd = function (staffsName,id,staid,dytr) {
        dy -= dytr;
        var yytr = "";
        yytr = "<tr><td id=\"i"+i+"\"><a class='layui-icon' href='#' ondblclick=\"ondle('"+staffsName+"','i"+i+"','"+staid+"','"+yytr+"')\"><font color='#dc143c'>"+staffsName+"</font></a></td></tr>";
        yy += yytr;
        $("#yyry").html(yy);
        $("#"+id+"").html("");
        staffsId[i] = staid;
        i++;
    };
    //a标签移除双击事件
    var j = 0;
    var ondle = function (staffsName,id,staid,yytr) {
        yy -= yytr;
        var dytr = "";
        dytr = "<tr><td id=\"j"+j+"\"><a class='layui-icon' href='#' ondblclick=\"onadd('"+staffsName+"','j"+j+"','"+staid+"','"+dytr+"')\">"+staffsName+"</a></td></tr>";
        dy += dytr;
        $("#dyry").html(dy);
        $("#"+id+"").html("");
        staffsId.remove(staid);
        j++;
    };

    var onupd = function () {
        var arr = unique(staffsId);
        arr.pop();
        $.ajax({
            url: '/staffs/staffs/updateByRole.do',
            type: 'post',
            dataType: 'json',
            traditional: true,
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            data:{arr:arr},
            success: function(ret1){
                if(ret1){
                    layer.msg("添加成功");
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                }
            },
        });
    };
</script>
</body>
</html>