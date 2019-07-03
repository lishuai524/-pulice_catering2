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
<form id="formid" method="post" action="/reserve_tables_list/reserve-tables-list/add.do">
<div class="weui-cells weui-cells_form no_magrin_top">
	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">预定日期：</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" name="order_date" id="time" type="text" value="" readonly="">
		</div>
	</div>
	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">预定时间：</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" name="scheduled_time" id="time2" type="text" value="" readonly="">
		</div>
	</div>
	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">联系人：</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" name="name" type="text" placeholder="请输入联系人称呼">
		</div>
	</div>
	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">就餐人数：</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" name="people" type="number" placeholder="请输入就餐人数">
		</div>
	</div>
	<div class="weui-cell">
		<div class="weui-cell__hd"><label class="weui-label">联系电话：</label></div>
		<div class="weui-cell__bd">
			<input class="weui-input" name="reserved" type="text" placeholder="请输入联系电话">
		</div>
	</div>
</div>
<div class="weui-cells weui-cells_form">
	<div class="weui-cells__title color_black">备注：</div>
	<div class="weui-cells weui-cells_form">
		<div class="weui-cell">
			<div class="weui-cell__bd">
				<textarea name="remark" class="weui-textarea" placeholder="请输入备注信息" rows="3"></textarea>
				<div class="weui-textarea-counter"><span>0</span>/200</div>
			</div>
		</div>
	</div>
</div>
<div class="demos-content-padded">
	<a href="javascript:;" class="weui-btn weui-btn_primary bg_button_color" onclick="checkUser()">立即预约</a>
</div>
</form>







<script src="/common/jquery.js" type="text/javascript"></script>
	<script src="/common/jquery-weui.js" type="text/javascript"></script>
	<script src="/common/swiper.min.js" type="text/javascript"></script>
<script src="/common/main.js" type="text/javascript"></script>
<script>
    function checkUser(){
        // var result = document.getElementById("userid").value;
        // var password = document.getElementById("passid").value;
		//
        // if(!result){
        //     alert("用户名不能为空");
        //     return false;
        // }
        // if(!password){
        //     alert("密码不能为空");
        //     return false;
        // }
        document.getElementById("formid").submit();
    }

	$("#time").datetimePicker({
		title: '预定日期',
		min: "1990-12-12",
		max: "2022-12-12",
		onChange: function (picker, values, displayValues) {
			console.log(values);
		}
	});
	$("#time2").datetimePicker({
		title: '预定时间',
		min: "1990-12-12",
		max: "2022-12-12",
		onChange: function (picker, values, displayValues) {
			console.log(values);
		}
	});
</script>
</body>
</html>