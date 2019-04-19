var map = "";
$(document).ready(function () {
    map = new AMap.Map("auto_navi_map", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        keyboardEnable: false
    });
});

$.fn.searchPoiByName = function() {
    var windowsArr = [];
    var marker = [];

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

$.fn.searchPoiByType = function(type, city, radius, location) {
    AMap.plugin(['AMap.PlaceSearch'],function(){
        var placeSearch = new AMap.PlaceSearch({
            city:city,
            map:map,
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
    var geocode = "";
    var address  = document.getElementById('tipinput').value;
    geocoder.setCity("全国");
    geocoder.getLocation(address, function(status, result) {
        if (status === 'complete'&&result.geocodes.length) {
            geocode = result.geocodes[0].location
            $.fn.searchPoiByType(type, city, radius, geocode);
        }else {
            alert(JSON.stringify(result))
        }
    });
};

