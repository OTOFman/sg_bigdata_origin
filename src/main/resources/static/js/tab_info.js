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