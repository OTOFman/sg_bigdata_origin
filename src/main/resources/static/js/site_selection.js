let bar_result = {};

let mainData = new Array();
let secondaryData = new Array();
var mainDataset = {
    label: '',
    data: [],
    backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(198, 78, 64, 0.2)',
        'rgba(200, 200, 200, 0.2)',
        'rgba(211, 78, 8, 0.2)'
    ],
    borderColor: [
        'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(198, 78, 64, 0.2)',
        'rgba(200, 200, 200, 0.2)',
        'rgba(211, 78, 8, 0.2)'
    ],
    borderWidth: 1
};
var secondaryDataset = {
    label: '',
    data: [],
    backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(198, 78, 64, 0.2)',
        'rgba(200, 200, 200, 0.2)',
        'rgba(211, 78, 8, 0.2)'
    ],
    borderColor: [
        'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(198, 78, 64, 0.2)',
        'rgba(200, 200, 200, 0.2)',
        'rgba(211, 78, 8, 0.2)'
    ],
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
    //compareSite();
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

$.fn.createCompareSite = function (address, responseFromServer) {
    let percentMainData = new Array();
    let percentSecondaryData = new Array();
    let compareDataSets = [];
    if (mainData.length === 0) {
        mainData = $.fn.getDataFromResponse(responseFromServer);
        mainDataset.label = address;
        mainDataset.data = [1, 1, 1, 1, 1, 1, 1, 1, 1];
        compareDataSets.push(mainDataset);
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
        showData.mainDataArray[i] = sumOfItems === 0 ? 0 : mainDataArray[i]/sumOfItems;
        showData.secondaryDataArray[i] = sumOfItems === 0 ? 0 : (-1)*secondaryDataArray[i]/sumOfItems;
    }
    return showData;
};


