window.onload = function() {
    var ctx = document.getElementById('siteSelectionResult');
    var myChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['交通', '异业', '竞业'],
            datasets: [radar_result]
        },
        options: {
        }
    });
};

$('.menu .item').tab();