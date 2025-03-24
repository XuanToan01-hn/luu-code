<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Vector,model.Category,model.Product" %>
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
    <%
    Vector<Category> vector = (Vector<Category>)request.getAttribute("vector");
    Product p = (Product)request.getAttribute("p");
    String err= (String)request.getAttribute("err");
        String err1= (String)request.getAttribute("errP");
    if(err1==null) err1="";
    if(err==null) err="";
    %>
<body>
    <h1>Add New Product</h1>
    <h3><b><%=err%></b></h3>
    <form action="ProductURL" method="POST">
                <label for="productName">Product ID:</label>
                <input type="text"  name="productID" required value="<%=p.getProductID()%>" readonly=""><br><br>
        
        <label for="productName">Product Name:</label>
        <input type="text"  name="productName" required value="<%=p.getProductName()%>"><br><br>

        <label for="image">Image :</label>
        <input type="text" value="<%=p.getImage()%>"id="image" name="image" required><br><br>

        <label>Price: <%=err%></label>
        <input type="text"  name="price" value="<%=p.getPrice()%>"  required><br><br>
<!--        <input type="number" id="price" name="price" step="0.01" required><br><br>-->

        <label for="quantity">Quantity:</label>
        <input type="number" name="quantity" value="<%=p.getQuantity()%>" required><br><br>

        <label for="categoryID">Category:</label>
        <select name="categoryID">
                            <%if(vector!=null){        
                                        for (Category c : vector) {%>
                                        <option value="<%=c.getCategoryID()%>"
                                                <%=c.getCategoryID().equals(p.getCategoryID())?"selected":""
                                                
                                                %>>
                                            
                                            <%=c.getCategoryName()%></option>
            <%}
                    }else{%>
                       <option value="">No Category</option>

<%}%>
                            
                        </select><br><br>

        <label for="importDate">Import Date:</label>
        <input type="date" value="<%=p.getImportDate()%>" name="importDate" required><br><br>

        <label for="usingDate">Using Date:</label>
        <input type="date" value="<%=p.getUsingDate()%>" name="usingDate" required><br><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="1" <%=p.getStatus()==1?"checked":""%>>Active</option>
            <option value="0"<%=p.getStatus()==0?"checked":""%>>Inactive</option>
        </select><br><br>
        <input type="hidden" name="service" value="updateProduct">

        <input type="submit" name="submit" value="Update Product">
    </form>
</body>
</html>

