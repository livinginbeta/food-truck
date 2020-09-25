<%@ page import="com.casestudy.foodtruck.repository.CartItemRepository" %>
<%@ page import="com.casestudy.foodtruck.service.CartItemService" %>
<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <title>Shopping Cart</title>
    <link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/stylesheets/main.css">
    <style>
        body {
            font-family: 'Jura';
            font-size: 22px;
        }
        h1 {
            border-bottom: 1px solid darkgoldenrod;
        }
    </style>
</head>
<body>
<%! CartItemRepository cartItemRepository; %>

<div class="container">
    <div class="row">



        <table>
          <c:forEach items="${cartItems}" var="cartItem">
              <tr>

                  <td>${cartItem.item.name}</td>
                  <td>${cartItem.quantity}</td>
                  <td> X </td>

                  <td><fmt:formatNumber value="${cartItem.item.price}" type="currency"/></td>
                  <td> = </td>
                  <td> <fmt:formatNumber value="${cartItem.item.price * cartItem.quantity}" type="currency"/></td>
                  <td><button type="button" class="btn btn-primary btn-md"
                              onClick="location.href='/removefromcart/id/${item.itemId}'">&nbsp;-&nbsp;</button>

                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                      <button type="button" class="btn btn-primary btn-md"
                              onClick="location.href='/addtocart/id/${item.itemId}'">&nbsp;+&nbsp;</button>

                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                      <button type="button" class="btn btn-primary btn-md"
                              onClick="location.href='/clearcart/id/${item.itemId}'">Clear</button></td>
              </tr>

          </c:forEach>
        </table>


        <p>
        </p>
        <p>
        </p>
        <p>
        </p>
        <h1></h1>
        <%--! Double total = cartItemRepository.count() * 1.00; --%>

        <h2>Total:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatNumber value="${cartItemRepository.count() * 1.00}" type="currency"/></h2>




<%--

        <c:set var="count" value="0" scope="page" />



        <c:forEach items="${items}" var="item">  <!----------------------------->
        <div class="col-sm-4">
            <div class="panel panel-primary"><p></p>
                <div class="panel-heading"><strong>${item.name}</strong><br></div>
                <div class="panel-body">
                        ${item.description}<br>
                    <fmt:setLocale value="en_US"/>
                    <fmt:formatNumber value="${item.price}" type="currency"/> each<br>
                </div>
                <div class="panel-footer">
                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/${item.itemId}' ">Details
                    </button>
                    <span> &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>
                    <!--------------------------------------------------------->
                    <span> &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>
                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/removefromcart/id/${item.itemId}'">&nbsp;-&nbsp;</button>

                    <c:forEach items="${cartItems}" var="cartItem" begin="${count}" end="${count}">


                        ${cartItem.getQuantity()} in cart


                        <button type="button" class="btn btn-primary btn-md"
                                onClick="location.href='/removefromcart/id/${item.itemId}'">&nbsp;-&nbsp;</button>

                        <c:set var="count" value="${count + 1}" scope="page" />
                    </c:forEach><button type="button" class="btn btn-primary btn-md"
                                        onClick="location.href='/addtocart/id/${item.itemId}'">&nbsp;+&nbsp;</button>

                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/clearcart/id/${item.itemId}'">Clear</button>
                    </c:forEach>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>








<%--
<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>


<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="com.casestudy.foodtruck.service.CartItemService"%>
<%@page import="com.casestudy.foodtruck.repository.CartItemRepository"%>
<%@page import="com.casestudy.foodtruck.model.Cart"%>
<%@page import="com.casestudy.foodtruck.service.CartService"%>
<%@page import="com.casestudy.foodtruck.repository.CartRepository"%>
<%@page import="com.casestudy.foodtruck.model.CartItem"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <title>Shopping Cart</title>
    <link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/stylesheets/main.css">
    <style>
        body {
            font-family: 'Jura';
            font-size: 22px;
        }

        h1 {
            border-bottom: 1px solid darkgoldenrod;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">

        <c:forEach items="${cartItems}" var="cartItem">
            <tr>
                <td>"ITEM"${cartItem.item}</td><br>
                <td>"NAME"${cartItem.item.name}</td><br>
                <td>"ITEMID"${cartItem.item.itemId}</td><br>
                <td>"PRICE"${cartItem.item.price}</td><br>
                <td>"DESCRIPTION"${cartItem.item.description}</td><br>
                <td>"QUANTITY"${cartItem.quantity}</td><br>
            </tr>
        </c:forEach>

        <%!CartService cartItems;%>
        <%=cartItems.readAll()%>

        <c:forEach items="${cartItems}" var="cartItem">  <!------------------------>
        <div class="col-sm-4">
            <div class="panel panel-primary"><p></p>
                <div class="panel-heading"><strong>${item.name}</strong><br></div>
                <div class="panel-body">
                        ${item.description}<br>
                    <fmt:setLocale value="en_US"/>
                    <fmt:formatNumber value="${item.price}" type="currency"/> each<br>

                </div>
                <div class="panel-footer">
                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/${item.itemId}' ">Details
                    </button>
                </div>
                </c:forEach>  --%>
            </div>
        </div>
    </div>
</div>
</body>
</html>  