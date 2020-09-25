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
    <p>    </p>
    <p>    </p>
    <p>    </p>
    <p>    </p>
    <p>    </p>
    <p>    </p>
    <p>    </p>
    <p>    </p>
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
                              onClick="location.href='/removefromcart/sc/${cartItem.item.itemId}'">&nbsp;-&nbsp;</button>

                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                      <button type="button" class="btn btn-primary btn-md"
                              onClick="location.href='/addtocart/sc/${cartItem.item.itemId}'">&nbsp;+&nbsp;</button>

                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                      <button type="button" class="btn btn-primary btn-md"
                              onClick="location.href='/clearcart/sc/${cartItem.item.itemId}'">Clear</button></td>
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



        </div>
    </div>
</div>
</body>
</html>