

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
    <form action="UserURL" method="POST">
        <label for="userID">User ID:</label>
        <input type="text" id="userID" name="userID" required><br><br>

        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required><br><br>

        <label for="password">Password:</label>
        <input type="text" id="password" name="password"required><br><br>

        <label for="roleID">Role:</label>
        <select id="roleID" name="roleID" required>
            <c:forEach var="r" items="${r}">
                <option value="${r.roleID}">${r.roleID}</option>
            </c:forEach>
        </select><br><br>

        <label for="address">Adress:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required><br><br>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br><br>
        
        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="1">Active</option>
            <option value="0">Inactive</option>
        </select><br><br>
        <input type="hidden" name="service" value="addUser">
        <input type="submit" name="submit" value="Add User">
    </form>
</body>
</html>
