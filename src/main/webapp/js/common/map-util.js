var map;
var layer;
//定义一些常量
var piObj = {
    x_PI : 3.14159265358979324 * 3000.0 / 180.0,
    PIs : 3.1415926535897932384626,
    a : 6378245.0,
    ee : 0.00669342162296594323
};
$(function(){
    layui.use('layer',function() {
        layer = layui.layer;
    });
    initMap();



    //定位到地理位置名
    $("#btn").click(function(){
        getLngAndLat("邢台市邢台学院");
    })
});

function initMap() {
    //初始化地图
    map = new BMap.Map("containerMap", {enableMapClick: false,minZoom : 10}); //创建Map实例

    var lng; //初始经度 如果不存在使用 默认位置
    var lat; //初始维度
    var address = "";
    if(lng == undefined || lat == undefined){
        var myCity = new BMap.LocalCity();
        myCity.get(function(lcr){
            $("#lng").val(lcr.center.lng);
            $("#lat").val(lcr.center.lat);
            getLngAndLat(lcr.name);
        });
    }else{
        map.centerAndZoom(new BMap.Point($("#lng").val(),$("#lat").val()), 15);
        map.enableDragging();//开启地图惯性拖拽
        addPoint($("#lng").val(),$("#lat").val(),contextPath+'/images/address.png',23,25,"","sssss");

        var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
        var bottom_left_Scale = new BMap.ScaleControl();
        map.addControl(top_left_navigation);
        map.addControl(bottom_left_Scale);
    }
    //添加点击事件
    clickMap();
}

/**
 * 点击地图，返回坐标点
 */
function clickMap(){
    map.addEventListener("click", function(e){//地图单击事件,获取经纬度
        if(!e.overlay){
            layer.open({
                title: '添加坐标点'
                , area: ['500px', '360px']
                , type: 2 //content内容为一个连接
                , content: contextPath+'/pages/addPoint.jsp?addressLongitude='+e.point.lng+'&addressLatitude='+e.point.lat
                , btn:["添加","取消"],
                yes:function (index, layero) {
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    iframeWin.saveAddress(index,layer);
                },cancel: function(){
                    return true;
                }
            });
        }
        // map.clearOverlays();//删除所有坐标点
        // addPoint(e.point.lng,e.point.lat,contextPath+'/images/address.png',35,94,"","");
        // var arr = gcToDb(114.50532,37.09006);
        // console.log(e.point.lng)
        // console.log(e.point.lat)
        // $("#lng").val(e.point.lng);
        // $("#lat").val(e.point.lat);
    });
}

/**
 * 获取经纬度
 */
function getLngAndLat(address,lng,lat) {
    var options = {
        onSearchComplete: function(results){
            if (local.getStatus() == BMAP_STATUS_SUCCESS){
                // 判断状态是否正确
                var s = [];
                for (var i = 0; i < results.getCurrentNumPois(); i ++){
                    s.push(results.getPoi(i).point.lng+','+results.getPoi(i).point.lat);
                }
                var lng=s[0].split(',')[0];
                var lat=s[0].split(',')[1];
                $("#lng").val(lng);
                $("#lat").val(lat);
                // console.log("lng:"+lng+"\n"+"lat:"+lat);
                //设置中心点和缩放级别
                map.centerAndZoom(new BMap.Point(lng,lat), 15);

                // map.disableInertialDragging();//禁用地图惯性拖拽
                map.enableDragging();//开启地图惯性拖拽
                var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
                var bottom_left_Scale = new BMap.ScaleControl();
                map.addControl(top_left_navigation);
                map.addControl(bottom_left_Scale);
                // addPoint(lng,lat,contextPath+'/reSources/images/map/location-sign.png',23,25,city+"市"+community_name,$("*[name='address']")[0].innerHTML);
                //mapSearch(type, mPoint, range);
            }
        }
    };
    var local = new BMap.LocalSearch(map, options);
//        var city = $(".homePage-area a")[0].innerHTML;
//        var community_name=$("#community_name").html();
    local.search(address);
}

/**添加点对象
 * 参数 ：地图
 *      经度
 *      纬度
 *      图例的路径
 *      图例宽度
 *      图例高度
 *      标注名称  传空字符串时 不添加标注
 *
 *      return  marker
 * */
function addPoint(lon, lat, iconStr, iconWidth, iconHeight, name,address) {
    var point = new BMap.Point(lon, lat);
    var icon = new BMap.Icon(iconStr, new BMap.Size(iconWidth, iconHeight));
    var marker = new BMap.Marker(point, {
        icon: icon
    });
    map.addOverlay(marker);
    if (name == null || name == "") {
        name = '';
    }

    var labelLen = getLabelOffset(name);
    //标注水平偏移量
    var offsetX = (labelLen - marker.getIcon().size.width) / -2;
    //标注垂直偏移量
    var offsetY = marker.getIcon().size.height;
    var label = new BMap.Label('', {offset: new BMap.Size(offsetX, offsetY)});
    label.setStyle({
        color: "black",
        fontSize: "10px",
        width: labelLen + "px",
        display: "inline-block",
        overflow: "hidden",
        height:"auto",
        border: "0px",
        backgroundColor: "0.05",
    });
    marker.setLabel(label);
    //点击事件
    var sContent =
        "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>"+name+"</h4>" +
        "<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>"+address+"</p>" +
        "</div>";
    var infoWindow = new BMap.InfoWindow(sContent);
    //图元点击事件
    addEvent(marker, "click", function () {
        this.openInfoWindow(infoWindow);
    });
    return marker;
}
/**添加监听*/
function addEvent(object, eventStr, eventFunc) {
    object.addEventListener(eventStr, eventFunc);
}
/**计算标注的长度 每个汉字长度为11  每个应为字符长度为6*/
function getLabelOffset(name) {
    var re = /[\u4E00-\u9FA5]/g;
    var totalLen = name.length;
    var chineseLen = 0;
    if (name.match(re) != null) {
        chineseLen = name.match(re).length;
    }
    var englishLen = name.length - chineseLen;
    return (chineseLen * 11 + englishLen * 6);
}
/**
 * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换
 * 即 百度 转 谷歌、高德
 * @param bd_lon
 * @param bd_lat
 * @returns {*[]}
 */
function DbToGc(bd_lon, bd_lat) {
    var x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    var x = bd_lon - 0.0065;
    var y = bd_lat - 0.006;
    var z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
    var theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
    var gg_lng = z * Math.cos(theta);
    var gg_lat = z * Math.sin(theta);
    return [gg_lng, gg_lat]
}

/**
 * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换
 * 即谷歌、高德 转 百度
 * @param lng
 * @param lat
 * @returns {*[]}
 */
function gcToDb(lng, lat) {
    var z = Math.sqrt(lng * lng + lat * lat) + 0.00002 * Math.sin(lat * piObj.x_PI);
    var theta = Math.atan2(lat, lng) + 0.000003 * Math.cos(lng * piObj.x_PI);
    var bd_lng = z * Math.cos(theta) + 0.0065;
    var bd_lat = z * Math.sin(theta) + 0.006;
    return [bd_lng, bd_lat]
}