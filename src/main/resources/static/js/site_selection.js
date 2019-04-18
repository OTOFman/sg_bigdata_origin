
let radar_result = {};

$.fn.loadMap = function () {
    var url = 'https://webapi.amap.com/maps?v=1.4.14&key=e70e70fc0c617d13aa771071fa154138&callback=onLoad';
    var jsapi = document.createElement('script');
    jsapi.charset = 'utf-8';
    jsapi.src = url;
    document.head.appendChild(jsapi);
};

$(document).ready(function(){
    $('.menu .item').tab();
    $.fn.searchPoiByName();
});



