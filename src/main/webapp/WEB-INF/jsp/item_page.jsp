<%@ page import="com.casestudy.foodtruck.model.CartItem" %>
<%@ page import="com.casestudy.foodtruck.service.CartItemService" %>
<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <title>TEST</title>
    <link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/main.css">
    <style>
        body {font-family: 'Jura';font-size: 22px;}
        h1 {border-bottom: 1px solid darkgoldenrod;}
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary"><p></p>
                <div class="panel-heading"><strong>${item.name}</strong><br> </div>
                <div class="panel-body">
                    ${item.description}<br>
                    <fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${item.price}" type = "currency"/> each<br>

                </div>

                <%--<%! Long itemVariable = item.itemId %>
                <%=CartItemService.readById(itemVariable)%>   --%>

                <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
                                                   onClick="location.href='/addtocart/id/${item.itemId}'">Add To Cart</button></div>

                <div><button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/addtocart/${item.name}' ">Details</button> <!--<a href="CLICK HERE" /> -->
                </div>
    <!---------------------------------------------------------------------------------->
                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/cart/addtocart/${item.name}' ">LINK 1</button>

                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/cart/addtocart/id/${item.itemId}' ">LINK 2</button>

                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/addtocart/${item.name}' ">LINK 3</button>

                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/addtocart/${item.name}' ">LINK 4</button>

                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/addtocart/${item.name}' ">LINK 5</button>

                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/addtocart/${item.name}' ">LINK 6</button>

                <button type="button" class="btn btn-primary btn-md"
                        onClick="location.href='/addtocart/${item.name}' ">LINK 7</button>

            </div>
        </div>
    </div>
</div>
</body>
</html>