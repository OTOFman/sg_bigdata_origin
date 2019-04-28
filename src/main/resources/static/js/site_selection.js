
let bar_result = {};

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
    compareSite();
});


$.fn.drawBar = function (bar_result) {
    var ctx = document.getElementById('siteSelectionResult');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['交通', '异业', '竞业', '社区'],
            datasets: bar_result
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            responsive: true,
            maintainAspectRatio: false,
            legend: {
                display: false,
            },
            title: {
                display: true,
                text: '选址智能分析'
            },
            layout: {
                padding: {
                    left: 0,
                    right: 0,
                    top: 0,
                    bottom: 0
                }
            }
        }
    });
};


