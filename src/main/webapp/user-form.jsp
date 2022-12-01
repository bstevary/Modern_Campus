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
      <c:if test="${StudentBean != null}">
      <form action="update" method="post">
        </c:if>
        <c:if test="${StudentBean == null}">
        <form action="insert" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${StudentBean != null}">
                Edit Student
              </c:if>
              <c:if test="${StudentBean == null}">
                Add New Student
              </c:if>
            </h2>
          </caption>

            <fieldset class="form-group">
              <label>Student Reg_No</label> <input type="text"
                                                value="<c:out value='${StudentBean.reg_No}' />" class="form-control"
                                                name="reg_No" required="required">
            </fieldset>

          <fieldset class="form-group">
            <label>Student F_Name</label> <input type="text"
                                            value="<c:out value='${StudentBean.f_Name}' />" class="form-control"
                                            name="f_Name" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>Student S_Name</label> <input type="text"
                                                 value="<c:out value='${StudentBean.s_Name}' />" class="form-control"
                                                 name="s_Name">
          </fieldset>

          <fieldset class="form-group">
            <label>Student L_Name</label> <input type="text"
                                               value="<c:out value='${StudentBean.l_Name}' />" class="form-control"
                                               name="l_Name">
          </fieldset>


            <fieldset class="form-group">
              <label>Student Email</label> <input type="text"
                                                 value="<c:out value='${StudentBean.email}' />" class="form-control"
                                                 name="email">
            </fieldset>

            <fieldset class="form-group">
              <label>Student N_ID</label> <input type="text"
                                                 value="<c:out value='${StudentBean.n_ID}' />" class="form-control"
                                                 name="n_ID">
            </fieldset>

            <fieldset class="form-group">
              <label>Student Contacts</label> <input type="text"
                                                 value="<c:out value='${StudentBean.contacts}' />" class="form-control"
                                                 name="contacts">
            </fieldset>


            <fieldset class="form-group">
              <label>Student Status</label> <input type="text"
                                                 value="<c:out value='${StudentBean.status}' />" class="form-control"
                                                 name="status">
            </fieldset>

            <fieldset class="form-group">
              <label>Student Course_ID</label> <select name="course_ID" class="form-control">
                                                    <c:forEach items ="${courses}" var ="courses">
                                                             <option value='${courses.course_ID}'/>${courses.course_ID}
                                                       <c:if test=" ${courses.course_ID eq StudentBean.course_ID}">
                                                         selected ="selected"
                                                       </c:if>

                                                      </option>
                                                </c:forEach>
                                                </select>


            </fieldset>

            <fieldset class="form-group">
              <label>Student Cohort_ID</label> <input type="text"
                                                      value="<c:out value='${StudentBean.cohort_ID}' />" class="form-control"
                                                      name="cohort_ID">
            </fieldset>

            <fieldset class="form-group">
              <label>Student Type</label> <input type="text"
                                                 value="<c:out value='${StudentBean.type}' />" class="form-control"
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
