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
<!--轮播图-->
<div class="weui-tab">
    <div class="weui-tab__bd">
        <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
            <div class="weui-cells__title list_block_title bgcolor_f">门店信息</div>
            <div class="weui-cells">

                <a  href="javascript:void(0)" onclick="toMdIndex('f594c109e55a48d4a78196b29f8f81df')">
                    <div class="weui-cell list_item color_gray2">
                        <div class="weui-cell__hd size_14">门店名称：门店1</div>
                    </div>
                    <div class="weui-cell list_item color_gray2">
                        <div class="weui-cell__hd size_14">营业时间</div>
                        <div class="weui-cell__bd size_14">
                            07:00-
                            22:00
                        </div>
                    </div>
                    <div class="weui-cell weui-cell_access list_item color_gray2">
                        <div class="weui-cell__hd size_14">商家电话</div>
                        <div class="weui-cell__bd size_14">17777777777</div>
                        <div class="weui-cell__ft"></div>
                    </div>
                    <div class="weui-cell list_item color_gray2">
                        <div class="weui-cell__hd size_14">商家地址</div>
                        <div class="weui-cell__bd size_14">襄阳市襄州区东湖国际花园</div>
                    </div>




                </a>
                <br/>
                <br/>

                <a  href="javascript:void(0)" onclick="toMdIndex('160b351302f14f0e850949709a5824f7')">
                    <div class="weui-cell list_item color_gray2">
                        <div class="weui-cell__hd size_14">门店名称：门店2</div>
                    </div>
                    <div class="weui-cell list_item color_gray2">
                        <div class="weui-cell__hd size_14">营业时间</div>
                        <div class="weui-cell__bd size_14">
                            07:00-
                            22:00
                        </div>
                    </div>
                    <div class="weui-cell weui-cell_access list_item color_gray2">
                        <div class="weui-cell__hd size_14">商家电话</div>
                        <div class="weui-cell__bd size_14">17711112222</div>
                        <div class="weui-cell__ft"></div>
                    </div>
                    <div class="weui-cell list_item color_gray2">
                        <div class="weui-cell__hd size_14">商家地址</div>
                        <div class="weui-cell__bd size_14">襄阳市襄城区余家湖</div>
                    </div>




                </a>
                <br/>
                <br/>



            </div>
            <div class="mar_bottom"></div>
        </div>
    </div>
    <input type="hidden" id="hyOpenid" value="o3KmFt67QKcQSUYQcQ-MXul-cEDg">
    <input type="hidden" id="zdStoreId" value="f4514239e8f446aeb0c24a3409e41b78">
</div>
<script src="/common/jquery.js" type="text/javascript"></script>
<script src="/common/jquery-weui.js" type="text/javascript"></script>
<script src="/common/swiper.min.js" type="text/javascript"></script>
<script src="/common/main.js" type="text/javascript"></script>
<script>
    var hyOpenid =$("#hyOpenid").val();
    localStorage.setItem("hyOpenid",hyOpenid);
    $(document).ready(function () {
        //根据当前定位获取由近到远的门店信息

    });




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

    function toMdIndex(storeId) {
        var hyOpenid='o3KmFt67QKcQSUYQcQ-MXul-cEDg';
        var zdStoreId='f4514239e8f446aeb0c24a3409e41b78';
        // window.location.href="/yiya/wx/Common/mdIndex?hyOpenid="+hyOpenid+"&storeId="+storeId+"&zdStoreId="+zdStoreId+"&type=0";
        window.location.href="/jsp/JC_HY_DD/gongzhonghao/Index.jsp";
    }

</script>
</body>
</html>