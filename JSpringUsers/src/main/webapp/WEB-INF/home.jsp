<%-- 
    Document   : home
    Created on : Apr 10, 2020, 3:34:07 PM
    Author     : zia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSpring : User Information</title>
        <link rel="stylesheet" href="https://bootswatch.com/3/cerulean/bootstrap.min.css" />
    </head>

    <body>
        <!-- Main Table Area -->

        <div class="row" style="padding:50px">
            <div class="col-lg-12">
                <a href="home.htm" value="Home" class="btn btn-primary btn-xs">Home</a>
                <a href="useradd.htm" value="Home" class=" btn btn-success btn-xs">Register</a>
                <div class="page-header">
                    <h3 id="tables">User Information</h3>
                    <c:if test="${not empty map.pass}">
                        <div class="alert alert-success" role="alert">
                            ${map.pass}
                        </div>
                    </c:if>
                    <c:if test="${not empty map.fail}">
                        <div class="alert alert-danger" role="alert">
                            ${map.fail}
                        </div>
                    </c:if>
                </div>

                <div class="bs-component">
                    <table class="table table-striped table-hover" style="width:auto">
                        <!-- Header -->
                        <thead class="thead-dark">
                            <tr class="info">
                                <td scope="col" style="font-weight: bold">ID</td>
                                <td scope="col" style="font-weight: bold">User Name</td>
                                <td scope="col" style="font-weight: bold">Password</td>
                                <td scope="col" style="font-weight: bold">Email</td>
                                <td scope="col" style="font-weight: bold">Phone #</td>
                                <td scope="col" style="font-weight: bold">Description</td>
                                <td scope="col" style="font-weight: bold">Active</td>
                                <td scope="col" style="font-weight: bold">Update</td>
                                <td scope="col" style="font-weight: bold">Delete</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty map.all}">
                                <c:forEach items="${map.all}" var="user">
                                    <tr>
                                        <td>${user.user_id}</td>
                                        <td>${user.user_name}</td>
                                        <td>${user.user_password}</td>
                                        <td>${user.email_address}</td>
                                        <td>${user.phone_num}</td>
                                        <td>${user.description}</td>
                                        <td>${user.is_enabled}</td>

                                        <td>
                                            <!-- Update -->
        <!--                                <a href="userupd.htm?id=${user.user_id}">
                                            <input type="button" value="Update" class="btn btn-warning" />
                                        </a>-->
                                            <form action="userupd.htm" method="GET">
                                                <input type="hidden" name="id" value="${user.user_id}" />
                                                <input type="submit" value="Update" class="btn btn-warning btn-xs" />
                                            </form>
                                        </td>
                                        <td>
                                            <!-- Delete -->
            <!--                                <a href="userdel.htm?id=${user.user_id}">
                                                <input type="button" value="Delete" class="btn btn-danger" />
                                            </a>-->
                                            <form action="userdel.htm" method="POST">
                                                <input type="hidden" name="id" value="${user.user_id}" />
                                                <input type="submit" value="Delete" class="btn btn-danger btn-xs" />
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div><!-- /example -->
            </div>            
        </div>
    </body>
</html>
