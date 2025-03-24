<%-- 
    Document   : Error
    Created on : Mar 20, 2025, 10:16:49 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Success</title>
        <link rel="stylesheet" href="style.css"> <!-- Link to external CSS -->
        <style>
            /* Global Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    text-align: center;
    margin: 0;
    padding: 0;
}

/* Centered Container */
.container {
    width: 50%;
    margin: 10% auto;
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

/* Header */
h1 {
    color: #28a745;
}

/* Paragraph */
p {
    font-size: 18px;
    color: #555;
}

/* Button Styling */
.btn {
    display: inline-block;
    padding: 10px 20px;
    margin-top: 15px;
    text-decoration: none;
    font-size: 18px;
    color: white;
    background: #007bff;
    border-radius: 5px;
    transition: 0.3s;
}

.btn:hover {
    background: #0056b3;
}

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Error</h1>
            <h2>You must be input number !</h2>
            <a href="ProductURL" class="btn">Back to manager</a>
        </div>
    </body>
</html>
