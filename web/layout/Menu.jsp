<%-- 
    Document   : Menu
    Created on : Mar 11, 2025, 12:19:33 AM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            .container {
                max-width: 100% !important; /* Đảm bảo container rộng toàn bộ */
                width: 100%;
            }
            .jumbotron {
                width: 100%;
                padding: 50px 20px; /* Đảm bảo khoảng cách hợp lý */
                margin: 0;
            }
        </style>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark w-100">
            <div class="container">
                <a class="navbar-brand" href="Home">Pharmacy</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                    <!-- Menu chính giữa -->
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                        </li>
                    </ul>

                    <!-- Form tìm kiếm -->
                    <form action="SearchControl" method="post" class="form-inline ml-3" >
                        <input name="txt" type="text" class="form-control" placeholder="Search...">
                        <button type="submit" class="btn btn-secondary ml-2">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                     <c:choose>
                            <c:when test="${not empty sessionScope.username}">
                                <span class="navbar-text text-white ml-3">Welcome, ${sessionScope.username}!</span>
                                <a class="btn btn-outline-light btn-sm ml-2" href="logout">Logout</a>
                            </c:when>
                            <c:otherwise>
                                <a class="btn btn-outline-light btn-sm ml-3" href="Login1.jsp">Login</a>
                            </c:otherwise>
                        </c:choose>

                    <!-- Phần menu bên phải -->
        <div class="d-flex align-items-center ml-auto">
    <!-- Giỏ hàng (Sát lề phải) -->
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <a class="btn btn-success btn-sm" href="cart?service=showCart">
                <i class="fa fa-shopping-cart"></i> Cart <span class="badge badge-light"></span>
            </a>
        </c:when>
        <c:otherwise>
            <a class="btn btn-success btn-sm" href="Login1.jsp">
                <i class="fa fa-shopping-cart"></i> Cart <span class="badge badge-light"></span>
            </a>
        </c:otherwise>
    </c:choose>
</div>
                </div>
            </div>
        </nav>

        <section class="jumbotron text-center w-100">
            <div class="container">
                <h1 class="jumbotron-heading">Hiệu Thuốc siêu uy tín, chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phẩm dược phẩm chính hãng</p>
            </div>
        </section>
        <!--end of menu-->

        <!-- Bootstrap scripts -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

