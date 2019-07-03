$(function () {
    $('.second_tab_item').on('click', function () {
        $(this).addClass('item_active').siblings('.item_active').removeClass('item_active');
        //内容切换
        var data_toggle = jQuery(this).attr("href");
        $(data_toggle).addClass("tab_bd_active");
        $(data_toggle).siblings('.tab_bd_active').removeClass('tab_bd_active');
    });
    $('.ul_li_item').on('click', function () {
        $(this).addClass('left_item_active').siblings('.left_item_active').removeClass('left_item_active');
        //内容切换
        var data_toggle = jQuery(this).attr("href");
        $(data_toggle).addClass("weui-tab__bd-item--active");
        $(data_toggle).siblings('.weui-tab__bd-item--active').removeClass('weui-tab__bd-item--active');
    });
});

