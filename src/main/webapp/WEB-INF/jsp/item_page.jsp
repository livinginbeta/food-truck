<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ page import="com.casestudy.foodtruck.model.CartItem" %>
<%@ page import="com.casestudy.foodtruck.service.CartItemService" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <title>Donut Details</title>
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
        <div class="col-sm-4">
            <div class="panel panel-primary"><p></p>
                <div class="panel-heading">${item.name}<br>
                </div>
                <div class="panel-body">
                    ${item.description}<br>
                    <fmt:setLocale value="en_US"/>
                    <fmt:formatNumber value="${item.price}" type="currency"/> each<br>
                </div>
                <div class="panel-footer">
                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/all/#${item.itemId}'">Back To Donut List
                    </button>
                    <span> &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>
                    <!--------------------------------------------------------->
                    <span> &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>

                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/removefromcart/${item.itemId}'">&nbsp;-&nbsp;
                    </button>

                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/addtocart/${item.itemId}'">&nbsp;+&nbsp;
                    </button>

                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/clearcart/${item.itemId}'">Clear
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="images">
    <img src="${pageContext.request.contextPath}/images/donuts/${item.itemId}.png" width="300"
         height="300"/>
    <img src="${pageContext.request.contextPath}/images/nutrition/${item.itemId}.png" width="300"
         height="300"/>
</div>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<%@include file="footer.jsp" %>
</body>
</html>