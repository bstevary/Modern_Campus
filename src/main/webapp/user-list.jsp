<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>User Management Application</title>
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
      <a href="https://www.xadmin.net" class="navbar-brand"> User
        Management  </a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/list"
             class="nav-link">Users</a></li>
    </ul>
  </nav>
</header>
<br>

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">List of Users</h3>
    <hr>
    <div class="container text-left">

      <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
        New User</a>
    </div>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>Reg_No</th>
        <th>F_Name</th>
        <th>S_Name</th>
        <th>L_Name</th>
        <th>D_O_B</th>
        <th>Email</th>
        <th>Cohort_ID</th>
        <th>Course_ID</th>
        <th>N_ID</th>
        <th>Contacts</th>
        <th>Status</th>
        <th>Type</th>
      </tr>
      </thead>
      <tbody>

      <c:forEach var="user" items="${listUser}">

        <tr>
          <td><c:out value="${user.Reg_No}" /></td>
          <td><c:out value="${user.F_Name}" /></td>
          <td><c:out value="${user.S_Name}" /></td>
          <td><c:out value="${user.L_Name}" /></td>
          <td><c:out value="${user.D_O_B}" /></td>
          <td><c:out value="${user.Email}" /></td>
          <td><c:out value="${user.Cohort_ID}" /></td>
          <td><c:out value="${user.Course_ID}" /></td>
          <td><c:out value="${user.Contacts}" /></td>
          <td><c:out value="${user.Status}" /></td>
          <td><c:out value="${user.Type}" /></td>
          <td><a href="edit?id=<c:out value='${user.Reg_No}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="delete?id=<c:out value='${user.Reg_No}' />">Delete</a></td>
        </tr>
      </c:forEach>

      </tbody>

    </table>
  </div>
</div>
</body>
</html>