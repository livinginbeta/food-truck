<%@ page import="com.casestudy.foodtruck.repository.CartItemRepository" %>
<%@ page import="com.casestudy.foodtruck.service.CartItemService" %>
<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">


<footer>
    <!-- footer of page begins here -->
    <div class="footer">
        &copy 2020 David Yirchott
        | <a href="http://localhost:8080/menu/read/all" alt="Homepage" Title="Homepage">Home</a>
        | <a href="http://localhost:8080/all" alt="Donuts" Title="Donuts">Donuts</a>
        | <a href="http://localhost:8080/checkout" alt="Shopping Cart" title="Shopping Cart">Shopping Cart</a>
        | <a href="http://localhost:8080/menu/read/2" alt="About" title="About">About</a>
    </div>
    <script type="text/javascript" src="./js/footer-functions.js"></script>
</footer> <!-- footer of page ends here -->