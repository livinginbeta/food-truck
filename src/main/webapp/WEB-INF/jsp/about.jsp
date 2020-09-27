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


                <div class="panel-heading"><strong><h1>About</h1></strong>
                </div>
                <div class="panel-body">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean lorem magna, porta id sollicitudin at, tempus ac lacus. Sed condimentum hendrerit tellus a posuere.
                        Fusce eu neque eget elit gravida placerat. Aliquam laoreet porttitor tristique. Aliquam nec ultricies enim. Donec hendrerit nisi dolor, at laoreet ipsum consectetur
                        id. Cras id nunc rhoncus, rhoncus tortor lobortis, ullamcorper nunc. Vivamus et elit vitae dui ullamcorper mollis.
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean lorem magna, porta id sollicitudin at, tempus ac lacus. Sed condimentum hendrerit tellus a posuere.
                        Fusce eu neque eget elit gravida placerat. Aliquam laoreet porttitor tristique. Aliquam nec ultricies enim. Donec hendrerit nisi dolor, at laoreet ipsum consectetur id.
                        Cras id nunc rhoncus, rhoncus tortor lobortis, ullamcorper nunc. Vivamus et elit vitae dui ullamcorper mollis. </p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean lorem magna, porta id sollicitudin at, tempus ac lacus. Sed condimentum hendrerit tellus a posuere. Fusce
                        eu neque eget elit gravida placerat. Aliquam laoreet porttitor tristique. Aliquam nec ultricies enim. Donec hendrerit nisi dolor, at laoreet ipsum consectetur id. Cras
                        id nunc rhoncus, rhoncus tortor lobortis, ullamcorper nunc. Vivamus et elit vitae dui ullamcorper mollis. </p>
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean lorem magna, porta id sollicitudin at, tempus ac lacus. Sed condimentum hendrerit tellus a posuere. Fusce
                        eu neque eget elit gravida placerat. Aliquam laoreet porttitor tristique. Aliquam nec ultricies enim. Donec hendrerit nisi dolor, at laoreet ipsum consectetur id. Cras id
                        nunc rhoncus, rhoncus tortor lobortis, ullamcorper nunc. Vivamus et elit vitae dui ullamcorper mollis. </p>


                </div>
            </div>
        </div>
    </div>
</div>









<p></p>
<p></p>
<p></p>
<div class="panel-footer">
    <%@include file="footer.jsp"%>
</div>
</body>
</html>