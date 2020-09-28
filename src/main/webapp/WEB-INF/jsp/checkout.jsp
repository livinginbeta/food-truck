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

    <div class=" row checkout-page">
        <div class="checkout-table">
            <table width="100%">


                <c:set var="total" scope="session" value="${0}"/>
                <c:forEach items="${cartItems}" var="cartItem">
                    <c:set var="subtotal" scope="session" value="${{cartItem.item.price * cartItem.quantity}}"/>

                    <c:set var="number" scope="session" value="${0}"/>
                    <c:if test="${cartItem.quantity==0}">
                        <c:set var="number" value="${number + 1}"/>
                    </c:if>
                    <c:if test="${number==7}">
                        <div class="empty"><c:out value="Your shopping cart is empty. Buy Donuts!"/></div>
                    </c:if>

                    <c:if test="${cartItem.quantity>0}">
                        <tr>
                            <td>${cartItem.item.name}</td>
                            <td>${cartItem.quantity}</td>
                            <td> X</td>
                            <td><fmt:formatNumber value="${cartItem.item.price}" type="currency"/></td>
                            <td> =</td>
                            <td><fmt:formatNumber value="${cartItem.item.price * cartItem.quantity}"
                                                  type="currency"/></td>
                            <td>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary btn-md"
                                        onClick="location.href='/removefromcart/sc/${cartItem.item.itemId}'">&nbsp;-&nbsp;
                                </button>
                                &nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary btn-md"
                                        onClick="location.href='/addtocart/sc/${cartItem.item.itemId}'">&nbsp;+&nbsp;
                                </button>
                                &nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary btn-md"
                                        onClick="location.href='/clearcart/sc/${cartItem.item.itemId}'">Clear
                                </button>
                            </td>
                        </tr>
                    </c:if>
                    <c:set var="total" value="${total + cartItem.quantity}"/>
                </c:forEach>
            </table>
        </div>


        <h1></h1>
        <table width="100%">
            <tr>
                <td width="60%" align="right" valign="top">
                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/all'">Back To Donut List
                    </button>
                    <p></p>
                    <h2><p>Total: <fmt:formatNumber value="${total}" type="currency"/></h2>
                </td>
                <td class="printButton">
                    <a href="davidyirchott.com"
                       onClick="window.print();return false;">
                        <img src="${pageContext.request.contextPath}/images/logo/print_on_white.png"
                             width="201px" height="141" alt="Print This Page" title="Print This Page"/></a>

                </td>
            </tr>
        </table>
    </div>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>