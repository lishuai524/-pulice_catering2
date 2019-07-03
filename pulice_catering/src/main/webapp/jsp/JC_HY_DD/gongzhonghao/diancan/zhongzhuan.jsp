<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>易牙美食餐厅</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="/common/weui.min.css" />
    <link rel="stylesheet" href="/common/jquery-weui.min.css">
    <link rel="stylesheet" href="common/font-awesome.min.css" />
    <link rel="stylesheet" href="/common/style.css" />
</head>
<body>
<div class="page__bd">
    <div class="weui-panel">
        <div class="weui-panel__bd">


            <div class="weui-media-box__bd">
                <h4 class="weui-media-box__title">暂无空闲桌台</h4>
                <div style="height:50px;"></div>
                <div class="weui-tabbar" style="position:;">
                    <a href="#tab1" class="weui-tabbar__item weui-bar__item--on" onclick="toDingCan(0)">
                        <!--<div class="weui-tabbar__icon">

                            <i class="fa fa-home" aria-hidden="true"></i>
                        </div>-->
                        <p class="weui-tabbar__label" style="font-size:20px;">外卖</p>
                    </a>
                    <a href="#tab2" class="weui-tabbar__item" onclick="toPaiDui()">
                        <!--<div class="weui-tabbar__icon">

                            <i class="fa fa-user-o" aria-hidden="true"></i>
                        </div>-->
                        <p class="weui-tabbar__label" style="font-size:20px;">排队</p>
                    </a>
                </div>
            </div>

            <input type="hidden" id="hyOpenid" value="o3KmFt67QKcQSUYQcQ-MXul-cEDg">
            <input type="hidden" id="orderType" value="1">
            <input type="hidden" id="storeId" value="f594c109e55a48d4a78196b29f8f81df">
            <input type="hidden" id="zdStoreId" value="f4514239e8f446aeb0c24a3409e41b78">
        </div>

    </div>
    <div class="weui-tabbar"  style="position:fixed;">
        <a href="#tab1" class="weui-tabbar__item weui-bar__item--on" onclick="toMdIndex()">
            <div class="weui-tabbar__icon">
                <i class="fa fa-home" aria-hidden="true"></i>
            </div>
            <p class="weui-tabbar__label">首页</p>
        </a>
        <a href="#tab2" class="weui-tabbar__item" onclick="toDingDan()">
            <div class="weui-tabbar__icon">
                <i class="fa fa-file-text-o" aria-hidden="true"></i>
            </div>
            <p class="weui-tabbar__label">订单</p>
        </a>
        <a href="#tab4" class="weui-tabbar__item" onclick="toMyInfo()">
            <div class="weui-tabbar__icon">
                <i class="fa fa-user-o" aria-hidden="true"></i>
            </div>
            <p class="weui-tabbar__label">我的</p>
        </a>
    </div>
</div>
<script src="/common/jquery.js" type="text/javascript"></script>
<script src="/common/jquery-weui.js" type="text/javascript"></script>
<script src="/common/swiper.min.js" type="text/javascript"></script>
<script src="/common/main.js" type="text/javascript"></script>
<script>
    var hyOpenid =$("#hyOpenid").val();
    var storeId =$("#storeId").val();
    var orderType =$("#orderType").val();
    var zdStoreId =$("#zdStoreId").val();
    function toDianCan(tableId) {
        window.location.href="/yiya/wx/Common/toDianCan?hyOpenid="+hyOpenid+"&orderType="+orderType+"&storeId="+storeId+"&tableId="+tableId+"&zdStoreId="+zdStoreId;
    }

    function toMdIndex(){
        window.location.href="/yiya/wx/Common/mdIndex?hyOpenid="+hyOpenid+"&storeId="+storeId+"&zdStoreId="+zdStoreId+"&type=0";
        return false;
    }
    function toDingDan(){
        window.location.href="/yiya/wx/Common/mdIndex?hyOpenid="+hyOpenid+"&storeId="+storeId+"&zdStoreId="+zdStoreId+"&type=1";
        return false;
    }
    function toMyInfo(){
        window.location.href="/yiya/wx/Common/mdIndex?hyOpenid="+hyOpenid+"&storeId="+storeId+"&zdStoreId="+zdStoreId+"&type=4";
        return false;
    }
    function toDingCan(orderType){
        window.location.href="/yiya/wx/Common/toDianCan?hyOpenid="+hyOpenid+"&orderType="+orderType+"&zdStoreId="+zdStoreId+"&storeId="+storeId;
        return false;
    }

    function toPaiDui(){
        window.location.href="/yiya/wx/Common/toPaidui?hyOpenid="+hyOpenid+"&storeId="+storeId+"&zdStoreId="+zdStoreId+"&type=5";
        return false;
    }

</script>

</body>
</html>