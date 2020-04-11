<%-- 
    Document   : useradd
    Created on : Apr 5, 2020, 12:14:38 PM
    Author     : shahzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSpring : User Registration</title>
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

    <div class="row">
        <div class="col-lg-6" style="padding: 50px">
            <a href="home.htm" value="Home" class="btn btn-primary btn-xs">Home</a>
            <div class="well bs-component">
                <form class="form-horizontal" action="useradd.htm" method="POST">
                    <fieldset>
                        <legend>User Registration</legend>
                        <div class="form-group">
                            <label for="inputUsername" class="col-lg-2 control-label">User</label>
                            <div class="col-lg-10">
                                <input required="Yes" style="background: cornsilk" type="text" class="form-control" 
                                       id="user_name" placeholder="User Name" name="user_name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                            <div class="col-lg-10">
                                <input required="Yes" style="background: cornsilk" type="password" class="form-control" id="inputPassword" placeholder="Password" name="user_password">                                

                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="email" 
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email_address" placeholder="Email Address">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Phone #</label>
                            <div class="col-lg-10">
                                <input class="form-control" type="tel" id="phone" 
                                       pattern="[0-9]{3}-[0-9]{3}-[0-9]{7}" name="phone_num" placeholder="092-123-4567890">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">Description</label>
                            <div class="col-lg-10">
                                <textarea name="description" class="form-control" rows="3" id="textArea" placeholder="User Description here !"></textarea>                      
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="reset" class="btn btn-default">Cancel</button>                                
                                <button type="submit" class="btn btn-primary">Register</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>        
    </body>
</html>
