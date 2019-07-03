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
<body ontouchstart>
<div class="weui-panel weui-panel_access">
	<div class="weui-panel__bd">
		<div  class="weui-media-box weui-media-box_appmsg">
			<div class="weui-media-box__hd wh">
				<img class="weui-media-box__thumb" src="${ctxStatic}/images/suicai1.png">
			</div>
			<div class="weui-media-box__bd">
				<h4 class="weui-media-box__title wt">易牙美食餐厅</h4>
				<p class="weui-media-box__desc"><a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary">营业中</a></p>
			</div>
		</div>

	</div>
</div>
<div class="weui-cells">
	<div class="weui-cell">
		<ul>
			<li class="weui-flex">
				<div class="weui-flex__item"><div class="placeholder">桌台类型</div></div>
				<div class="weui-flex__item"><div class="placeholder">等待桌数</div></div>
				<div class="weui-flex__item"><div class="placeholder">预估等待</div></div>
			</li>
			<li class="weui-flex">
				<div class="weui-flex__item"><div class="placeholder">大桌1-10</div></div>
				<div class="weui-flex__item"><div class="placeholder"><span>0</span>桌</div></div>
				<div class="weui-flex__item"><div class="placeholder">0分钟</div></div>
			</li>
			<li class="weui-flex">
				<div class="weui-flex__item"><div class="placeholder">中桌2-4</div></div>
				<div class="weui-flex__item"><div class="placeholder"><span>0</span>桌</div></div>
				<div class="weui-flex__item"><div class="placeholder">0分钟</div></div>
			</li>
			<li class="weui-flex">
				<div class="weui-flex__item"><div class="placeholder">小桌1-2</div></div>
				<div class="weui-flex__item"><div class="placeholder"><span>0</span>桌</div></div>
				<div class="weui-flex__item"><div class="placeholder">0分钟</div></div>
			</li>
		</ul>
	</div>
</div>
<div class="weui-cells">
	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">预留手机</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" type="number" pattern="[0-11]*" placeholder="请输入手机号">
		</div>
	</div>

	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">预定桌数</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" type="number" pattern="[0-11]*" placeholder="非必填">
		</div>
	</div>

	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">就餐人数</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" type="number" pattern="[0-11]*" placeholder="请输入就餐人数">
		</div>
	</div>

</div>

<div class="weui-cells wc">
	<div class="weui-cell">
		<a href="tjdd.html" class="weui-btn weui-btn_primary">排队取号</a>
	</div>
</div>















<script src="${ctxStatic}/common/jquery.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/jquery-weui.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/swiper.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/common/main.js" type="text/javascript"></script>

</body>
</html>