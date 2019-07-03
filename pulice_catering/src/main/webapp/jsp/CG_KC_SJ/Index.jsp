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
<!--轮播图-->
<div class="weui-tab">
	<div class="weui-tab__bd">
		<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
			<div class="swiper-container bgcolor_f">
				<div class="swiper-wrapper">
					<div class="swiper-slide"><img src="${ctxStatic}/images/swiper1.png" alt=""></div>
					<div class="swiper-slide"><img src="${ctxStatic}/images/swiper1.png" alt=""></div>
					<div class="swiper-slide"><img src="${ctxStatic}/images/swiper1.png" alt=""></div>
				</div>
			</div>
			<div class="weui-flex bgcolor_f">
				<div class="weui-flex__item">
					<a href="G_Z_H/预约/AddOrder.jsp" class="weui-grid js_grid ico_grid">
						<div class="weui-grid__icon">
							<img src="${ctxStatic}/images/index_ico3.png" alt="">
						</div>
						<p class="weui-grid__label ico_title">
							预定
						</p>
					</a>
				</div>
				<div class="weui-flex__item">
					<a href="/food_list/food-list/query.do" class="weui-grid js_grid ico_grid">
						<div class="weui-grid__icon">
							<img src="${ctxStatic}/images/index_ico2.png" alt="">
						</div>
						<p class="weui-grid__label ico_title">
							点餐
						</p>
					</a>
				</div>
				<div class="weui-flex__item">
					<a href="G_Z_H/waimai/DianCan.jsp" class="weui-grid js_grid ico_grid">
						<div class="weui-grid__icon">
							<img src="${ctxStatic}/images/index_ico4.png" alt="">
						</div>
						<p class="weui-grid__label ico_title">
							外卖
						</p>
					</a>
				</div>
				<div class="weui-flex__item">
					<a href="G_Z_H/排队/paidui.jsp" class="weui-grid js_grid ico_grid">
						<div class="weui-grid__icon">
							<img src="${ctxStatic}/images/index_ico1.png" alt="">
						</div>
						<p class="weui-grid__label ico_title">
							排队
						</p>
					</a>
				</div>
				<div class="weui-flex__item">
					<a href="G_Z_H/优惠券/CouPon.jsp" class="weui-grid js_grid ico_grid">
						<div class="weui-grid__icon">
							<img src="${ctxStatic}/images/index_ico5.png" alt="">
						</div>
						<p class="weui-grid__label ico_title">
							优惠券
						</p>
					</a>
				</div>
			</div>
			<div class="weui-cells__title list_block_title bgcolor_f">商家信息</div>
			<div class="weui-cells">
				<div class="weui-cell list_item color_gray2">
					<div class="weui-cell__hd size_14">营业时间</div>
					<div class="weui-cell__bd size_14">00：00—00：00</div>
				</div>
				<div class="weui-cell weui-cell_access list_item color_gray2">
					<div class="weui-cell__hd size_14">商家电话</div>
					<div class="weui-cell__bd size_14">18856954887</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div class="weui-cell list_item color_gray2">
					<div class="weui-cell__hd size_14">商家地址</div>
					<div class="weui-cell__bd size_14">湖北省襄阳市追日路襄阳软件园</div>
				</div>
			</div>
			<div class="mar_bottom"></div>
		</div>
		<div id="tab2" class="weui-tab__bd-item">
			<div class="weui-tab">
				<div class="weui-navbar">
					<a class="second_tab_item item_active" href="#order_tab1">
						点餐
					</a>
					<a class="second_tab_item" href="#order_tab2">
						外卖
					</a>
					<a class="second_tab_item" href="#order_tab3">
						预定
					</a>
				</div>
				<div class="weui-tab__bd second_tab_bd">
					<div id="order_tab1" class="second_tab_bd_item tab_bd_active">
						<div class="page__bd item_margin_bottom bgcolor_f">
							<div class="weui-panel">
								<div class="weui-cells no_magrin_top">
									<a class="weui-cell weui-cell_access" href="G_Z_H/dindan/ddxq-wfk.jsp">
										<div class="weui-cell__bd weui-cell_primary">
											<p>易牙美食餐厅</p>
										</div>
										<span class="weui-cell__ft">未付款</span>
									</a>
								</div>

								<div class="weui-panel__bd">
									<div class="weui-media-box weui-media-box_text panel_box">
										<h3 class="weui-media-box__title">豆汤豌豆</h3>
										<p class="weui-media-box__desc color_black">下单时间：2018-12-20 12：00</p>
										<p style="padding-top: 10px;" class="weui-media-box__desc color_black">总价：¥18</p>
									</div>
								</div>
								<div class="weui-panel__bd">
									<div class="weui-media-box weui-media-box_text panel_box">
										<h3 class="weui-media-box__title">豆汤豌豆2</h3>
										<p class="weui-media-box__desc color_black">下单时间：2018-12-20 12：00</p>
										<p style="padding-top: 10px;"  class="weui-media-box__desc color_black">总价：¥18</p>
									</div>
								</div>
							</div>
						</div>
						<div class="page__bd item_margin_bottom bgcolor_f">
							<div class="weui-panel">
								<div class="weui-cells no_magrin_top">
									<a class="weui-cell"  href="G_Z_H/dindan/ddxq-yfk.jsp">
										<div class="weui-cell__bd weui-cell_primary color_black">
											<p>易牙美食餐厅</p>
										</div>
										<span class="weui-cell__ft">已付款</span>
									</a>
								</div>
								<div class="weui-panel__bd">
									<div class="weui-media-box weui-media-box_text panel_box">
										<h3 class="weui-media-box__title">豆汤豌豆</h3>
										<p class="weui-media-box__desc color_black">下单时间：2018-12-20 12：00</p>
										<ul class="weui-media-box__info">
											<li class="weui-media-box__info__meta color_black">总价：¥18</li>
											<li class="weui-media-box__info__meta color_black fl_right">
												<div class="weui-rater">
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star-o" aria-hidden="true"></i>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="mar_bottom"></div>
					</div>
					<div id="order_tab2" class="second_tab_bd_item">
						<div class="page__bd item_margin_bottom bgcolor_f">
							<div class="weui-panel">
								<div class="weui-cells weui_cells_border no_magrin_top">
									<a class="weui-cell weui-cell_access" href="G_Z_H/dindan/ddxq.jsp">
										<div class="weui-cell__bd weui-cell_primary">
											<p>易牙美食餐厅</p>
										</div>
										<span class="weui-cell__ft">未付款</span>
									</a>
								</div>
								<div class="weui-panel__bd">
									<div class="weui-media-box weui-media-box_text panel_box">
										<div class="weui-media-box__info panel_list_black">
											<p class="weui-media-box__info__meta">煲仔豆豉娃娃菜</p>
											<p class="weui-media-box__info__meta fl_right">×1</p>
										</div>
										<div class="weui-media-box__info panel_list_black">
											<p class="weui-media-box__info__meta">酸辣土豆丝</p>
											<p class="weui-media-box__info__meta fl_right">×1</p>
										</div>
										<ul class="weui-media-box__info">
											<li class="weui-media-box__info__meta fl_right color_black">合计：¥28</li>
											<li class="weui-media-box__info__meta fl_right color_black">共一件商品</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="page__bd item_margin_bottom bgcolor_f">

							<div class="weui-panel">
								<div class="weui-cells no_magrin_top weui_cells_border">
									<a class="weui-cell weui-cell_access" href="G_Z_H/dindan/WaiMaiDetail.jsp">
										<div class="weui-cell__bd weui-cell_primary">
											<p>易牙美食餐厅</p>
										</div>
										<span class="weui-cell__ft">已付款</span>
									</a>
								</div>
								<div class="weui-panel__bd">
									<div class="weui-media-box weui-media-box_text panel_box">
										<div class="weui-media-box__info panel_list_black">
											<p class="weui-media-box__info__meta">煲仔豆豉娃娃菜</p>
											<p class="weui-media-box__info__meta fl_right">×1</p>
										</div>
										<ul class="weui-media-box__info">
											<li class="weui-media-box__info__meta color_black">
												<div class="weui-rater">
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star-o" aria-hidden="true"></i>
												</div>
											</li>
											<li class="weui-media-box__info__meta fl_right color_black">合计：¥28</li>
											<li class="weui-media-box__info__meta fl_right color_black">共一件商品</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="mar_bottom"></div>
					</div>
					<div id="order_tab3" class="second_tab_bd_item">
						<div class="weui-cells no_magrin_top">
							<div class="weui-cell padding_new magrin_top_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">下单日期：</span>
									<span>2018-11-21 15:30:12</span>
								</div>
							</div>
							<div class="weui-cell padding_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">预定日期：</span>
									<span>2018-11-21 15:30:12</span>
								</div>
							</div>
							<div class="weui-cell padding_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">桌位类型：</span>
									<span>二十人桌</span>
								</div>
							</div>
							<div class="weui-cell padding_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">预留姓名：</span>
									<span>张三</span>
								</div>
							</div>
							<p class="fl_right padding_new" style="font-size: 13px;color: #888888;">已取消</p>
						</div>
						<div class="weui-cells">
							<div class="weui-cell padding_new magrin_top_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">下单日期：</span>
									<span>2018-11-21 15:30:12</span>
								</div>
							</div>
							<div class="weui-cell padding_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">预定日期：</span>
									<span>2018-11-21 15:30:12</span>
								</div>
							</div>
							<div class="weui-cell padding_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">桌位类型：</span>
									<span>二十人桌</span>
								</div>
							</div>
							<div class="weui-cell padding_new">
								<div class="weui-cell__bd">
									<span style="vertical-align: middle">预留姓名：</span>
									<span>张三</span>
								</div>
							</div>
							<p class="fl_right padding_new" style="font-size: 13px;color: #888888;">预定成功</p>
						</div>
						<div class="mar_bottom"></div>
					</div>
				</div>
			</div>
		</div>
		<div id="tab3" class="weui-tab__bd-item">
			<div class="page__bd bgcolor_f">
				<div class="weui-panel">
					<div class="weui-cells no_magrin_top">
						<a class="weui-cell weui-cell_access" href="javascript:;">
							<div class="weui-cell__bd weui-cell_primary">
								<p>易牙美食餐厅</p>
							</div>
							<span class="weui-cell__ft">待付款</span>
						</a>
					</div>
					<div class="weui-panel__bd">
						<div class="weui-media-box weui-media-box_text panel_box">
							<div class="weui-media-box__info panel_list_black">
								<p class="weui-media-box__info__meta">煲仔豆豉娃娃菜</p>
								<p class="weui-media-box__info__meta fl_right">¥18×1</p>
							</div>
							<div class="weui-media-box__info panel_list_black">
								<p class="weui-media-box__info__meta">酸辣土豆丝</p>
								<p class="weui-media-box__info__meta fl_right">¥10×1</p>
							</div>
							<p class="text_right padding_new size_14">共2件商品</p>
							<p class="text_right padding_new size_16 color_red">共计：¥28</p>
						</div>
					</div>
				</div>
			</div>
			<div class="page__bd">
				<a href="javascript:;" class="weui-btn weui-btn_primary btn_small btn_new">付款</a>
			</div>
			<div class="mar_bottom"></div>
		</div>
		<div id="tab4" class="weui-tab__bd-item" style="background:#fff;">
			<div class="weui-panel no_magrin_top userinfo_box">
				<div class="info_img">
					<div class="toux">
						<img src="${ctxStatic}/images/head_img.png" />
					</div>
					<div class="info">
						<h5>我的名字</h5>
						<p>18865987458</p>
					</div>
				</div>
			</div>
			<div class="weui-cells no_magrin_top">
				<a class="weui-cell weui-cell_access" href=G_Z_H/wode/AddressList.jsp">
					<div class="weui-cell__hd list_img">
						<i class="fa fa-map-o" aria-hidden="true"></i>
					</div>
					<div class="weui-cell__bd">
						<p>我的地址</p>
					</div>
					<div class="weui-cell__ft"></div>
				</a>
				<div class="weui-cell" href="javascript:;">
					<div class="weui-cell__hd list_img">
						<i class="fa fa-diamond" aria-hidden="true"></i>
					</div>
					<div class="weui-cell__bd">
						<p>会员等级</p>
					</div>
					<div class="weui-cell__ft">三级</div>
				</div>
				<div class="weui-cell" href="javascript:;">
					<div class="weui-cell__hd list_img">
						<i class="fa fa-money" aria-hidden="true"></i>
					</div>
					<div class="weui-cell__bd">
						<p>我的余额</p>
					</div>
					<div class="weui-cell__ft">536</div>
				</div>
				<div class="weui-cell weui-cell_access" href="javascript:;">
					<div class="weui-cell__hd list_img">
						<i class="fa fa-credit-card" aria-hidden="true"></i>
					</div>
					<div class="weui-cell__bd">
						<p>会员充值</p>
					</div>
					<div class="weui-cell__ft"></div>
				</div>
			</div>
			<div class="mar_bottom"></div>
		</div>
	</div>
	<div class="weui-tabbar">
		<a href="#tab1" class="weui-tabbar__item weui-bar__item--on">
			<div class="weui-tabbar__icon">
				<i class="fa fa-home" aria-hidden="true"></i>
			</div>
			<p class="weui-tabbar__label">首页</p>
		</a>
		<a href="#tab2" class="weui-tabbar__item">
			<div class="weui-tabbar__icon">
				<i class="fa fa-file-text-o" aria-hidden="true"></i>
			</div>
			<p class="weui-tabbar__label">订单</p>
		</a>
		<a href="#tab3" class="weui-tabbar__item">
			<div class="weui-tabbar__icon">
				<i class="fa fa-jpy" aria-hidden="true"></i>
			</div>
			<p class="weui-tabbar__label">买单</p>
		</a>
		<a href="#tab4" class="weui-tabbar__item">
			<div class="weui-tabbar__icon">
				<i class="fa fa-user-o" aria-hidden="true"></i>
			</div>
			<p class="weui-tabbar__label">我的</p>
		</a>
	</div>
</div>














<script src="${ctxStatic}/common/jquery.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/jquery-weui.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/swiper.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/common/main.js" type="text/javascript"></script>
<script>
	var mySwiper = new Swiper('.swiper-container',
			{
				speed: 3000,//播放速度
				autoHeight: true,
				loop: true,//是否循环播放
				setWrapperSize: true,
				autoplay:
						{
							delay: 5000,
							disableOnInteraction: false,
						},
				pagination: '.swiper-pagination',//分页
				effect: 'slide',//动画效果
			}
	);
</script>
</body>
</html>