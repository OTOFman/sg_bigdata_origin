var map = "";
$(document).ready(function () {
    map = new AMap.Map("auto_navi_map", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        keyboardEnable: false
    });
});

$.fn.searchPoiByName = function() {

    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){
        var autoOptions = {
            city: "武汉", //城市，默认全国
            input: "tipinput"//使用联想输入的input的id
        };
        autocomplete= new AMap.Autocomplete(autoOptions);
        var placeSearch = new AMap.PlaceSearch({
            pageSize: 5,
            pageIndex: 1,
            city:'武汉',
            citylimit: true,
            map:map,
            panel: "panel"
        });
        AMap.event.addListener(autocomplete, "select", function(e){
            placeSearch.setCity(e.poi.adcode);
            placeSearch.search(e.poi.name);
        });
        AMap.event.addListener(placeSearch, "complete", function (e) {
            current_location = e.poiList.pois[0].location;
            getEvaluationBarResult(e.poiList.pois[0].location);

        });
    });
};

$.fn.searchPoiByType = function(type, city, radius, location) {
    AMap.plugin(['AMap.PlaceSearch'],function(){
        var placeSearch = new AMap.PlaceSearch({
            pageSize: 5,
            pageIndex: 1,
            city:city,
            citylimit: true,
            map:map,
            panel: "panel"
        });
        placeSearch.setPageSize(50);
        placeSearch.searchNearBy(type, location, radius);
    });
};

$.fn.getGeoCode = function () {
    var geocoder = new AMap.Geocoder({
            city: "全国"
    });
    var geocode = "";
    var address  = document.getElementById('tipinput').value;
    console.log(address);
    geocoder.setCity("全国");
    geocoder.getLocation(address, function(status, result) {
        if (status === 'complete'&&result.geocodes.length) {
            geocode = result.geocodes[0].location
        }else {
            alert(JSON.stringify(result))
        }
    });
};

$.fn.renderPoiByType = function (type, city, radius) {
    var geocoder = new AMap.Geocoder({
        city: "全国"
    });
    map.clearMap();
    if (current_location != "") {
        $.fn.searchPoiByType(type, city, radius, current_location);
    }
    return;
};

