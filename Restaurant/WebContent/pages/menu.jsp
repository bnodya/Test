<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="mainMenu" class="grid_16">
      <ul>
        <li><a href="index" class="Active">Home</a></li>
        <li><a href="product_overview">Food &amp; Drink</a></li>
        <li><a href="checkout">Order &amp; Delivery</a></li>
        <c:choose>
          <c:when  test="${not empty loggedUser}">
          	<c:if test="${loggedUser.access == '1'}">
        		<li><a href="users">Users</a></li>
        		 <li><a href="orders">Orders</a></li>
        	</c:if>
        </c:when>
        </c:choose>
       
        
      </ul>
    </div>