$(document).ready(function(){
    $('.menu .item').tab();
});

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