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
<div class="weui-tab">
	<div class="weui-navbar tab_top">
		<a class="second_tab_item item_active" href="#order_tab1">
			可用的
		</a>
		<a class="second_tab_item" href="#order_tab2">
			失效的
		</a>
	</div>
	<div class="weui-tab__bd second_tab_bd">
		<div id="order_tab1" class="second_tab_bd_item tab_bd_active">
			<div class="weui-cells no_magrin_top">
				<div class="weui-cell">
					<div class="weui-cell__hd coupon_money">¥5</div>
					<div class="weui-cell__bd">
						<p>外卖通用红包</p>
						<p class="color_red size_14">有效期至：2019-05-01</p>
					</div>
					<div class="weui-cell__ft">
						<a href="javascript:;" class="weui-btn weui-btn_mini btn_SY">使用</a>
					</div>
				</div>
				<div class="coupon_des">满35可用，不可与满减，折扣商品共用</div>
			</div>
			<div class="weui-cells">
				<div class="weui-cell">
					<div class="weui-cell__hd coupon_money">¥5</div>
					<div class="weui-cell__bd">
						<p>外卖通用红包</p>
						<p class="color_red size_14">有效期至：2019-05-01</p>
					</div>
					<div class="weui-cell__ft">
						<a href="javascript:;" class="weui-btn weui-btn_mini btn_SY">使用</a>
					</div>
				</div>
				<div class="coupon_des">满35可用，不可与满减，折扣商品共用</div>
			</div>
		</div>
		<div id="order_tab2" class="second_tab_bd_item">
			<div class="weui-cells">
				<div class="weui-cell">
					<div class="weui-cell__hd coupon_money_sx">¥5</div>
					<div class="weui-cell__bd">
						<p class="color_gray2">外卖通用红包</p>
						<p class="color_gray2 size_14">有效期至：2019-05-01</p>
					</div>
					<div class="weui-cell__ft">
						<img src="${ctxStatic}/images/ico1.png" />
					</div>
				</div>
				<div class="coupon_des">满35可用，不可与满减，折扣商品共用</div>
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