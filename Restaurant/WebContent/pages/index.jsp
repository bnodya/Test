<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="styles/960.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="styles/style.css" />
<link rel="stylesheet" type="text/css" media="all" href="themes/brown/style.css" />
<script type="text/javascript" src="scripts/jquery-1.4.2.js"></script>
<script type="text/javascript" src="scripts/jquery.tools.min.js"></script>
<script type="text/javascript" src="scripts/dapur.js"></script>

<link rel="stylesheet" type="text/css" media="all" href="../styles/960.css" />
<link rel="stylesheet" type="text/css" media="all" href="../styles/reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="../styles/text.css" />
<link rel="stylesheet" type="text/css" media="all" href="../styles/style.css" />
<link rel="stylesheet" type="text/css" media="all" href="../themes/brown/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../scripts/jquery.tools.min.js"></script>
<script type="text/javascript" src="../scripts/dapur.js"></script>
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
    <div class="products grid_16">
      <div class="productsWarp">
        <ul>
        <c:forEach var="item" items="${itemList}"> 
          <li><a href="product_overview"><img src="${item.picture}" alt="" width="938" height="398" /></a></li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <div class="productThumb grid_10 prefix_3 suffix_3">
      <ul>
        <li class="grid_2 alpha"><a href="#"><img src="${itemList[0].picture}" alt="" width="100" height="60" /></a></li>
        <li class="grid_2 "><a href="#"><img src="${itemList[1].picture}" alt="" width="100" height="60" /></a></li>
        <li class="grid_2"><a href="#"><img src="${itemList[2].picture}" alt="" width="100" height="60" /></a></li>
        <li class="grid_2"><a href="#"><img src="${itemList[3].picture}" alt="" width="100" height="60" /></a></li>
        <li class="grid_2 omega"><a href="#"><img src="${itemList[5].picture}" alt="" width="100" height="60" /></a></li>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>

<div id="richContent">
  <div class="container_16">
    <div class="popularCakes grid_4">
      <h4>Popular Cakes</h4>
      <ul>
        <li><a href="#">Ultimate Choco Brownie</a></li>
        <li><a href="#">Mokakokoa Brownie</a></li>
        <li><a href="#">CoffeeBrown</a></li>
        <li><a href="#">Delicacheese</a></li>
        <li><a href="#">Berries Cheesecake</a></li>
      </ul>
    </div>
    <div class="recommended grid_4">
      <h4>Recommended</h4>
      <ul>
        <li><a href="#">Ultimate Choco Brownie</a></li>
        <li><a href="#">Mokakokoa Brownie</a></li>
        <li><a href="#">CoffeeBrown</a></li>
        <li><a href="#">Delicacheese</a></li>
        <li><a href="#">Berries Cheesecake</a></li>
      </ul>
    </div>
    <div class="specialOffer grid_4">
      <h4>Special Offer</h4>
      <ul>
        <li><a href="#">Ultimate Choco Brownie</a></li>
        <li><a href="#">Mokakokoa Brownie</a></li>
        <li><a href="#">CoffeeBrown</a></li>
        <li><a href="#">Delicacheese</a></li>
        <li><a href="#">Berries Cheesecake</a></li>
      </ul>
    </div>
    <div class="orderPhone grid_4">
      <h4><em>Order by Phone</em> <span>987-654-321</span></h4>
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