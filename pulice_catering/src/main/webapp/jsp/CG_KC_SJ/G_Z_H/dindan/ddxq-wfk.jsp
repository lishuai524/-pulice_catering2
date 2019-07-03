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
<body ontouchstart>
<div class="kong">
	<p>您还没有订单</p>
</div>
<div class="weui-form-preview ws">
	<div class="weui-form-preview__bd">
		<div class="weui-form-preview__item">
			<label class="weui-form-preview__label">下单时间：</label>
			<span class="weui-form-preview__value">2018-03-01&nbsp;&nbsp;&nbsp;13:06:30</span>
		</div>
		<div class="weui-form-preview__item">
			<label class="weui-form-preview__label">订单状态：</label>
			<span class="weui-form-preview__value">未付款</span>
		</div>


	</div>
</div>
<div class="weui-cells ws">
	<div class="weui-panel weui-panel_access">
		<div class="weui-panel__bd">
			<div  class="weui-media-box weui-media-box_appmsg">
				<div class="weui-media-box__hd wh">
					<img class="weui-media-box__thumb" src="${ctxStatic}/images/suicai1.png">
				</div>
				<div class="weui-media-box__bd">
					<h4 class="weui-media-box__title">煲仔豆豉娃娃菜
						<div style="font-size: 0;float:right;" class="weui_cell_ft">
							<a class="weui-number weui-number-sub needsclick">-</a>
							<input pattern="[0-9]*" class="weui-number-input" style="width: 50px;" value='0'  data-min="0" data-max="100" data-step="1">
							<a class="weui-number weui-number-plus needsclick">+</a>
						</div>
						<div class="weui_cell_ft" style="display: none;"> 0 </div>
					</h4>
					<p class="weui-media-box__desc wd"><span class="money">￥18.00</span><i class="nub">×1</i></p>
				</div>
			</div>
		</div>
	</div>

	<a class="weui-cell weui-cell_access" href="../diancan/DianCan.jsp">
		<div class="weui-cell__bd">
			<p><img src="${ctxStatic}/images/jia.png" alt=""><span>加菜</span></p>
		</div>
	</a>
</div>

<div class="weui-form-preview ws">

	<div class="weui-form-preview__hd">
		<label class="weui-form-preview__label">共计：</label>
		<em class="weui-form-preview__value">¥18.00</em>
	</div>
	<div class="weui-form-preview__item">
		<label class="weui-form-preview__label">个人备注</label>
		<span class="weui-form-preview__value"></span>
	</div>
</div>
</div>
<div class="weui-cells wc">
	<div class="weui-cell">
		<a id="sd2" class="weui-btn weui-btn_plain-primary wp">取消订单</a>
		<a href="#" class="weui-btn weui-btn_primary wp">付款</a>
	</div>
</div>















<script src="${ctxStatic}/common/jquery.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/jquery-weui.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/swiper.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/common/main.js" type="text/javascript"></script>
<script>
	function upDownOperation(element)
	{
		var _input = element.parent().find('input'),
				_value = _input.val(),
				_step = _input.attr('data-step') || 1;
		//检测当前操作的元素是否有disabled，有则去除
		element.hasClass('disabled') && element.removeClass('disabled');
		//检测当前操作的元素是否是操作的添加按钮（.input-num-up）‘是’ 则为加操作，‘否’ 则为减操作
		if ( element.hasClass('weui-number-plus') )
		{
			var _new_value = parseInt( parseFloat(_value) + parseFloat(_step) ),
					_max = _input.attr('data-max') || false,
					_down = element.parent().find('.weui-number-sub');

			//若执行‘加’操作且‘减’按钮存在class='disabled'的话，则移除‘减’操作按钮的class 'disabled'
			_down.hasClass('disabled') && _down.removeClass('disabled');
			if (_max && _new_value >= _max) {
				_new_value = _max;
				element.addClass('disabled');
			}
		} else {
			var _new_value = parseInt( parseFloat(_value) - parseFloat(_step) ),
					_min = _input.attr('data-min') || false,
					_up = element.parent().find('.weui-number-plus');
			//若执行‘减’操作且‘加’按钮存在class='disabled'的话，则移除‘加’操作按钮的class 'disabled'
			_up.hasClass('disabled') && _up.removeClass('disabled');
			if (_min && _new_value <= _min) {
				_new_value = _min;
				element.addClass('disabled');
			}
		}
		_input.val( _new_value );
	}
	$(function(){
		$('.weui-number-plus').click(function(){
			upDownOperation( $(this) );
		});
		$('.weui-number-sub').click(function(){
			upDownOperation( $(this) );
		});
	});
	$('.kong').hide();
	$(document).on("click", "#sd2", function() {
		$.confirm("您确定要取消订单吗?", "确认取消?", function() {
			$.toast("已取消!");
			$('.ws').hide();
			$('.wc').hide();
			$('.kong').show();
		}, function() {

		});
	});
</script>
</body>
</html>