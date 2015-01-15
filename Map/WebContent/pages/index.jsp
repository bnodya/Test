<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Map</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      html, body, #map-canvas {
        height: 300px;
        width: 500px;
        margin-left: auto;
        margin-right: auto;
        padding: 0px
      }
    </style>
    <script>
    
	function initialize() {
	   var directionsService = new google.maps.DirectionsService();
	     var directionsDisplay = new google.maps.DirectionsRenderer();

	     var map = new google.maps.Map(document.getElementById('map-canvas'), {
	       zoom:7,
	       mapTypeId: google.maps.MapTypeId.ROADMAP
	     });

	     directionsDisplay.setMap(map);
	     

	     var request = {
	       origin: "${orig}", 
	       destination: "${dest}",
	       waypoints: [
	                   <c:forEach items="${list}" var="item">
		    		    {
		    		      location:"${item}",
		    		      stopover:true
		    		    },
		    		    </c:forEach>
		    		    ],
	       travelMode: google.maps.DirectionsTravelMode.WALKING
	     };

	     directionsService.route(request, function(response, status) {
	       if (status == google.maps.DirectionsStatus.OK) {
	         directionsDisplay.setDirections(response);
	       }
	     });
}

function loadScript() {
  var script = document.createElement('script');
  script.type = 'text/javascript';
  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&' +
      'callback=initialize';
  document.body.appendChild(script);
}

window.onload = loadScript;

    </script>
  </head>
  <body>
    <div id="map-canvas"></div>
  </body>
</html>