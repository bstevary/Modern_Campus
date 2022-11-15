<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style type="text/css">
        <%@include file="all/css/main.css" %>

    </style>
    <!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
        <div class="container">
            <h2 style="text-align: center;" >Modern Campus</h2>
            <link rel="stylesheet" type="text/css" href="all/css/main.css" />
            </head>
            <body>
            <div class="container">
                <h2 style="text-align: center;" >Log in to access</h2>
                <form action="login" method="post">
                    <div class="row" >
                        <div class="col">
                            <!-- left part -->
                        </div>
                        <div class="col" >
                            <table style="margin: 10px; ">
                                <tr><td>UserName:</td><td><input type="text" name="UserName" placeholder="Reg_No or PF_No" > </td></tr>
                                <tr><td>Password: </td><td> <input type="Password" name="Password"> </td></tr>
                                <tr><td> </td><td><input type="submit" class="button" value="Login" >  Forget Password <a href="forgot.jsp">click</a>  </td></tr>
                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>
</body>

</html>
