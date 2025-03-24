<%-- 
    Document   : Home
    Created on : Mar 8, 2025, 4:02:41 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,model.Product" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <%
    Vector<Product> list= (Vector<Product>)request.getAttribute("data1");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <jsp:include page="layout/Menu.jsp"></jsp:include>
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="">Home</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${data2}" var="o">
                                <li class="list-group-item text-white"><a href="CategoryURL?service=getID&cID=${o.categoryID}">${o.categoryName}</a></li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">New product</div>
                        <div class="card-body">
                            <img class="img-fluid" src="${p.image}" />
                            <h5 class="card-title" style="text-align: center">${p.productName}</h5>
<!--                            <p class="card-text"></p>-->
                            <p class="bloc_left_price">${p.price} $</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-9" >
                        <div style="text-align: center"><h2>Product</h2></div>
<div class="row">
    <% for (Product product : list) {%>
    <div class="col-12 col-md-6 col-lg-4" style="margin: 5px -5px">
        <div class="card" style="border: black solid 1px">
            <img class="card-img-top" src="<%=product.getImage()%>" alt="Card image cap" style="height: 250px; width: 90%">
            <div class="card-body">
                <h4 class="card-title show_txt" style="color: black;">
                    <a href="detail?pID=<%=product.getProductID()%>" title="View Product"><%=product.getProductName()%></a>
                </h4>
                <p class="card-text show_txt"></p>
                <div class="row">
                    <div class="col">
                        <p class="btn btn-danger btn-block" style="border: black solid 1px;background-color: #999">
                            <fmt:formatNumber pattern="##.#" value="<%=product.getPrice()%>"/> $
                        </p>
                    </div>
                    <div class="col">
                        <c:choose>
                            <c:when test="${not empty sessionScope.user}">
                                <a href="cart?service=add2Cart&pID=<%=product.getProductID()%>" class="btn btn-success btn-block">Add to cart</a>
                                                                <%if(product.getQuantity()==0){%>
                                <a class="btn btn-success btn-block"  style="color: white">Hết Hàng</a>
                                 <%}%>
                            </c:when>
                            <c:otherwise>
                                <a href="Login1.jsp" class="btn btn-success btn-block">Add to cart</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>
</div>
                </div>

            </div>
        </div>
                <jsp:include page="layout/footer.jsp"></jsp:include>

    </body>
</html>
