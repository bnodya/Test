<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	<c:choose>
      <c:when  test="${not empty loggedUser}">
        <h3 class="login"><span class="hiUser"><c:out value="Hi, ${loggedUser.login}"></c:out> |</span> <span class="myAccount"><a href="#">My Account</a></span> <a href="logout">Logout</a></h3>
    	<p>Subtotal: $ 00.00</p>
        <p><span class="vChart"><a href="cart">View Cart</a></span> <span class="cOut"><a href="checkout">Checkout</a></span></p>
       </c:when>
       <c:otherwise>
        <h3 class="login"><a href="login">Sign up</a> / <a href="login">Login</a></h3>
        </c:otherwise>
       </c:choose>