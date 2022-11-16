<%--
  Created by IntelliJ IDEA.
  User: bstevary
  Date: 15/11/2022
  Time: 16:10
  reg_No, f_Name, s_Name, l_Name, d_O_B, email, cohort_ID, course_ID, n_ID, contacts, status, type
  To change this template use File | Settings | File Templates.
--%>

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
      <a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/list"
             class="nav-link">Users</a></li>
    </ul>
  </nav>
</header>
<br>
<div class="container col-md-5">
  <div class="card">
    <div class="card-body">
      <c:if test="${user != null}">
      <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${user != null}">
                Edit User
              </c:if>
              <c:if test="${user == null}">
                Add New User
              </c:if>
            </h2>
          </caption>

          <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.reg_No}' />" />
          </c:if>

          <fieldset class="form-group">
            <label>User Name</label> <input type="text"
                                            value="<c:out value='${user.f_Name}' />" class="form-control"
                                            name="f_Name" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>User Email</label> <input type="text"
                                             value="<c:out value='${user.s_Name}' />" class="form-control"
                                             name="s_Name">
          </fieldset>

          <fieldset class="form-group">
            <label>User Country</label> <input type="text"
                                               value="<c:out value='${user.l_Name}' />" class="form-control"
                                               name="l_Name">
          </fieldset>

            <fieldset class="form-group">
              <label>User Country</label> <input type="date"
                                                 value="<c:out value='${user.d_O_B}' />" class="form-control"
                                                 name="d_O_B">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="email"
                                                 value="<c:out value='${user.email}' />" class="form-control"
                                                 name="email">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="text"
                                                 value="<c:out value='${user.cohort_ID}' />" class="form-control"
                                                 name="cohort_ID">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="text"
                                                 value="<c:out value='${user.course_ID}' />" class="form-control"
                                                 name="course_ID">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="text"
                                                 value="<c:out value='${user.n_ID}' />" class="form-control"
                                                 name="n_ID">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="text"
                                                 value="<c:out value='${user.contacts}' />" class="form-control"
                                                 name="contacts">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="text"
                                                 value="<c:out value='${user.status}' />" class="form-control"
                                                 name="status">
            </fieldset>


            <fieldset class="form-group">
              <label>User Country</label> <input type="text"
                                                 value="<c:out value='${user.type}' />" class="form-control"
                                                 name="type">
            </fieldset>



            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
  </div>
</div>
</body>
</html>
