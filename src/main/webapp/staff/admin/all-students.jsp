<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="" class="navbar-brand"> Students
                Management  </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Students</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Students</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New Students</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>

                <th>Reg_No</th>
                <th>F_Name</th>
                <th>S_Name</th>
                <th>L_Name</th>
                <th>Email</th>
                <th>Cohort</th>
                <th>Course</th>
                <th>N_ID</th>
                <th>Contacts</th>
                <th>Status</th>
                <th>Type</th>
                <th>Action</th>


            </tr>
            </thead>
            <tbody>

            <c:forEach var="user" items="${listUser}">

                <tr>
                    <td><c:out value="${user.reg_No}" /></td>
                    <td><c:out value="${user.f_Name}" /></td>
                    <td><c:out value="${user.s_Name}" /></td>
                    <td><c:out value="${user.l_Name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.cohort_ID}" /></td>
                    <td><c:out value="${user.course_ID}" /></td>
                    <td><c:out value="${user.n_ID}" /></td>
                    <td><c:out value="${user.contacts}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td><c:out value="${user.type}" /></td>
                    <td><a href="edit?reg_No=<c:out value='${user.reg_No}' />">Edit</a>
                        <a href="delete?reg_No=<c:out value='${user.reg_No}' />">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>