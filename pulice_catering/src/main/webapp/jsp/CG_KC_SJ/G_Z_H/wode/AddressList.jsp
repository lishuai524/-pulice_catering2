<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title> 易牙美食餐厅</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" href="${ctxStatic}/common/weui.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/common/jquery-weui.min.css">
	<link rel="stylesheet" href="${ctxStatic}/common/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/common/style.css" />
</head>
<body>
<div class="weui-cells no_magrin_top">
	<div class="weui-cell address_list">
		<div class="weui-cell__bd">张三</div>
		<div class="weui-cell__ft color_black">18895698745</div>
	</div>
	<div class="weui-cell address_list">
		<div class="weui-cell__bd">湖北省襄阳市樊城区追日路</div>
	</div>
	<div class="weui-media-box weui-media-box_text address_list">
		<ul class="weui-media-box__info">
			<li class="weui-media-box__info__meta color_black">
				<div class="weui-cells_checkbox">
					<label class="weui-cell weui-check__label input_radio" for="s11">
						<div class="weui-cell__hd">
							<input type="checkbox" class="weui-check" name="checkbox1" id="s11" checked="checked">
							<i class="weui-icon-checked"></i>
						</div>
						<div class="weui-cell__bd">
							<p>默认地址</p>
						</div>
					</label>
				</div>
			</li>
			<li class="color_black fl_right li_operat">
                    <span>
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        <span class="weui-comment-num">修改</span>
                    </span>
				<span class="margin_left_new">
                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                        <span class="weui-comment-num">删除</span>
                    </span>
			</li>
		</ul>
	</div>
</div>
<div class="weui-cells">
	<div class="weui-cell address_list">
		<div class="weui-cell__bd">张三</div>
		<div class="weui-cell__ft color_black">18895698745</div>
	</div>
	<div class="weui-cell address_list">
		<div class="weui-cell__bd">湖北省襄阳市樊城区追日路</div>
	</div>
	<div class="weui-media-box weui-media-box_text panel_box address_list">
		<ul class="weui-media-box__info">
			<li class="weui-media-box__info__meta color_black">
				<div class="weui-cells_checkbox">
					<label class="weui-cell weui-check__label input_radio" for="s12">
						<div class="weui-cell__hd">
							<input type="checkbox" class="weui-check" name="checkbox2" id="s12" checked="checked">
							<i class="weui-icon-checked"></i>
						</div>
						<div class="weui-cell__bd">
							<p>默认地址</p>
						</div>
					</label>
				</div>
			</li>
			<li class="color_black fl_right li_operat">
                    <span>
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        <span class="weui-comment-num">修改</span>
                    </span>
				<span class="margin_left_new">
                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                        <span class="weui-comment-num">删除</span>
                    </span>
			</li>
		</ul>
	</div>
</div>
<div class="page__bd weui-footer_fixed-bottom">
	<a href="AddAddress.jsp" class="weui-btn weui-btn_primary btn_bottom">新增收货地址</a>
</div>















<script src="${ctxStatic}/common/jquery.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/jquery-weui.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/swiper.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/common/main.js" type="text/javascript"></script>

</body>
</html>