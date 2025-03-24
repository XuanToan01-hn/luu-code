
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,model.Cart" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <% 
       Vector<Cart> list= (Vector<Cart>)request.getAttribute("data");
       String PageTitle=(String)request.getAttribute("PageTitle");
       String tableTitle=(String)request.getAttribute("tableTitle");
       String productName =request.getParameter("productName");
       if(productName==null){
        productName ="";
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=PageTitle%></title>
        <link rel="stylesheet" type="text/css" href="Cart/cssCart.css"> 
    </head>
    <body>
        <table>
            <thead>
            <caption><h1>List of Product</h1></caption>
                <tr>
                    <th>productID</th>
                    <th>productName</th>
                    <th>price</th>
                    <th>quantity</th>
                    <th>subTotal</th>
                    <th>remove</th>
                </tr>
            </thead>
            <tbody>
                <% double total = 0;
                    for (Cart cart : list) {
                        total += cart.getQuantity() * cart.getPrice();
                %>
                <tr>
                    <td><%=cart.getProductID()%></td>
                    <td><%=cart.getProductName()%></td>
                    <td><%=cart.getPrice()%></td>
                    <td>
                        <a href="cart?service=decreaseQuantity&pID=<%=cart.getProductID()%>" style="text-decoration: none;">-</a>
                        <%=cart.getQuantity()%>
                        <a href="cart?service=increaseQuantity&pID=<%=cart.getProductID()%>">+</a>
                    </td>
                    <td><%=cart.getQuantity() * cart.getPrice()%></td>
                    <td><a href="cart?service=removeItem&pID=<%=cart.getProductID()%>">Remove</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <p class="total">Grand Total: <%=total%></p>
        <div class="actions">
            <a href="ServletCart?service=removeAll">Remove All</a>
            <a href="Home">Continue Shopping</a>
            <a href="cart?service=confirm" class="confirm-purchase">Check Out</a>
        </div>
    </body>
</html>
