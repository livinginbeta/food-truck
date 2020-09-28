<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <!--  <title>Dave's Donuts</title>  -->
    <link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/sytlesheets/main.css">
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
<div class="container text-center" style="background-color: #f1b614">
    <!--  <h1>Dave's Donuts</h1> -->
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/images/logo/donutsLogo_updated.png" alt="Dave's Donuts logo"/>
    </div>
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div id="navbar">
                <ul class="nav navbar-nav">
                    <li><a href="/index">Home</a></li>
                    <li><a href="/all">Donuts</a></li>
                    <li><a href="/checkout">Shopping Cart</a></li>
                    <li><a href="/about">About</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>
</html>