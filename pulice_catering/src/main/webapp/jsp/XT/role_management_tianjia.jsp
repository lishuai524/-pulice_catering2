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
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<script src="/la/js/jquery.min.js"></script>

<div class="layui-form-item"></div>
<span class="layui-breadcrumb" lay-separator="|">
        <a href="/jsp/XT/role_management.jsp">角色列表</a>
        <a href="/WEB-INF/jsp/XT/role_management_tianjia.jsp">角色添加</a>
    </span>
<div class="layui-form-item"></div>

<form class="layui-form" onsubmit="return false">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">英文名称</label>
        <div class="layui-input-inline">
            <input type="text" name="english" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">归属机构</label>
        <div class="layui-input-inline">
            <select name="department">
                <option value="平台管理员" selected="">平台管理员</option>
                <option value="总店人员">总店人员</option>
                <option value="门店人员">门店人员</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色类型</label>
        <div class="layui-input-inline">
            <select name="role">
                <option value="管理角色" selected="">管理角色</option>
                <option value="普通角色">普通角色</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否系统</label>
        <div class="layui-input-block">
            <input type="radio" name="system" value="是" title="是" checked="">
            <input type="radio" name="system" value="否" title="否">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否可用</label>
        <div class="layui-input-block">
            <input type="radio" name="usable" value="是" title="是" checked="">
            <input type="radio" name="usable" value="否" title="否">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数据范围</label>
        <div class="layui-input-inline">
            <select name="scope">
                <option value="所有数据">所有数据</option>
                <option value="所在公司及以下数据">所在公司及以下数据</option>
                <option value="所在公司数据">所在公司数据</option>
                <option value="所在部门及以下数据">所在部门及以下数据</option>
                <option value="所在部门数据">所在部门数据</option>
                <option value="仅本人数据" selected="">仅本人数据</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">角色授权:</label>
        <div class="layui-input-inline">
            <div id="test12" class="demo-tree-more"></div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>

<script src="/la/lib/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form','tree', 'util','element'], function(){
        var form = layui.form
            ,tree = layui.tree
            ,layer = layui.layer
            ,util = layui.util
            ,element = layui.element

            //模拟数据
            ,data = [{
                title: '功能菜单'
                , id: 1
                , children: [{
                    title: '基础信息'
                    ,id: 101
                    ,children: [{
                        title: '门店信息'
                        ,id: 10101
                    },{
                        title: '个人信息'
                        ,id: 10102
                    },{
                        title: '个人密码修改'
                        ,id: 10103
                    },{
                        title: '文件管理'
                        ,id: 10104
                    },{
                        title: '文件上传,修改'
                        ,id: 10105
                    },{
                        title: '资产管理'
                        ,id: 10106
                    },{
                        title: '桌台管理'
                        ,id: 10107
                    },{
                        title: '队列设置'
                        ,id: 10108
                    },{
                        title: '排队管理'
                        ,id: 10109
                    },{
                        title: '堂口管理'
                        ,id: 10110
                    },{
                        title: '打印机管理'
                        ,id: 10111
                    },{
                        title: '模板管理'
                        ,id: 10112
                    }]
                },{
                    title: '会员管理'
                    ,id: 102
                    ,children: [{
                        title: '会员信息列表'
                        ,id: 10201
                    },{
                        title: '会员信息添加'
                        ,id: 10202
                    }]
                },{
                    title: '订单管理'
                    ,id: 103
                    ,children: [{
                        title: '预定管理'
                        ,id: 10301
                    },{
                        title: '预订单管理'
                        ,id: 10302
                    },{
                        title: '外卖管理'
                        ,id: 10303
                    }]
                },{
                    title: '菜品管理'
                    ,id: 104
                    ,children: [{
                        title: '菜单管理'
                        ,id: 10401
                    },{
                        title: '菜单修改'
                        ,id: 10402
                    },{
                        title: '菜品类别'
                        ,id: 10403
                    },{
                        title: '菜品类别修改'
                        ,id: 10404
                    }, {
                        title: '全部菜品'
                        ,id: 10405
                    },{
                        title: '菜品编辑'
                        ,id: 10406
                    },{
                        title: '特色菜'
                        ,id: 10407
                    },{
                        title: '特色菜编辑'
                        ,id: 10408
                    }]
                },{
                    title: '财务管理'
                    ,id: 105
                    ,children: [{
                        title: '单据管理'
                        ,id: 10501
                    },{
                        title: '交接管理'
                        ,id: 10502
                    },{
                        title: '关账管理'
                        ,id: 10503
                    },{
                        title: '优惠券列表'
                        ,id: 10504
                    },{
                        title: '优惠券发放记录'
                        ,id: 10505
                    },{
                        title: '促销方案'
                        ,id: 10506
                    },{
                        title: '营业额外收入'
                        ,id: 10507
                    },{
                        title: '营业额外支出'
                        ,id: 10508
                    },{
                        title: '充值管理-充值'
                        ,id: 10509
                    },{
                        title: '充值管理-修改,提醒,删除'
                        ,id: 10510
                    }]
                },{
                    title: '采购管理'
                    ,id: 106
                    ,children: [{
                        title: '原材料管理'
                        ,id: 10601
                    },{
                        title: '采购方式管理'
                        ,id: 10602
                    },{
                        title: '销售计划'
                        ,id: 10603
                    },{
                        title: '采购计划'
                        ,id: 10604
                    },{
                        title: '采购审核管理'
                        ,id: 10605
                    },{
                        title: '采购单管理'
                        ,id: 10606
                    }]
                },{
                    title: '库存管理'
                    ,id: 107
                    ,children: [{
                        title: '入库管理'
                        ,id: 10701
                    },{
                        title: '实时库存'
                        ,id: 10702
                    },{
                        title: '盘库管理'
                        ,id: 10703
                    },{
                        title: '盘库单管理'
                        ,id: 10704
                    }]
                },{
                    title: '数据管理'
                    ,id: 108
                    ,children: [{
                        title: '菜品统计'
                        ,id: 10801
                    },{
                        title: '总营业额统计'
                        ,id: 10802
                    },{
                        title: '食材费用统计'
                        ,id: 10803
                    },{
                        title: '其他费用统计'
                        ,id: 10804
                    }]
                },{
                    title: '系统管理'
                    ,id: 109
                    ,children: [{
                        title: '系统设置'
                        ,id: 10901
                    },{
                        title: '总店设置向导'
                        ,id: 10902
                    },{
                        title: '门店初始化'
                        ,id: 10903
                    },{
                        title: '总店管理'
                        ,id: 10904
                    },{
                        title: '门店管理'
                        ,id: 10905
                    },{
                        title: '员工管理'
                        ,id: 10906
                    },{
                        title: '权限管理'
                        ,id: 10907
                    },{
                        title: '权限编辑'
                        ,id: 10908
                    }]
                }

                ]
            }]

        //基本演示
        tree.render({
            elem: '#test12'
            ,data: data
            ,showCheckbox: true  //是否显示复选框
            ,id: 'demoId1'
            ,isJump: true //是否允许点击节点时弹出新窗口跳转
/*            ,click: function(obj){
                var data = obj.data;  //获取当前点击的节点数据
                alert(data);
                layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
            }*/
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            var dataForm=JSON.stringify(data.field);
            var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
            var dataForm1=JSON.stringify(checkedData);
            dataForm1 = dataForm1.substring(1,dataForm1.lastIndexOf("]"));
            alert(dataForm1);
            $.ajax({
                url: '/role/role/insert_role.do',
                type: 'post',
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                data:dataForm,
                success: function(ret){
                    if(ret){
                        if(checkedData.length > 0){
                            $.ajax({
                                url: '/role/role/insert_jurisdiction.do',
                                type: 'post',
                                dataType: 'json',
                                contentType:'application/json;charset=UTF-8',
                                data:dataForm1,
                                success: function(ret1){
                                    if(ret1){
                                        layer.msg("添加成功");
                                    }else {
                                        layer.msg("添加失败");
                                    }
                                },
                            });
                        }
                    }
                },
            });
        });
    });

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $.get("<%=request.getServletContext().getContextPath()%>/student/todelete.do?id="+id,function(data){
                if(data=="yes"){
                    $(obj).parents("tr").remove();//删除TR
                    layer.msg('已删除!',{icon:1,time:1000});
                }else {
                    layer.msg('数据异常请联系管理员');
                }
            });
        });
    }
</script>

</body>
</html>