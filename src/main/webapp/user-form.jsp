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
            <input type="hidden" name="Reg_No" value="<c:out value='${user.reg_No}' />" />
          </c:if>
            <fieldset class="form-group">
              <label>User F_Name</label> <input type="text"
                                                value="<c:out value='${user.f_Name}' />" class="form-control"
                                                name="Reg_No" required="required">
            </fieldset>

          <fieldset class="form-group">
            <label>User F_Name</label> <input type="text"
                                            value="<c:out value='${user.f_Name}' />" class="form-control"
                                            name="F_Name" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>User S_Name</label> <input type="text"
                                             value="<c:out value='${user.s_Name}' />" class="form-control"
                                             name="S_Name">
          </fieldset>

          <fieldset class="form-group">
            <label>User L_Name</label> <input type="text"
                                               value="<c:out value='${user.l_Name}' />" class="form-control"
                                               name="L_Name">
          </fieldset>


            <fieldset class="form-group">
              <label>User Email</label> <input type="email"
                                                 value="<c:out value='${user.email}' />" class="form-control"
                                                 name="Email">
            </fieldset>


            <fieldset class="form-group">
              <label>User Cohort_ID</label> <input type="text"
                                                 value="<c:out value='${user.cohort_ID}' />" class="form-control"
                                                 name="Cohort_ID">
            </fieldset>


            <fieldset class="form-group">
              <label>User Course_ID</label> <input type="text"
                                                 value="<c:out value='${user.course_ID}' />" class="form-control"
                                                 name="Course_ID">
            </fieldset>


            <fieldset class="form-group">
              <label>User N_ID</label> <input type="text"
                                                 value="<c:out value='${user.n_ID}' />" class="form-control"
                                                 name="N_ID">
            </fieldset>


            <fieldset class="form-group">
              <label>User Contacts</label> <input type="text"
                                                 value="<c:out value='${user.contacts}' />" class="form-control"
                                                 name="Contacts">
            </fieldset>


            <fieldset class="form-group">
              <label>User Status</label> <input type="text"
                                                 value="<c:out value='${user.status}' />" class="form-control"
                                                 name="Status">
            </fieldset>


            <fieldset class="form-group">
              <label>User Type</label> <input type="text"
                                                 value="<c:out value='${user.type}' />" class="form-control"
                                                 name="Type">
            </fieldset>



            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
  </div>
</div>
</body>
</html>
