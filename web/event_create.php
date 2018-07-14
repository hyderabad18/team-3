<!DOCTYPE html>
<html lang="en">

<head>
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
  <link rel="stylesheet" href="custom/clock/bootstrap-clockpicker.css" type="text/css">
  <link rel="stylesheet" href="custom/clock/jquery-clockpicker.css" type="text/css">
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
          <a class="nav-link" href="pending.php">
            <span class="nav-link-text">Pending Invitations</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="events.php">
            <span class="nav-link-text">Events</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="volunteers.php">
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
            <form class="form-horizontal" role="form">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <label for="eventName" class="col-sm-3 control-label"><strong>Event Name</strong></label>
                    <div class="col-sm-9">
                        <input type="text" id="eventName" placeholder="Event Name" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="location" class="col-sm-3 control-label"><strong>Location</strong></label>
                    <div class="col-sm-9">
                        <select id="location" class="form-control">
                            <option>Hyderabad</option>
                            <option>Banglore</option>
                            <option>Mumbai</option>
                            <option>Culcutta</option>
                            <option>Chennai</option>
                            <option>New Delhi</option>
                            <option>Cochin</option>
                            <option>Vishakaptnam</option>
                        </select>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <label for="startDate" class="col-sm-3 control-label"><strong>Start Date</strong></label>
                    <div class="col-sm-9">
                        <input type="date" id="startDate" class="form-control">
                    </div>
                </div>
                <div class="form-group clockpicker">
                    <label for="startTime" class="col-sm-3 control-label"><strong>Start Time</strong></label>
                    <!--<span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                    </span>-->
                    <div class="col-sm-6">
                    <select name="hours">
                        <option value="1">1</option>
                        <option value="2">3</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select> 
                    <select name="mins">
                        <option value="00">00</option>
                        <option value="15">15</option>
                        <option value="30">30</option>
                        <option value="45">45</option>
                    </select> 
                    <select name="ampm" id="ampm">
                        <option value="AM">AM</option>
                        <option value="PM">PM</option>
                    </select>
                    </div>
                </div>
                <!--<script type="text/javascript">
                $('.clockpicker').clockpicker({
                    placement: 'top',
                    align: 'left',
                    donetext: 'Done'
                });
                </script>-->


                <div class="form-group">
                    <label for="endDate" class="col-sm-3 control-label"><strong>End Date</strong></label>
                    <div class="col-sm-9">
                        <input type="date" id="endDate" class="form-control">
                    </div>
                </div>
                <div class="form-group clockpicker">
                    <label for="endTime" class="col-sm-3 control-label"><strong>End Time</strong></label>
                    <!--<span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                    </span>-->
                    <div class="col-sm-6">
                    <select name="hours">
                        <option value="1">1</option>
                        <option value="2">3</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select> 
                    <select name="mins">
                        <option value="00">00</option>
                        <option value="15">15</option>
                        <option value="30">30</option>
                        <option value="45">45</option>
                    </select> 
                    <select name="ampm" id="ampm">
                        <option value="AM">AM</option>
                        <option value="PM">PM</option>
                    </select>
                    </div>
                </div>
                
               <!-- <script type="text/javascript">
                $('.clockpicker').clockpicker();
                </script>-->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="image"><strong>Upload Image</strong></label>
                        <div class="input-group">
                            <span class="input-group-btn">
                                <span class="btn btn-default btn-file">
                                    <input type="file" id="imgInp">
                                </span>
                            </span>
                        </div>
                        <img id='img-upload'/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label"><strong>Event Description</strong></label>
                    <div class="col-sm-12">
                    <textarea class="form-control" id="description" rows="3"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                </div>
            </form> <!-- /form -->


    </div><!-- container fluid-->
  </div>





  <!--footer-->

    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
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
              <span aria-hidden="true">×</span>
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
    <script src="custom/clock/bootstrap-clockpicker.js"></script>
    <script src="custom/clock/jquery-clockpicker.js"></script>
  
</body>

</html>
