<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>DapurKue | Product Overview</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="styles/960.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/style.css" />
<link rel="stylesheet" type="text/css" media="all" href="themes/brown/style.css" />
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
        <h3>Taste it!</h3>
      </div>
     
    </div>
    <div class="bodyContent grid_16">
      <div class="products grid_16 alpha">
        <div class="prodMenu">
          <h4>Food </h4>
         
	          <c:forEach var="item" items="${itemList}">
	           <c:choose>
	           <c:when test="${!item.type}">
	          	<div class="menu grid_4 alpha">
	            <p><a href="product_details" class="grid_4 alpha"><img src="${item.picture}" alt="" width="220" height="120" /></a><br />
	              ${item.description}</p>
	         	 </div>
	         	 </c:when>
	      		</c:choose>
	          </c:forEach>
        </div>
        <div class="prodMenu">
          <h4>Drink </h4>
          <c:forEach var="item" items="${itemList}">
	           <c:choose>
	           <c:when test="${item.type}">
          <div class="menu grid_4">
            <p><a href="product_details" class="grid_4 alpha"><img src="${item.picture}" alt="" width="220" height="120" /></a><br />
              ${item.description}</p>
          </div>
           </c:when>
	      		</c:choose>
	          </c:forEach>
         
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<div id="richContent2">
  <div class="container_16">
    <div class="fromBlog grid_4">
      <h4>From the blog</h4>
      <h5>New Recipes in Our Basket</h5>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. vivamus tempor justo sit amet metus cursus consequat. Nulla viverra, felis vel accumsan fermentum... <a href="#" class="bookMan">more &raquo;</a></p>
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
        <li><a href="#">Delivery Terms &amp;amp Pricing</a></li>
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