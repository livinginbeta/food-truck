<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
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

                <div class="panel-heading"><h1>About</h1>
                </div>
                <div class="panel-body">
                    Dave comes from a long line of donut makers and he is excited to bring his family's recipes to the
                    public.
                    Consumers have only known donuts as the over-processed and uninspired product of factories and
                    assembly lines.
                    But now, he is delivering generations-worth of donut-making experience and experimentation to you!

                    <p>Founded in 2016, Dave's Donuts has been satisfying and delighting customers with an all-natural
                        approarch
                        and a creative reimagining of traditional baked goods.
                    </p>

                    <p>Trained as a pâtissier at the CIA -- the Culinary Institute of America -- Dave went on to
                        apprentice with
                        several world-renown chefs before deciding to strike out on his own in a converted RV to bring
                        joy
                        to others through handmade desserts. </p>

                    <p>Dave still thinks he has the best job in the world and has no plans to slow down. he is looking
                        to expand his
                        business and continue to serve this area for years to come.</p>

                </div>
            </div>
        </div>
    </div>
</div>

<div class="panel-footer">
    <%@include file="footer.jsp" %>
</div>
</body>
</html>