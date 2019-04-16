
$.fn.loadMap = function () {
    var url = 'https://webapi.amap.com/maps?v=1.4.14&key=e70e70fc0c617d13aa771071fa154138&callback=onLoad';
    var jsapi = document.createElement('script');
    jsapi.charset = 'utf-8';
    jsapi.src = url;
    document.head.appendChild(jsapi);
};

$.fn.drawRadar = function (radar_result) {
    var ctx = document.getElementById('siteSelectionResult');
    console.log(JSON.stringify(radar_result));
    var myChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['交通', '异业', '竞业'],
            datasets: radar_result
        },
        options: {
        }
    });
};

$.fn.getEvaluationRadarResult = function() {
    location.href = "/site_selection_radar?instituteName=" + document.getElementsByName("searchAddress")[0].value;
};

$.fn.searchPoiByname = function() {
    var windowsArr = [];
    var marker = [];
    var map = new AMap.Map("auto_navi_map", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        keyboardEnable: false
    });
    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){
        var autoOptions = {
            city: "武汉", //城市，默认全国
            input: "tipinput"//使用联想输入的input的id
        };
        autocomplete= new AMap.Autocomplete(autoOptions);
        var placeSearch = new AMap.PlaceSearch({
            city:'武汉',
            map:map
        })
        AMap.event.addListener(autocomplete, "select", function(e){
            console.log(e.poi.name);
            console.log(e.poi);
            placeSearch.setCity(e.poi.adcode);
            placeSearch.search(e.poi.name, function (status, result) {
                console.log(status);
                console.log(result);
            })
        });
    });
};

$(document).ready(function(){
    $('.menu .item').tab();
    $().searchPoiByname();
});




