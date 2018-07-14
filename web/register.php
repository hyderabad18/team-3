<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Admin registration</title>
  <!-- Bootstrap core CSS-->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="custom/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Full name</label>
                <input class="form-control" id="dname" type="text" aria-describedby="nameHelp" placeholder="Enter full name">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Age</label>
                <input class="form-control" id="dage" type="text" aria-describedby="nameHelp" placeholder="Enter Age">
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="Demail" type="email" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Date of Birth</label>
                <input class="form-control" id="Ddob" type="text" aria-describedby="nameHelp" placeholder="Enter Date of Birth">
              </div>
              <!--<div class="col-md-6">
                <label for="exampleInputLastName">PAN</label>
                <input class="form-control" id="Dpan" type="text" aria-describedby="nameHelp" placeholder="Enter PAN Number">
              </div>-->
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Phone Number</label>
            <input class="form-control" id="DPhno" type="number" aria-describedby="emailHelp" placeholder="Enter Phone">
          </div>
         <!-- <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Confirm password</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Confirm password">
              </div>
            </div>
          </div>-->
          <a class="btn btn-primary btn-block" href="index.php">Register</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="index.php">Login Page</a>
          <a class="d-block small" href="forgot_password.php">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="custom/jquery/jquery.min.js"></script>
  <script src="js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="custom/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
