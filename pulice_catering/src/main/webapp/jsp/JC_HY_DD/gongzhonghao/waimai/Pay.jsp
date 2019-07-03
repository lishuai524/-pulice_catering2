<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>${fns:getConfig('productName')} 易牙美食餐厅</title>
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
	<div class="weui-cells no_magrin_top">
		<div class="weui-cell">
			<div class="weui-cell__hd size_14">订单编号</div>
			<div class="weui-cell__bd size_14">
				<input class="weui-input input_border">
			</div>
		</div>
	</div>
	<div class="weui-panel">
		<div class="weui-panel__hd color_black title_noboder size_16">我的菜品</div>
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
			<p class="text_right padding_new size_14">实付：¥28</p>

			<div class="weui-cell border_all">
				<div class="weui-cell__hd size_12">备注：</div>
				<div class="weui-cell__bd size_12 color_gray">备注内容</div>
			</div>
		</div>
	</div>

</div>
<div class="page__bd">
	<a href="/jsp/JC_HY_DD/gongzhonghao/diancan/PaySelect.jsp" class="weui-btn weui-btn_primary btn_small btn_new">付款</a>
</div>















<script src="/common/jquery.js" type="text/javascript"></script>
	<script src="/common/jquery-weui.js" type="text/javascript"></script>
	<script src="/common/swiper.min.js" type="text/javascript"></script>
<script src="/common/main.js" type="text/javascript"></script>

</body>
</html>