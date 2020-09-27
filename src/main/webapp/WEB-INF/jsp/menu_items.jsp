<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <%@ include file="header.jsp" %>
    <title>Donuts List</title>
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

        <c:set var="count" value="0" scope="page"/>


        <c:forEach items="${items}" var="item">  <!----------------------------->

        <div class="col-sm-4">
            <div class="panel panel-primary"><p></p>
                <img src="${pageContext.request.contextPath}/images/donuts/${item.itemId}.png" class="preview" width="150"
                     height="150"/>
                <a name="${item.itemId}"></a>
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
                            onClick="location.href='/removefromcart/id/${item.itemId}'">&nbsp;-&nbsp;
                    </button>

                    <c:forEach items="${cartItems}" var="cartItem" begin="${count}" end="${count}"><!--->


                        ${cartItem.getQuantity()} in cart

                    <c:set var="count" value="${count + 1}" scope="page"/>
                    </c:forEach>

                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/addtocart/id/${item.itemId}'">&nbsp;+&nbsp;
                    </button>

                    <button type="button" class="btn btn-primary btn-md"
                            onClick="location.href='/clearcart/id/${item.itemId}'">Clear
                    </button>
                    </c:forEach>
                    <p></p>
                    <p></p>
                </div>

            </div>
        </div>
    </div>
</div>
<p></p>
<p></p>
<p></p>
<%@include file="footer.jsp"%>
</body>
</html>