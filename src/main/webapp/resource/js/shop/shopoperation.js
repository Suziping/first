/*
*
*
* */


$(function () {
    var initUrl = '/first/shopadmin/getshopinitinfo';//获取店铺的初始信息
    var registerShopUrl = '/first/shopadmin/registershop';
    alert(initUrl);//表示js的文件已经被加载并且被执行
    getShopInitInfo();

    //定义第一个方法，获取店铺的基本信息
    function getShopInitInfo() {
        $.getJSON(initUrl,function (data) {
            if (data.success){
                var tempHtml = "";
                var tempAreaHtml = "";//初始化一个变量用来获取区域信息
                data.shopCategoryList.map(function (item,index) {
                    tempHtml += '<option data-id="'+item.shopCategoryId+'">'+item.shopCategoryName + '</option>';
                });
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id = "'+item.areaId+'">'+item.areaName+'</option>';
                });

                //将获取到的信息添加到前台里面去
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });

        $('#submit').click(function(){
            var shop = {};  //模拟一个shop实体
            shop.shopName = $('#shop-name').val();
            shop.shopAddr = $('#shop-addr').val();
            shop.phone = $('#phone').val();
            shop.shopDesc = $('#shop-desc').val();
            shop.shopCategory = {
                shopCategoryId:$('#shop-category').find('option').not(function () {
                    return !this.selected;
                }).data('id')
            };
            shop.area = {
                areaId:$('#area').find('option').not(function () {
                    return !this.selected;
                }).data('id')
            };

            //图片流的选取
            var shopImg = $('#shop-img')[0].files[0];
            var formData = new FormData();
            formData.append('shopImg',shopImg);
            formData.append('shopStr',JSON.stringify(shop));
            var verifyCodeActual = $('#j_captcha').val();
            if (!verifyCodeActual){
                $.toast('请输入验证码');
                return;
            }
            formData.append('verifyCodeActual',verifyCodeActual);
            $.ajax({
                url:registerShopUrl,
                type:'POST',
                data:formData,
                contentType:false,
                processData:false,
                cache:false,
                success:function (data) {
                    if (data.success){
                        $.toast('提交成功');
                    }else {
                        $.toast('提交失败' + data.errMsg);
                    }
                    $('#captcha_img').click();
                }
            });
        });
    }
})