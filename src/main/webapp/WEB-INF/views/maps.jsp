<%@ include file="common/header.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=8t27t07vw7"></script>

<div id="map" style="width:100%;height:60%;"></div>

<script>
var mapOptions = {
    center: new naver.maps.LatLng(37.3284083987815, 126.9528475359754),
    zoom: 16
};

var map = new naver.maps.Map('map', mapOptions);

var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng(37.3284083987815, 126.9528475359754),
    map: map
});

naver.maps.Event.addListener(map, 'click', function(e) {
    marker.setPosition(e.latlng);
});
</script>

<%@include file="common/footer.jsp" %>