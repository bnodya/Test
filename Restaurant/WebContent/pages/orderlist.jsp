<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>DapurKue | Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="styles/960.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/style.css" />
<link rel="stylesheet" type="text/css" media="all" href="themes/brown/style.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {                        // When the HTML DOM is ready loading, then execute the following function...
                $('#updatebutton').click(function() {               // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
                    $.post('orders', function(response) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                        $('stickySearch').text(response);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                    });
                });
            });
        </script>
</head>
<body>
<div id="warp">
  <div id="main" class="container_16">
    <div id="header" class="grid_16">
      <div id="logo" class="grid_4 alpha">
        <h1><a href="index">DapurKue</a></h1>
        <h2>Famously Delicious</h2>
      </div>
      <div id="headright" class="grid_7 prefix_5 omega">
       <jsp:include page="loginhead.jsp" ></jsp:include>
      </div>
    </div>
    
	<jsp:include page="menu.jsp" ></jsp:include>

    <div id="stickySearch" class="grid_16">
    </div>
    <div class="prodNav grid_16">
      <div class="prodHeadline grid_12 alpha">
        <h3>Orders</h3>
      </div>
    </div>
    
    <div class="bodyContent grid_16">
      <div class="shopCart grid_16 alpha">
        <div class="headCart grid_16 alpha">
          <div class="itemHead grid_1 alpha"> Id</div>
          <div class="priceHead grid_4"> Items</div>
          <div class="qtyHead grid_1"> User</div>
          <div class="subtotalHead grid_3"> Date</div>
          <div class="subtotalHead grid_3"> Price</div>
          <div class="subtotalHead grid_2"> Apply</div>
          <div class="remHead grid_2 omega"> Paid</div>
        </div>
        <c:forEach var="order" items="${orderList}">
        <form action="#" method="get">
          <div class="bodyCart grid_16 alpha">
            <div class="warpCart">
             <div class="subtotal grid_1 alpha">
                <p><c:out value="${order.id}"/></p>
              </div>
              <div class="subtotal grid_4">
                <p><c:out value="${order.userId}"/></p>
              </div>
              <div class="subtotal grid_1">
                <p><c:out value="${order.userId}"/></p>
              </div>
              <div class="subtotal grid_3">
                <p><c:out value="${order.date}"/></p>
              </div>
              <div class="subtotal grid_3">
                <p><c:out value="${order.price}"/></p>
              </div>
              <div class="subtotal grid_2">
               <c:choose>
               	 <c:when test="${order.applied}">
              		 <input type="checkbox" checked="checked" name="orderApply" value='apply'/>
               	</c:when>
              	 <c:otherwise>
              		 <input type="checkbox" name="orderApply" value='apply'/>
              	 </c:otherwise>
               </c:choose>
              </div>
              <div class="subtotal grid_2 omega">
              <c:choose>
             	 <c:when test="${order.paid}">
             		  <input type="checkbox" checked="checked" name="orderPay" value='pay'/>
              	 </c:when>
              	 <c:otherwise>
             	 	 <input type="checkbox" name="orderPay" value='pay'/>
               	</c:otherwise>
               </c:choose>
              </div>
            </div>
          </div>
       	<div class="buttonCart grid_16 alpha">
            <input type="button" id="updatebutton" name="update" class="update" value="${order.id}" />
            <div class="clear"></div>
          </div>
        </form>
      </c:forEach>
      </div>
    </div>
    
    
  </div>
  <div class="clear"></div>
</div>
<div id="richContent2">
  <div class="container_16">
    <div class="lastTweet grid_4">
      <h4>Latest Tweets</h4>
      <p><a href="#">@someone</a> yes indeed this is one hell of a free css template! <a href="#">Read More</a> <span><em>15 minutes ago</em></span></p>
      <p><a href="#">@someone</a> yes indeed this is one hell of a free css template! <a href="#">Read More</a> <span><em>15 minutes ago</em></span></p>
    </div>
    <div class="corporateInfo grid_4">
      <h4>Corporate Info</h4>
      <ul>
        <li><a href="#">Privacy Policy</a></li>
        <li><a href="#">Term &amp; Conditions</a></li>
        <li><a href="#">Franchise</a></li>
        <li><a href="#">About us</a></li>
        <li><a href="#">FAQ</a></li>
      </ul>
    </div>
    <div class="storeDelivery grid_4">
      <h4>Store &amp; Delivery</h4>
      <ul>
        <li><a href="#">Store Locator</a></li>
        <li><a href="#">Delivery Terms &amp; Pricing</a></li>
        <li><a href="#">Delivery Coverage</a></li>
        <li><a href="#">Gift Services</a></li>
        <li><a href="#">Track my order</a></li>
      </ul>
    </div>
    <div class="socialNet grid_4">
      <h4>Keep in touch</h4>
      <ul>
        <li><a href="#" class="facebook">Facebook</a></li>
        <li><a href="#" class="twitter">Twitter</a></li>
        <li><a href="#" class="feed">Feed</a></li>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
</div>
<div id="footer">
  <div class="container_16">
    <div class="copyright grid_16">
      <p class="left">Copyright &copy; 2010, Your Company Here, All Rights Reserved</p>
      <p class="right">Design by <a href="http://tokokoo.com/">Tokokoo</a> &amp; <a href="http://www.instantshift.com/">instantShift</a></p>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
</div>
</body>
</html>
