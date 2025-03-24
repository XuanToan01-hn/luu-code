<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
</head>

<body class="app sidebar-mini rtl">
    
    <!-- Navbar-->
    <header class="app-header">
        <!-- Sidebar toggle button-->
        <a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
        <!-- Navbar Right Menu-->
        <ul class="app-nav">
            <!-- User Menu-->
        </ul>
    </header>

    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
        <div class="app-sidebar__user">
            <img class="app-sidebar__user-avatar" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS9WDX7JlmoXx1-KXqPeJAwiS0xWGDmjBEWw&s" width="50px" alt="User Image">
            <div>
                <p class="app-sidebar__user-name"><b>Admin</b></p>
                <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
            </div>
        </div>
        <hr>
        <ul class="app-menu">
            <li><a class="app-menu__item" href="dashboard"><i class='app-menu__icon bx bx-tachometer'></i><span
                        class="app-menu__label">Bảng điều khiển</span></a></li>
            <li><a class="app-menu__item" href="UserURL"><i class='app-menu__icon bx bx-user-voice'></i><span
                        class="app-menu__label">Quản lý tài khoản</span></a></li>
            <li><a class="app-menu__item" href="ProductURL"><i class='app-menu__icon bx bx-purchase-tag-alt'></i><span
                        class="app-menu__label">Quản lý sản phẩm</span></a></li>
            <li><a class="app-menu__item" href="ProductURL"><i class='app-menu__icon bx bx-task'></i><span
                        class="app-menu__label">Quản lý đơn hàng</span></a></li>
            <li><a class="app-menu__item" href="https://docs.google.com/spreadsheets/d/1elWy0LYj9ngbmywMGwy8Noe_K7WmyisQ6aHOK6RnXZI" target="_blank"><i class='app-menu__icon bx bx-task'></i><span
                        class="app-menu__label">Kiểm tra phản hồi</span></a></li>
        </ul>
<li><a class="app-nav__item" href="logout" style="color: white;"><i class='bx bx-log-out bx-rotate-180'></i> Đăng xuất</a></li>
    </aside>
    <main class="app-content">
        <div class="row">
            <div class="col-md-12">
                <div class="app-title">
                    <ul class="app-breadcrumb breadcrumb">
                        <li class="breadcrumb-item"><a href="#"><b>Bảng điều khiển</b></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row" >
            <div class="col-md-12 col-lg-12">
                <div class="row">
                    <!-- col-6 -->
                    <div class="col-md-6">
                        <div class="widget-small primary">
                            <i class='icon bx bxs-user-account'></i>
                            <div class="info">
                                <h4>Tổng khách hàng:</h4>
                                <p><b>${cnt} khách hàng</b></p>
                            </div>
                        </div>
                    </div>
                    <!-- col-6 -->
                    <div class="col-md-6">
                        <div class="widget-small info">
                            <i class='icon bx bxs-data'></i>
                            <div class="info">
                                <h4>Tổng sản phẩm</h4>
                                <p><b>${cnt2} sản phẩm</b></p>
                            </div>
                        </div>
                    </div>
                    <!-- col-6 -->
                    <div class="col-md-6">
                        <div class="widget-small warning">
                            <i class='icon bx bxs-shopping-bags'></i>
                            <div class="info">
                                <h4>Tổng đơn hàng</h4>
                                <p><b>30 đơn hàng</b></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>
</body>

</html>
