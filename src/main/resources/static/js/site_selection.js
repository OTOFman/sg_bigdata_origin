
$.fn.loadMap = function () {
    console.log('sasasa');
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

$(document).ready(function(){
    $('.menu .item').tab();
});




