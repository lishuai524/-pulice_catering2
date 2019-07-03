<%--
  Created by IntelliJ IDEA.
  User: 辛辣天森
  Date: 2019/6/22 0022
  Time: 上午 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--      模板A  -->
<div class="row">
    <div class="col-md-6">
        <div class="modelL pull-left">
            排队叫号模板
        </div>
        <div class="line-head" style="overflow:hidden">
            <h2>易牙餐饮襄阳店</h2>
            <h3>欢迎光临！</h3>
            <p><strong>A0001</strong></p>
            <div class="line-txt">
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

        <!--模板C-->
        <div id="detailC">
            <div class="modelL pull-left">
                后厨菜单模板
            </div>
            <div class=" check-head">
                <h2>凉菜分单</h2>
            </div>
            <div class="check-bodyA">
                <h3>22号桌</h3>
                <p>账单号：123456789</p>
                <p>服务员：xxx</p>
                <p>下单时间：2018-06-25</p>
            </div>
            <div class="check-bodyB food">
                <table class="check-table ">
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
    </div>
    <div class="col-md-6">
        <!--模板B-->
        <div id="detailB">
            <div class="modelL pull-left" >
                对账单模板
            </div>
            <div>
                <div class=" check-head">
                    <h3>易牙餐饮襄阳店</h3>
                    <h2>对账单</h2>
                </div>
                <div class="check-bodyA">
                    <p>桌台：Xxxx</p>
                    <p>账单号：123456789</p>
                    <p>服务员：xxx</p>
                    <p>下单时间：2018-06-25</p>
                </div>
                <div class="check-bodyB">
                    <table class="check-table">
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
                <div class="check-bodyC">
                    <p class="pull-left">折扣金额：0000</p>
                    <p class="pull-right">已付金额：0000</p>
                </div>
                <div class="check-bodyD">
                    <p>门店地址：xxxxxxxxxxx</p>
                    <p>联系电话：xxxxxxxxxxx</p>
                    <p>出票时间：xxxxxxxxxxx</p>
                    <p>友情提示：请携带好您的随身物品，请勿遗忘！</p>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>
</body>
</html>
