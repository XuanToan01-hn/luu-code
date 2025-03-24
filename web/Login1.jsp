

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Vector"%>
<%@page import="model.Role"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<script src="https://www.google.com/recaptcha/api.js" async defer></script> <!-- Thêm reCAPTCHA API -->
        <script src="https://accounts.google.com/gsi/client" async defer></script>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Form</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <style>
        /* Container chính */
#logreg-forms {
    width: 100%;
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Form ??ng nh?p */
.form-signin {
    margin-bottom: 20px;
}

.form-signin .form-control {
    margin-bottom: 15px;
}

/* Nút ??ng nh?p b?ng Google */
.btn-google {
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #db4437; /* Màu ?? c?a Google */
    color: white;
    border: none;
    padding: 10px;
    border-radius: 5px;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.btn-google:hover {
    background-color: #c23321; /* Màu ?? ??m khi hover */
}

.google-logo {
    width: 20px;
    height: 20px;
    margin-right: 10px;
}

.alert-danger {
    margin-top: 20px;
}
    </style>
        <div id="logreg-forms">
            <form class="form-signin" action="login" method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Sign in</h1>
                <input name="user" type="text" class="form-control" placeholder="Username" required autofocus>
                <input name="pass" type="password" class="form-control" placeholder="Password" required>

                <div class="g-recaptcha" data-sitekey="6Lf6lPMqAAAAAHKZ7Vyg0YQ5P0uK7NOQOnP2lGxd"></div>

                <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
            </form>
            <!-- Nút ??ng nh?p b?ng Google -->
            <form action="login1" method="get">
                        <div class="text-center my-3">
            <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:8080/PRJ301/login1&response_type=code&client_id=291258224328-44btoabl0iuk7bcac8m8b9c0vrihlg8m.apps.googleusercontent.com"
               class="btn btn-google btn-block">
                <span style="color: white">Sign in with Google</span>
            </a>
        </div>
            </form>



            <c:if test="${mess!=null}">
                <div class="alert alert-danger text-center">${mess}</div>
            </c:if>
        </div>
    </body>
</html>

