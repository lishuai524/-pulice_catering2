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
        <li class="layui-this" id="yd">打印机列表</li>
        <li >信息添加</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">设备名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input">
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
            <iframe src="/jsp/JC_HY_DD/JC/addDayinji.jsp" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/jquery-3.3.1.min.js" charset="utf-8"></script>

<script>

    var dy = function(v){
        if(v == '101'){
            layui.layer.open({
                type:1,
                area:["500px","700px"],
                offset:"100px",
                content: $("#detailC"),
            });
        }
        if(v == '102'){
            layui.layer.open({
                area:["500px","700px"],
                offset:"100px",
                content: $("#detailB"),
            });
        }if(v == '103'){
            layui.layer.open({
                area:["500px","700px"],
                offset:"100px",
                content: $("#detailA"),
            });
        }
    }

    layui.use(['form', 'table','element', 'layedit', 'laydate'], function () {
        var form = layui.form;
        var table = layui.table
            ,element = layui.element //Tab的切换功能，切换事件监听等，需要依赖element模块
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        $("#yd").click(function () {
            table.reload("test")
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');


        $('.site-demo-active').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });


        //监听提交
        form.on('submit(formDemo)', function (data) {
            var list = data.field
            table.reload("test", {
                where: {
                    name:list.name,
                }
            })
            return false;
        });
        table.render({
            elem: '#test'
            , url: '/dayinji/dayinji/queryAll.do'
            , cols: [[
                 {field: 'name', width: '16.7%', title: '设备名称'}
                , {field: 'yontu', width: '16.7%', title: '用途'}
                , {field: 'ip', width: '16.7%', title: 'IP地址'}
                , {field: 'duanko', width: '16.7%', title: '端口号'}
                , {field: 'dayin', width: '16.7%', title: '打印模板',templet: '<div><button type="button" class="layui-btn layui-btn-primary layui-btn-sm" onclick="dy({{d.dayin}})" >选择模板</button></div>'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: '16.7%'}
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
                        url: "/dayinji/dayinji/delete/" + data.id + ".do",
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
                    content: "/dayinji/dayinji/toupdate/" + data.id + ".do",
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

    <div style="display: none;"id="detailA">
    <div style="overflow:hidden">
        <h2>易牙餐饮襄阳店</h2>
        <h3>欢迎光临！</h3>
        <p><strong>A0001</strong></p>
        <div>
            <p>就餐人数：6人</p>
            <p>桌台类型：6人桌</p>
            <p>
                <span>共有6人在等待,请耐心等候...</span><br>
                <span>2018年6月26日</span>
                <span>9时30分</span>
            </p>
            <p>友情提示：请保管好随身物品！</p>
        </div>
    </div>
</div>


    <div id="detailC" style="display: none;">
        <div>
            后厨菜单模板
        </div>
        <div>
            <h2>凉菜分单</h2>
        </div>
        <div >
            <h3>22号桌</h3>
            <p>账单号：123456789</p>
            <p>服务员：xxx</p>
            <p>下单时间：2018-06-25</p>
        </div>
        <br>
        <div>
            <table >
                <thead>
                <th>菜品名称</th>
                <th>数量</th>
                <th>金额</th>
                </thead>
                <tbody>
                <tr>
                    <td>凉拌黄瓜</td>
                    <td>1</td>
                    <td>12.00</td>
                </tr>
                <tr>
                    <td>备注：</td>
                    <td colspan="2">多放糖</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div id="detailB" style="display: none;">
        <div>
            对账单模板
        </div>
        <br>
        <div>
            <div >
                <h3>易牙餐饮襄阳店</h3>
                <h2>对账单</h2>
            </div>
            <br>
            <div>
                <p>桌台：Xxxx</p>
                <p>账单号：123456789</p>
                <p>服务员：xxx</p>
                <p>下单时间：2018-06-25</p>
            </div>
            <br>
            <div >
                <table>
                    <thead>
                    <th>菜品名称</th>
                    <th>数量</th>
                    <th>金额</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td>西红柿炒番茄</td>
                        <td>1</td>
                        <td>12.00</td>
                    </tr>
                    <tr>
                        <td>西红柿炒番茄</td>
                        <td>1</td>
                        <td>12.00</td>
                    </tr>
                    <tr>
                        <td>西红柿炒番茄</td>
                        <td>1</td>
                        <td>12.00</td>
                    </tr>
                    <tr>
                        <td>西红柿炒番茄</td>
                        <td>1</td>
                        <td>12.00</td>
                    </tr>
                    <tr>
                        <td>合计</td>
                        <td>4</td>
                        <td>48.00</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <br>
            <div>
                <p>折扣金额：0000</p>
                <p >已付金额：0000</p>
            </div>
            <br>
            <div >
                <p>门店地址：xxxxxxxxxxx</p>
                <p>联系电话：xxxxxxxxxxx</p>
                <p>出票时间：xxxxxxxxxxx</p>
                <p>友情提示：请携带好您的随身物品，请勿遗忘！</p>
            </div>
        </div>
    </div>
</body>
</html>