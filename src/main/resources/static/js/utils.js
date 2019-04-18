$.fn.searchPoiByName = function() {
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
            placeSearch.setCity(e.poi.adcode);
            placeSearch.search(e.poi.name);
            getEvaluationRadarResult(e.poi.name);
        });
    });
};