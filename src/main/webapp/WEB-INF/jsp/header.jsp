<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
    <title>Food Truck</title>
   <link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
  <%--  <link href="<%=request.getContextPath()%>/main.css" rel="stylesheet" type="text/css" /> --%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/main.css">
    <style>
        body {font-family: 'Jura';font-size: 22px;}
        h1 {border-bottom: 1px solid darkgoldenrod;}

    </style>
</head>
<body>
    <div class="container text-center">
        <h1>Dave's Donuts</h1>
    </div>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div id="navbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/menu/read/all">Home</a></li>
                <li><a href="/all">Donuts</a></li>
                <li><a href="/cart/read/all">Shopping Cart</a></li>
                <li><a href="/menu/read/2">About</a></li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>