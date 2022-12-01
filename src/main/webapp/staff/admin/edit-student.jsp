<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html >

<head>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Edumin - Bootstrap Admin Dashboard </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../all/images/favicon.png">
    <link rel="stylesheet" href="../../all/vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="../../all/css/style.css">
	



</head>

<body>

<%@include file="header.jsp"%>
		
		
        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
            <!-- row -->
            <div class="container-fluid">
				    
                <div class="row page-titles mx-0">
                    <div class="col-sm-6 p-md-0">
                        <div class="welcome-text">
                            <h4>Edit Student</h4>
                        </div>
                    </div>
                    <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                            <li class="breadcrumb-item active"><a href="javascript:void(0);">Students</a></li>
                            <li class="breadcrumb-item active"><a href="javascript:void(0);">Edit Student</a></li>
                        </ol>
                    </div>
                </div>
				
				<div class="row">
					<div class="col-xl-12 col-xxl-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
								<h5 class="card-title">Basic Info</h5>
							</div>
							<div class="card-body">
                                <form action="update" method="post">
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Student Reg_No</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.reg_No}' />"
													   name="reg_No" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Student F_Name</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.f_Name}' />"
													   name="f_Name" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Student S_Name</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.s_Name}' />"
													   name="s_Name" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">

										<div class="form-group">
												<label class="form-label">Student Course_ID</label>
												<select name="course_ID" class="form-control">
													<c:forEach items ="${courses}" var ="courses">
													<option value='${courses.course_ID}'/>${courses.course_ID}
													<c:if test=" ${courses.course_ID eq StudentBean.course_ID}">
														selected ="selected"
													</c:if>

													</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Student L_Name</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.l_Name}' />"
													   name="l_Name" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Student Email</label>
												<input type="email" class="form-control" value="<c:out value='${StudentBean.email}' />"
													   name="email" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">National ID</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.n_ID}' />"
													   name="n_ID" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Contacts</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.contacts}' />"
													   name="contacts" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Status</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.status}' />"
													   name="status" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Cohort_ID</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.cohort_ID}' />"
													   name="cohort_ID" required="required">
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12">
											<div class="form-group">
												<label class="form-label">Type</label>
												<input type="text" class="form-control" value="<c:out value='${StudentBean.type}' />"
													   name="type" required="required">
											</div>
										</div>

										<div class="col-lg-12 col-md-12 col-sm-12">
											<button type="submit" class="btn btn-primary">Submit</button>
											<button type="submit" class="btn btn-light">Cencel</button>
										</div>
									</div>
								</form>
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
                <p>Copyright © Designed &amp; Developed by <a href="../index.htm" target="_blank">DexignLab</a> 2020</p>
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

	<!-- Svganimation scripts -->
    <script src="../../all/vendor/svganimation/vivus.min.js"></script>
    <script src="../../all/vendor/svganimation/svg.animation.js"></script>
    <script src="../../all/js/styleSwitcher.js"></script>
	
	<!-- pickdate -->
    <script src="../../all/vendor/pickadate/picker.js"></script>
    <script src="../../all/vendor/pickadate/picker.time.js"></script>
    <script src="../../all/vendor/pickadate/picker.date.js"></script>
	
	<!-- Pickdate -->
    <script src="../../all/js/plugins-init/pickadate-init.js"></script>
	
</body>
</html>