<%-- 
    Document   : index
    Created on : Apr 9, 2020, 10:55:19 PM
    Author     : zia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSpring : User Login </title>
        <link rel="stylesheet" href="https://bootswatch.com/3/cerulean/bootstrap.min.css" />
    </head>
    <body>
        <!-- Message Area -->
    <c:if test="${not empty map.pass}">
        <font color="GREEN">${map.pass}</font>
    </c:if>
    <c:if test="${not empty map.fail}">
        <font color="RED">${map.fail}</font>
    </c:if>
<!--        <h1>Hello World! ${first}</h1>-->

    <!-- Form style login -->    
    <div class="row">
        <div class="col-lg-6" style="padding: 50px">
            <div class="well bs-component">
                <form class="form-horizontal" action="login.htm" method="POST">
                    <fieldset>
                        <legend>User Login</legend>
                        <div class="form-group">
                            <label for="inputUsername" class="col-lg-2 control-label">User</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="inputEmail" placeholder="User Name" name="login">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                            <div class="col-lg-10">
                                <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="pass">
                                <!--<div class="checkbox">
                                    <label>
                                        <input type="checkbox"> as Administrator
                                    </label>
                                </div>-->
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="reset" class="btn btn-default">Cancel</button>                                
                                <button type="submit" class="btn btn-primary">  Go  </button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
