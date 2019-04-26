$(document).ready(function () {
    let items = Array.prototype.slice.call(document.getElementsByClassName("item"));
    items.map(function (item) {
        $(item).click(function () {
            items.forEach(function (value) {
                $(value).removeClass("active");
            });
            $(item).addClass("active");
            if ("first" === item.dataset.tab) {
               $.fn.renderPoiByType("公交站|地铁站|停车场", "武汉", 1000);
            } else if ("second" === item.dataset.tab) {
               $.fn.renderPoiByType("早教", "武汉", 3000);
            } else if ("third" === item.dataset.tab) {
               $.fn.renderPoiByType("儿童|幼儿", "武汉", 3000);
            } else {
               $.fn.renderPoiByType("住宅小区|别墅", "武汉", 3000);
            }
            let tabs = Array.prototype.slice.call(document.getElementsByClassName("tab"));
            tabs.forEach(function (value) {
                if (item.dataset.tab == value.dataset.tab) {
                    $(value).addClass("active");
                } else {
                    $(value).removeClass("active");
                }
            })
        })
    })
});