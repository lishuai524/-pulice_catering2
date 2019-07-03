<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>易牙美食餐厅</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" href=/common/weui.min.css" />
	<link rel="stylesheet" href="/common/jquery-weui.min.css">
	<link rel="stylesheet" href="/common/font-awesome.min.css" />
	<link rel="stylesheet" href="/common/style.css" />
</head>
<body class="bgcolor_f">
<div class="weui-tab">
	<div class="weui-navbar tab_top">
		<a class="second_tab_item item_active" href="#order_tab1">
			微信支付
		</a>
		<a class="second_tab_item" href="#order_tab2">
			支付宝支付
		</a>
	</div>
	<div class="weui-tab__bd second_tab_bd">
		<div id="order_tab1" class="second_tab_bd_item tab_bd_active">
			<div class="pay_box">
				<p class="text_center">请输入金额</p>
				<div class="pay_input">
					<div class="pay_input_ico">￥</div>
					<input class="weui-input">
				</div>
			</div>
			<div class="page__bd">
				<a href="javascript:;" class="weui-btn weui-btn_primary btn_small btn_new size_16">微信支付</a>
			</div>
		</div>
		<div id="order_tab2" class="second_tab_bd_item">
			<div class="pay_box">
				<p class="text_center">请输入金额</p>
				<div class="pay_input">
					<div class="pay_input_ico">￥</div>
					<input class="weui-input">
				</div>
			</div>
			<div class="page__bd">
				<a href="javascript:;" class="weui-btn weui-btn_primary btn_small btn_new size_16">支付宝支付</a>
			</div>
		</div>

	</div>
</div>


<script src="/common/jquery.js" type="text/javascript"></script>
	<script src="/common/jquery-weui.js" type="text/javascript"></script>
	<script src="/common/swiper.min.js" type="text/javascript"></script>
<script src="/common/main.js" type="text/javascript"></script>

</body>
</html>