

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Orders, dal.OrderDAO" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Status</title>
    <link rel="stylesheet" type="text/css" href="Cart/cssCart.css"> 
</head>
<body>

<%
    int orderID = Integer.parseInt(request.getParameter("orderID"));
    OrderDAO orderDAO = new OrderDAO();
    Orders order = orderDAO.getOrderById(orderID);
%>
<h1>Order Confirmation</h1>
<p>Order ID: <%= order.getOrderID() %></p>
<p>Order Date: <%= order.getOrderDate() %></p>
<p>Total: <%= order.getTotal() %></p>
<p>Status: <%= order.getStatus() %></p>
    <form action="cart" method="post">
        <input type="hidden" name="service" value="confirmDelivery">
        <input type="hidden" name="orderID" value="<%= order.getOrderID() %>">
        <button type="submit">Confirm Delivery</button>
    </form>
</body>
</html>

