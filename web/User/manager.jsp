

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
            .container12{
                max-width: 100%;
                width: 100%;
            }
        </style>
    <body>
        <div class="container12">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
    <h2><a href="fill" style="color: whitesmoke; font-weight: bold;">Back</a></h2>
                            <h3><b>Manage User</b></h3>
                        </div>
                        <div class="col-sm-6">
                            <a href="UserURL?service=addUser""  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New User</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Password</th>
                            <th>Role ID</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Active</th>
                            <th>Update</th>
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${o.userID}</td>
                                <td>${o.fullName}</td>
                                <td>***************</td>
                                <td>${o.roleID}</td>

                                <td>${o.address}</td>
                                <td>${o.phone}</td>
                                <td>${o.email}</td>
                                <td>${o.activate}</td>


                                <td>
                                    <a href="UserURL?service=updateUser&pID=${o.userID}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Update">&#xE254;</i></a>
                                </td>
                                <td><a href="UserURL?service=deleteUser&pID=${o.userID}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script src="js/manager.js" type="text/javascript"></script>
        <script>
               
        </script>
    </body>
</html>
