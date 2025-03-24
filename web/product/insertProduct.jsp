<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Add New Product</h1>
    <form action="ProductURL" method="POST">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required><br><br>

        <label for="image">Image URL:</label>
        <input type="text" id="image" name="image" required><br><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required><br><br>

        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br><br>

        <label for="categoryID">Category:</label>
        <select id="categoryID" name="categoryID" required>
            <c:forEach var="category" items="${vector}">
                <option value="${category.categoryID}">${category.categoryName}</option>
            </c:forEach>
        </select><br><br>

        <label for="importDate">Import Date:</label>
        <input type="date" id="importDate" name="importDate" required><br><br>

        <label for="usingDate">Using Date:</label>
        <input type="date" id="usingDate" name="usingDate" required><br><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="1">Active</option>
            <option value="0">Inactive</option>
        </select><br><br>
        <input type="hidden" name="service" value="addProduct">
        <input type="submit" name="submit" value="Add Product">
    </form>
</body>
</html>
