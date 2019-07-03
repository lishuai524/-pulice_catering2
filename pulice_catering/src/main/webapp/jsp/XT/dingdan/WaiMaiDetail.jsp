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
	<link rel="stylesheet" href="/common/font-awesome.min.css" />
	<link rel="stylesheet" href="/common/style.css" />
</head>
<body>
<div class="page__bd">
	<div class="weui-cell bgcolor_f">
		<div class="weui-cell__bd">
			<p class="text_center">订单详情</p>
		</div>
	</div>
	<div class="weui-panel">
		<div class="weui-panel__bd">
			<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg pay_item">
				<div class="weui-media-box__hd order_img">
					<img class="weui-media-box__thumb" src="${ctxStatic}/images/suicai1.png" alt="">
				</div>
				<div class="weui-media-box__bd">
					<h4 class="weui-media-box__title">麻婆豆腐</h4>
					<div class="weui-media-box__desc">
						<div class="sub_order_num">¥18</div>
						<div class="sub_order_num block_right_margin">×1</div>
					</div>
				</div>
			</a>
			<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg pay_item">
				<div class="weui-media-box__hd order_img">
					<img class="weui-media-box__thumb" src="${ctxStatic}/images/suicai1.png" alt="">
				</div>
				<div class="weui-media-box__bd">
					<h4 class="weui-media-box__title">麻婆豆腐</h4>
					<div class="weui-media-box__desc">
						<div class="sub_order_num">¥18</div>
						<div class="sub_order_num block_right_margin">×1</div>
					</div>
				</div>
			</a>
			<p class="text_right padding_new size_14">待支付：¥36</p>
			<div class="weui-cells">
				<div class="weui-cell">
					<div class="weui-cell__hd size_14">配送地址：</div>
					<div class="weui-cell__bd size_14">
						<div class="weui-media-box__desc color_black">
							<span>张三</span>
							<span style="margin-left:20px;">18865984587</span>
						</div>
						<div class="weui-media-box__desc color_black">软件园</div>
					</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__hd size_14">订单时间：</div>
					<div class="weui-cell__bd size_14">2018-12-20 12：30</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__hd size_14">订单号码：</div>
					<div class="weui-cell__bd size_14">002365485698755</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__hd size_12">个人备注：</div>
					<div class="weui-cell__bd size_12 color_gray">备注内容</div>
				</div>
			</div>
		</div>
	</div>
	<div class="page__bd">
		<a href="javascript:;" class="weui-btn weui-btn_primary btn_small btn_new size_16">付款</a>
	</div>
</div>















<script src="${ctxStatic}/common/jquery.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/jquery-weui.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/swiper.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/common/main.js" type="text/javascript"></script>

</body>
</html>