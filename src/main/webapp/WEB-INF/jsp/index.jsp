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
    <title>Dave's Donuts</title>
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

                <div class="panel-heading"><h1>Welcome!</h1>
                </div>
                <div class="home-body">
                    Dave's Donuts is now mobile! Get your favorite artisan treats/breakfast food
                    around the city and at public events.
                    <p>Dave's determination to deliver delicious donuts and other delectable desserts
                        <img src="${pageContext.request.contextPath}/images/logo/rounded-square.png" class="small-img"/>to
                        discriminating
                        diners has not diminished despite driving distances daily to different destinations downtown!
                    </p>

                    <p>We are now able to directly interact with customers who wouldn't be able to get to
                        a more traditional location. Follow us on
                        <a href="http://facebook.com" target="_blank">Facebook</a>,
                        <a href="http://twitter.com" target="_blank">Twitter</a>,
                        and <a href="http://instagram.com" target="_blank">Instagram</a> to find
                        out where we will be next and what is on the menu for the day. if you have a
                        request, message us and we will try to add it to our offerings.</p>
                    <p>If you've never had a donut from Dave's, you owe it to yourself to try
                        some. We make every donut by hand on the day it is sold -- the same goes
                        for our icings, creams, custards, and jellies. We make your treats with the highest
                        standards: GMO-Free, ethically-raised, and, where possible, our ingredients are
                        locally-sourced. You can taste the difference.</p>
                    <p> Stop by and visit our truck today!</p>

                </div>
            </div>
        </div>
    </div>
</div>


<p></p>
<p></p>
<p></p>
<div class="panel-footer">
    <%@include file="footer.jsp" %>
</div>
</body>
</html>