let bar_result = {};
let current_location = '';
let mainData = new Array();
let secondaryData = new Array();
var mainDataset = {
    label: '',
    data: [],
    backgroundColor: "rgba(255, 99, 132, 0.2)",
    borderColor: "rgba(255, 99, 132, 1)",
    borderWidth: 1
};
var secondaryDataset = {
    label: '',
    data: [],
    backgroundColor: "rgba(54, 162, 235, 0.2)",
    borderColor: "rgba(54, 162, 235, 1)",
    borderWidth: 1
};


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
    current_location = '';
});

var evaluationBarChart;
$.fn.drawBar = function (bar_result) {
    var ctx = document.getElementById('siteSelectionResult');
    if (typeof evaluationBarChart !== "undefined") {
        evaluationBarChart.destroy();
    }
    evaluationBarChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['交通', '竞业', '异业', '社区'],
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

$.fn.createCompareSite = function (address, responseFromServer) {
    let percentMainData = new Array();
    let percentSecondaryData = new Array();
    let compareDataSets = [];
    if (mainData.length === 0) {
        mainData = $.fn.getDataFromResponse(responseFromServer);
        mainDataset.label = address;
        mainDataset.data = [1, 1, 1, 1, 1, 1, 1, 1, 1];
        compareDataSets.push(mainDataset);
        compareBarChart.options.tooltips.callbacks.label = function(tooltipItem) {
            let index = tooltipItem.index;
            return mainDataset.label + ": " + mainData[index];
        }

    } else {
        secondaryDataset.label = address;
        secondaryData = $.fn.getDataFromResponse(responseFromServer);
        let showData = $.fn.getCompareBarShowData(mainData, secondaryData);
        percentSecondaryData = showData.secondaryDataArray;
        percentMainData = showData.mainDataArray;
        mainDataset.data = percentMainData;
        secondaryDataset.data = percentSecondaryData;
        compareDataSets.push(mainDataset);
        compareDataSets.push(secondaryDataset);
        compareBarChart.options.tooltips.callbacks.label = function(tooltipItem, data) {
            let index = tooltipItem.index;
            return mainDataset.label + ": " + mainData[index]
                + " " + secondaryDataset.label + ": " + secondaryData[index];
        }
    }
    return compareDataSets;
};

$.fn.getDataFromResponse = function(responseFromServer) {
    let data = new Array();
    data.push(responseFromServer.trafficEvaluation.metroAmount);
    data.push(responseFromServer.trafficEvaluation.busStationAmount);
    data.push(responseFromServer.trafficEvaluation.parkingAmount);
    data.push(responseFromServer.competitorEvaluation.competitorAmount);
    data.push(responseFromServer.competitorEvaluation.starCompetitorAmount);
    data.push(responseFromServer.cooperatorEvaluation.cooperatorAmount);
    data.push(responseFromServer.communityEvaluation.apartmentAmount);
    data.push(responseFromServer.communityEvaluation.avgPrice);
    data.push(responseFromServer.communityEvaluation.avgBuildYear);
    return data;
};

$.fn.getCompareBarShowData = function (mainDataArray, secondaryDataArray) {
    let showData = {
        mainDataArray: [],
        secondaryDataArray: []
    };
    for (let i=0; i<mainDataArray.length; i++) {
        let sumOfItems = mainDataArray[i]+secondaryDataArray[i];
        showData.mainDataArray[i] = sumOfItems === 0 ? 0 : (-1)*mainDataArray[i]/sumOfItems;
        showData.secondaryDataArray[i] = sumOfItems === 0 ? 0 : secondaryDataArray[i]/sumOfItems;
    }
    return showData;
};

var compareBarChart;
$.fn.compareSite = function (reponseFromServer) {
    var ctx = document.getElementById('siteCompare');
    ctx.height = (window.innerHeight*0.4);
    if (typeof compareBarChart !== "undefined") {
        compareBarChart.destroy();
    }
    compareBarChart = $.fn.createChartInstance(ctx);
    var dataForChart = $.fn.createCompareSite(document.getElementById('tipinput').value, reponseFromServer)
    compareBarChart.data.datasets = dataForChart;
    compareBarChart.update();
};

$.fn.createChartInstance = function (ctx) {
    return new Chart(ctx, {
        type: 'horizontalBar',
        data: {
            labels: ['地铁轻轨', '公交车站', '停车场', '一线早教', '普通早教', '异业机构', '居民户数', '平均房价', '平均修建年份'],
            datasets: []
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    },
                    barPercentage: 0.5,
                    barThickness: 12,
                    minBarLength: 20
                }],
                xAxes: [{
                    ticks: {
                        display: false
                    }
                }]
            }
        }
    });
};

$.fn.checkMainCompare = function () {
    let checkbox = document.getElementsByName("compare")[0];
    if (checkbox.checked) {
        $("#compareBarSection").css("display", "inline-block");
        $("#detailTableSection").removeClass("sixteen wide column").addClass("ten wide column");
        $("#compareMainName").html(document.getElementById('tipinput').value);
    }else {
        $("#compareBarSection").css("display", "none");
        $("#detailTableSection").removeClass("ten wide column").addClass("sixteen wide column");
        $("#compareMainName").html("");
    }
};

