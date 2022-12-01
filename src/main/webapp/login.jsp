<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html  >

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Edumin - Bootstrap Admin Dashboard </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="all/images/favicon.png">
    <link href="all/css/style.css" rel="stylesheet">
    <link href="all/css/swal.css" rel="stylesheet">

</head>

<body class="h-100">
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
    <div class="authincation h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100 align-items-center">
                <div class="col-md-6">
                    <div class="authincation-content">
                        <div class="row no-gutters">
                            <div class="col-xl-12">
                                <div class="auth-form">
                                    <h4 class="text-center mb-4">Sign in your account</h4>
                                    <form action="login" method="post">
                                        <div class="form-group">
                                            <label><strong>Username</strong></label>
                                            <input type="text" name="userName" class="form-control" value="PF Number or Reg Number">
                                        </div>
                                        <div class="form-group">
                                            <label><strong>Password</strong></label>
                                            <input type="password" name="Password" class="form-control" value="Password">
                                        </div>
                                        <div class="form-row d-flex justify-content-between mt-4 mb-2">
                                            <div class="form-group">
                                               <div class="custom-control custom-checkbox ml-1">
													<input type="checkbox" class="custom-control-input" id="basic_checkbox_1">
													<label class="custom-control-label" for="basic_checkbox_1">Remember my preference</label>
												</div>
                                            </div>
                                            <div class="form-group">
                                                <a href="page-forgot-password.html">Forgot Password?</a>
                                            </div>
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-primary btn-block">Sign me in</button>
                                        </div>
                                    </form>
                                    <div class="new-account mt-3">
                                        <p>Don't have an account? <a class="text-primary" href="page-register.html">Sign up</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--**********************************
        Scripts
    ***********************************-->

<script src="all/js/jquary.js"></script>
<script src="all/js/swal.js"></script>
<script>

    var status2 = document.getElementById("status").value;
    if (status2 == "success") {
        Swal.fire(
            'Record updated!',
            'A new item inserted to Database',
            'success'
        )
    }
    if (status2 == "failed") Swal.fire({
        type: 'question',
        title: 'Oops...',
        text: 'Failed to update in Database!',
        footer: '<a href = "Grud.jsp">Check your inputs?</a>'
    })

</script>
    <!-- Required vendors -->
    <script src="all/vendor/global/global.min.js"></script>
	<script src="all/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
    <script src="all/js/custom.min.js"></script>
    <script src="all/js/dlabnav-init.js"></script>

</body>

</html>