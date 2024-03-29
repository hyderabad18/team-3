<!DOCTYPE html>
<html lang="en">

<head>
  <link rel="stylesheet" href="styles.css">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Youth For Seva Admin</title>
  <!-- Bootstrap core CSS-->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="custom/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="custom/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="admin_view.php">Admin</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="admin_view.php">
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="create_event.php">
            <span class="nav-link-text">Create New Event</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="pending.html">
            <span class="nav-link-text">Pending Invitations</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="events.html">
            <span class="nav-link-text">Events</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="tables.html">
            <span class="nav-link-text">Volunteers</span>
          </a>
        </li>
    
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>


  <!-- navigation -->

  <!-- content -->
  <div class="content-wrapper">
    <div class="container-fluid">
	
	
	 <!-- Tab links -->
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'EDUCATION')">EDUCATION</button>
  <button class="tablinks" onclick="openCity(event, 'HEALTH')">HEALTH</button>
  <button class="tablinks" onclick="openCity(event, 'ENVIRONMENT')">ENVIRONMENT</button>
  <button class="tablinks" onclick="openCity(event, 'ENABELEMENT')">ENABELEMENT</button>
 
</div>

<!-- Tab content -->
<div  id="EDUCATION" class="tab">
  <h3>EDUCATION</h3>
 <p margin-left: 50px> VOLUNTEER 1  &nbsp; event PENDING &nbsp;&nbsp;
 
 <label class="radio-inline"><input type="radio" name="optradio" value="EDUCATION">ACCEPT</label>
<label class="radio-inline"><input type="radio" name="optradio" value="EDUCATION">REJECT</label>
</p>

</div>


<div id="HEALTH" class="tab">
  <h3>HEALTH</h3>
  <p margin-left: 100px> VOLUNTEER 2 &nbsp;&nbsp; event PENDING &nbsp;&nbsp;
 
  
<label class="radio-inline"><input type="radio" name="optradio">ACCEPT</label>
<label class="radio-inline"><input type="radio" name="optradio">REJECT</label>

 
</div>

<div id="ENVIRONMENT" class="tab">
  <h3>ENVIRONMENT</h3>
  <p margin-left: 50px> VOLUNTEER 3  &nbsp;&nbsp; event PENDING &nbsp;&nbsp;
 
  <label class="radio-inline"><input type="radio" name="optradio">ACCEPT</label>
<label class="radio-inline"><input type="radio" name="optradio">REJECT</label>

</div> 

<div id="ENABELEMENT" class="tab">
  <h3>ENABELEMENT</h3>
  <p margin-left: 50px> VOLUNTEER 4  &nbsp;&nbsp; event PENDING &nbsp;&nbsp;
 
  <label class="radio-inline"><input type="radio" name="optradio">ACCEPT</label>
<label class="radio-inline"><input type="radio" name="optradio">REJECT</label>

</div>

<div id="ENVIRONMENT" class="tab">
  <h3>ENVIRONMENT</h3>
  <p margin-left: 50px> VOLUNTEER 3  &nbsp;&nbsp; event PENDING &nbsp;&nbsp;
 
  <label class="radio-inline"><input type="radio" name="optradio">ACCEPT</label>
<label class="radio-inline"><input type="radio" name="optradio">REJECT</label>

</div> 

<div id="EDUCATION" class="tab">
  <h3>EDUCATION</h3>
 <p>VOLUNTEER ADVANCED</p>
  <span onclick="this.parentElement.style.display='none'">x</span>
</div>

<div id="HEALTH" class="tab">
  <h3>HEALTH</h3>
 <p>VOLUNTEER ADVANCED</p>
  <span onclick="this.parentElement.style.display='none'">x</span>
</div>



	
</div>
  </div>
  




  <!--footer-->

    <!--<footer class="sticky-footer">-->
      <div class="container">
        <div class="footer">
          <small>Copyright � Your Website 2018</small>
        </div>
     </div>
    
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">�</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="custom/jquery/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="custom/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="custom/chart.js/Chart.min.js"></script>
    <script src="custom/datatables/jquery.dataTables.js"></script>
    <script src="custom/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>
	<script src="js/app.js"></script>
  
</body>

</html>
