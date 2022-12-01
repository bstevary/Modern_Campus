<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >

<head>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Modern Campus Admin Dashboard </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../all/images/favicon.png">
    <link rel="stylesheet" href="../../all/vendor/jqvmap/css/jqvmap.min.css">
	<link rel="stylesheet" href="../../all/vendor/chartist/css/chartist.min.css">
	<!-- Summernote -->
    <link href="../../all/vendor/summernote/summernote.css" rel="stylesheet">
	<link rel="stylesheet" href="../../all/vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="../../all/css/style.css">
    <link rel="stylesheet" href="../../all/css/skin-3.css">

</head>

<body>

<%@include file="header.jsp"%>
		
        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
            <!-- row -->
            <div class="container-fluid">
				    
                <div class="row">
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-primary">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-users"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">Total Students</p>
										<h3 class="text-white">3280</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 80%"></div>
                                        </div>
										<small>80% Increase in 20 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-warning">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-user"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">New Students</p>
										<h3 class="text-white">245</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 50%"></div>
                                        </div>
										<small>50% Increase in 25 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-secondary">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-graduation-cap"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">Total Course</p>
										<h3 class="text-white">28</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 76%"></div>
                                        </div>
										<small>76% Increase in 20 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>
					<div class="col-xl-3 col-xxl-3 col-sm-6">
						<div class="widget-stat card bg-danger">
							<div class="card-body">
								<div class="media">
									<span class="mr-3">
										<i class="la la-dollar"></i>
									</span>
									<div class="media-body text-white">
										<p class="mb-1">Fees Collection</p>
										<h3 class="text-white">25160$</h3>
										<div class="progress mb-2 bg-white">
                                            <div class="progress-bar progress-animated bg-light" style="width: 30%"></div>
                                        </div>
										<small>30% Increase in 30 Days</small>
									</div>
								</div>
							</div>
						</div>
                    </div>

					<div class="col-xl-12 col-xxl-12 col-lg-12 col-md-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">

                                <a  href="<%=request.getContextPath()%>/list"<h4 class="card-title"> Student List</h4></a>
                            </div>
                            <h4></h4>
                            <div class="card-body">
                                <div class="table-responsive recentOrderTable">
                                    <table class="table verticle-middle table-responsive-md">
                                        <thead>
                                            <tr>
                                                <th scope="col">Reg_No</th>
                                                <th scope="col">F_Name</th>
                                                <th scope="col">S_Name</th>
                                                <th scope="col">L_Name</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Cohort</th>
                                                <th scope="col">Course</th>
                                                <th scope="col">N_ID</th>
                                                <th scope="col">Contacts</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Type</th>
                                                <th scope="col">Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
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
                                                <td><a href="edit?reg_No=<c:out value='${user.reg_No}' />"class="btn btn-sm btn-primary"><i class="la la-pencil"></i></a>
                                                    <a href="delete?reg_No=<c:out value='${user.reg_No}' />"class="btn btn-sm btn-danger"><i class="la la-trash-o"></i></a></td>
                                            </tr>
                                            </c:forEach>


                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				
            </div>
        </div>
        <!--**********************************
            Content body end
        ***********************************-->


        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <div class="copyright">
                <p>Copyright © Designed &amp; Developed by <a href="../index.html" target="_blank">BSTEVARY</a> 2022</p>
            </div>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->

		<!--**********************************
           Support ticket button start
        ***********************************-->

        <!--**********************************
           Support ticket button end
        ***********************************-->


    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <!-- Required vendors -->
    <script src="../../all/vendor/global/global.min.js"></script>
	<script src="../../all/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
    <script src="../../all/js/custom.min.js"></script>
    <script src="../../all/js/dlabnav-init.js"></script>
	
	<!-- Chart sparkline plugin files -->
    <script src="../../all/vendor/jquery-sparkline/jquery.sparkline.min.js"></script>
	<script src="../../all/js/plugins-init/sparkline-init.js"></script>
	
	<!-- Chart Morris plugin files -->
    <script src="../../all/vendor/raphael/raphael.min.js"></script>
    <script src="../../all/vendor/morris/morris.min.js"></script>
	
    <!-- Init file -->
    <script src="../../all/js/plugins-init/widgets-script-init.js"></script>
	
	<!-- Demo scripts -->
    <script src="../../all/js/dashboard/dashboard.js"></script>
	
	<!-- Summernote -->
    <script src="../../all/vendor/summernote/js/summernote.min.js"></script>
    <!-- Summernote init -->
    <script src="../../all/js/plugins-init/summernote-init.js"></script>
	
	<!-- Svganimation scripts -->
    <script src="../../all/vendor/svganimation/vivus.min.js"></script>
    <script src="../../all/vendor/svganimation/svg.animation.js"></script>

		
</body>
</html>