<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title> 易牙美食餐厅</title>
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
<div class="weui-cells">
	<div class="weui-cell">
		<div class="weui-flex we-f">
			<div class="weui-flex__item"><div class="placeholder">小桌（1-2）</div></div>
			<div class="weui-flex__item"><div class="placeholder">等待桌数:0</div></div>
			<div class="weui-flex__item"><div class="placeholder">a1</div></div>
		</div>
	</div>
</div>
<div class="weui-cells">
	<div class="weui-cell">
		<div class="weui-flex we-f">
			<div class="weui-flex__item"><div class="placeholder wb">我的排号</div></div>
			<div class="weui-flex__item"><div class="placeholder wb"></div></div>
			<div class="weui-flex__item"><div class="placeholder wb">a1(1桌)</div></div>
		</div>

	</div>
</div>
<div class="weui-cells">

	<a href="javascript:;" class="weui-btn weui-btn_default">预点餐</a>

	<a href="javascript:;" class="weui-btn weui-btn_default" id="sd2">取消排队</a>
	<a href="javascript:;" class="weui-btn weui-btn_default" id="show-notification">刷新排队</a>
</div>















<script src="/common/jquery.js" type="text/javascript"></script>
	<script src="/common/jquery-weui.js" type="text/javascript"></script>
	<script src="/common/swiper.min.js" type="text/javascript"></script>
<script src="/common/main.js" type="text/javascript"></script>
<script>
	$(document).on("click", "#sd2", function() {
		$.confirm("您确定要取消排队吗?", "确认取消?", function() {
			$.toast("已取消!");
		}, function() {
			//取消操作
		});
	});
	$(document).on("click", "#show-notification", function() {
		$.noti({
			title: "已刷新！",
			time: 2000,
			onClick: function(data) {
				$.alert(data.message);
			}
		});
	});
</script>
</body>
</html>