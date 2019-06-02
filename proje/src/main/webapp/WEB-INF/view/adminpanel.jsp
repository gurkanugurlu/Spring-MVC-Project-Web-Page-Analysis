<%@ page import="com.ugurlu.gurkan.analysis.mydiffmodels.OsNames" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>AdminLTE 3 | Starter</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="/resources/css/font-awesome.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/css/adminlte.min.css">
  <link rel="stylesheet" href="/resources/css/jquery-jvectormap-1.2.2.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fa fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="/home/index" class="nav-link">Home</a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="info">
         <p style="color: white"><b style="font-size: 30px">  Aegis</b> </p>
          <p style="color:white"> ${admin.name}  ${admin.surname} </p>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fa fa-th"></i>
              <p>
                HomePage
              </p>
            </a>
          </li>

            <li class="nav-item">
                <a href="/admin/users" class="nav-link">
                    <i class="nav-icon fa fa-tag"></i>
                    <p>
                        Users
                    </p>
                </a>
            </li>
          <li class="nav-item">
            <a href="/admin/webpages" class="nav-link">
              <i class="nav-icon fa fa-tablet"></i>
              <p>
                Web Pages
              </p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark"><b> Aegis Management Panel</b></h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">admin</a></li>
              <li class="breadcrumb-item active">adminpanel</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="card">

        <div class="card-header">
          <h3 class="card-title"><b>Summary</b></h3>

        </div>
        <!-- /.card-header -->
        <div class="card-body p-0" style="display: block;">
        </div>
      </div>
    </div>
    <div class="row">
    <div class="col-lg-3 col-6" style="padding-left: 10px ">
      <!-- small box -->
      <div class="small-box bg-info">
        <div class="inner">
          <h3>${usersCount}</h3>

          <p>Total Visitor Count</p>
        </div>
        <div class="icon">
          <i class="ion ion-person-add"></i>
        </div>
        <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
      </div>
    </div>
    <div class="col-lg-3 col-6">
      <!-- small box -->
      <div class="small-box bg-success">
        <div class="inner">
          <h3>6<sup style="font-size: 20px"></sup></h3>

          <p>Total Page Count</p>
        </div>
        <div class="icon">
          <i class="ion ion-stats-bars"></i>
        </div>
        <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
      </div>
    </div>
      <div class="col-lg-3 col-6">
        <!-- small box -->
        <div class="small-box bg-warning">
          <div class="inner">
            <h3>${osCount}</h3>

            <p>Total Os Count</p>
          </div>
          <div class="icon">
            <i class="ion ion-person-add"></i>
          </div>
          <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
        </div>
      </div>
      <div class="col-lg-3 col-6">
        <!-- small box -->
        <div class="small-box bg-danger">
          <div class="inner">
            <h3>${browserCount}</h3>

            <p>Total Browser Count</p>
          </div>
          <div class="icon">
            <i class="ion ion-pie-graph"></i>
          </div>
          <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
        </div>
      </div>

    </div>
    <div class="row">
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-success">
          <span class="info-box-icon"><i class="fa fa-heart-o"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${mOs}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-info">
          <span class="info-box-icon"><i class="fa fa-comment-o"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${mBrw}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-danger">
          <span class="info-box-icon"><i class="fa fa-amazon"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${lBrw}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-warning">
          <span class="info-box-icon"><i class="fa fa-facebook"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${lOs}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-black">
          <span class="info-box-icon"><i class="fa fa-chevron-circle-down"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${bSes}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-gray">
          <span class="info-box-icon"><i class="fa fa-tablet"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${aSes}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-darkx"-">
          <span class="info-box-icon"><i class="fa fa-bitcoin"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${tSes}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
      <div class="col-lg-3 col-6" style="padding-left: 10px ">
        <div class="info-box mb-3 bg-secondary-gradient">
          <span class="info-box-icon"><i class="fa fa-empire"></i></span>

          <div class="info-box-content">
            <span class="info-box-text">${lastthirty}</span>

          </div>
          <!-- /.info-box-content -->
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="card card-primary card-outline">
          <div class="card-header">
            <h3 class="card-title">
              <i class="fa fa-bar-chart-o"></i>
             Session Times(second)/Per Page
            </h3>

            <div class="card-tools">
              <button type="button" class="btn btn-tool" data-widget="collapse">
                <i class="fa fa-minus"></i>
              </button>
              <button type="button" class="btn btn-tool" data-widget="remove">
                <i class="fa fa-times"></i>
              </button>
            </div>
          </div>
          <div class="card-body">
            <div id="bar-chart" style="height: 300px;"></div>
          </div>
          <!-- /.card-body-->
        </div>

      </div>
    </div>
   <div class="row" >
    <div class="col-md-3">
    <div class="card card-danger">
      <div class="card-header">
        <h3 class="card-title">Rate of Operating Systems</h3>

        <div class="card-tools">
          <button type="button" class="btn btn-tool" data-widget="collapse"><i class="fa fa-minus"></i>
          </button>
          <button type="button" class="btn btn-tool" data-widget="remove"><i class="fa fa-times"></i></button>
        </div>
      </div>
      <div class="col-md-4">
        <ul class="chart-legend clearfix">
          <c:forEach items="${osNames}" var="item">
            <li>
              <b class="fa fa-circle-o"><b> ${item.name} </b> </b>
            </li>

          </c:forEach>


        </ul>
      </div>
      <div class="card-body">
        <canvas id="pieChart" style="height:150px"></canvas>
      </div>
      <!-- /.card-body -->
    </div>
    <!-- /.content -->
  </div>
     <div class="col-md-3">
       <div class="card card-danger">
         <div class="card-header">
           <h3 class="card-title">Rate of Browser Types</h3>

           <div class="card-tools">
             <button type="button" class="btn btn-tool" data-widget="collapse"><i class="fa fa-minus"></i>
             </button>
             <button type="button" class="btn btn-tool" data-widget="remove"><i class="fa fa-times"></i></button>
           </div>
         </div>
         <div class="col-md-4">
           <ul class="chart-legend clearfix">
             <c:forEach items="${browserNames}" var="item">
               <li>
                 <b class="fa fa-circle-o"><b> ${item.name} </b> </b>
               </li>

             </c:forEach>


           </ul>
         </div>
         <div class="card-body">
           <canvas id="pieChart2" style="height:150px"></canvas>
         </div>
         <!-- /.card-body -->
       </div>
       <!-- /.content -->
     </div>
     <div class="col-md-3">
       <div class="card card-danger">
         <div class="card-header">
           <h3 class="card-title">Rate of Clicked Pages</h3>

           <div class="card-tools">
             <button type="button" class="btn btn-tool" data-widget="collapse"><i class="fa fa-minus"></i>
             </button>
             <button type="button" class="btn btn-tool" data-widget="remove"><i class="fa fa-times"></i></button>
           </div>
         </div>
         <div class="col-md-4">
           <ul class="chart-legend clearfix">
               <li style="font-size:12px">
                 <b class="fa fa-circle-o"><b> indexCount </b> </b>
                 <b class="fa fa-circle-o"><b> aboutCount </b> </b>
                 <b class="fa fa-circle-o"><b> contactCount </b> </b>
                 <b class="fa fa-circle-o"><b> singleCount </b> </b>
               </li>




           </ul>
         </div>
         <div class="card-body">
           <canvas id="pieChart3" style="height:150px"></canvas>
         </div>
         <!-- /.card-body -->
       </div>
       <!-- /.content -->
     </div>
   </div>
  </div>
  <!-- /.content-wrapper -->




  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      <strong>Aegis...</strong>
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2018 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<!-- Bootstrap 4 -->
<script src="/resources/js/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="/resources/js/Chart.min.js"></script>
<script src="/resources/js/adminlte.min.js"></script>
<script src="/resources/js/demo.js"></script>
<script src="http://cdn.jsdelivr.net/jquery.flot/0.8.3/jquery.flot.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flot/0.8.3/jquery.flot.categories.min.js"></script>
<script>
  $(function () {
    let PieDataa = new Array();
    let colors=['#00a65a','#f39c12','#3c8dbc','#d2d6de','#f56954'];
    var sayac=0;
    <c:forEach items="${osNames}" var="listItem">
    var gecici={
      value:0,
      color:colors[sayac],
      highlight:colors[sayac],
      label:"",
    };
    gecici.label="${listItem.name}";
    gecici.value=${listItem.count};
    sayac++;
    PieDataa.push(gecici);
    </c:forEach>
    let pieChartCanvas = $('#pieChart').get(0).getContext('2d');
    let pieChart       = new Chart(pieChartCanvas);
    let pieOptions     = {
      //Boolean - Whether we should show a stroke on each segment
      segmentShowStroke    : true,
      //String - The colour of each segment stroke
      segmentStrokeColor   : '#fff',
      //Number - The width of each segment stroke
      segmentStrokeWidth   : 2,
      //Number - The percentage of the chart that we cut out of the middle
      percentageInnerCutout: 50, // This is 0 for Pie charts
      //Number - Amount of animation steps
      animationSteps       : 100,
      //String - Animation easing effect
      animationEasing      : 'easeOutBounce',
      //Boolean - Whether we animate the rotation of the Doughnut
      animateRotate        : true,
      //Boolean - Whether we animate scaling the Doughnut from the centre
      animateScale         : false,
      //Boolean - whether to make the chart responsive to window resizing
      responsive           : true,
      // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio  : true,
      //String - A legend template
    }
    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    pieChart.Doughnut(PieDataa, pieOptions);




    let PieData2=new Array();
    let colors2=['#FF6F61','#6B5B95','#9B1B30','#5A3E36','#2A4B7C'];
    var sayac2=0;
    <c:forEach items="${browserNames}" var="listItem2">
    var gecici2={
      value:0,
      color:colors2[sayac2],
      highlight:colors2[sayac2],
      label:"",
    };
    gecici2.label="${listItem2.name}";
    gecici2.value=${listItem2.count};
    sayac2++;
    PieData2.push(gecici2);
    </c:forEach>
    let pieChartCanvas2 = $('#pieChart2').get(0).getContext('2d');
    let pieChart2       = new Chart(pieChartCanvas2);
    let pieOptions2     = {
      //Boolean - Whether we should show a stroke on each segment
      segmentShowStroke    : true,
      //String - The colour of each segment stroke
      segmentStrokeColor   : '#fff',
      //Number - The width of each segment stroke
      segmentStrokeWidth   : 2,
      //Number - The percentage of the chart that we cut out of the middle
      percentageInnerCutout: 50, // This is 0 for Pie charts
      //Number - Amount of animation steps
      animationSteps       : 100,
      //String - Animation easing effect
      animationEasing      : 'easeOutBounce',
      //Boolean - Whether we animate the rotation of the Doughnut
      animateRotate        : true,
      //Boolean - Whether we animate scaling the Doughnut from the centre
      animateScale         : false,
      //Boolean - whether to make the chart responsive to window resizing
      responsive           : true,
      // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio  : true,
      //String - A legend template
    }
    pieChart2.Doughnut(PieData2, pieOptions2);


    let PieData3=new Array();
    let colors3=['#D5AE41','#F1EA7F','#006E6D','#E94B3C','#00A591'];

    var gecici3={
      value:"${counts.indexCount}",
      color:colors3[0],
      highlight:colors3[0],
      label:"indexCount"};
    var gecici4={
      value:"${counts.aboutCount}",
      color:colors3[1],
      highlight:colors3[1],
      label:"aboutCount"};
    var gecici5={
      value:"${counts.singleCount}",
      color:colors3[2],
      highlight:colors3[2],
      label:"singleCount"};
    var gecici6={
      value:"${counts.contactCount}",
      color:colors3[3],
      highlight:colors3[3],
      label:"contactCount"};

    PieData3.push(gecici3);
    PieData3.push(gecici4);
    PieData3.push(gecici5);
    PieData3.push(gecici6);

    let pieChartCanvas3 = $('#pieChart3').get(0).getContext('2d');
    let pieChart3      = new Chart(pieChartCanvas3);
    let pieOptions3     = {
      //Boolean - Whether we should show a stroke on each segment
      segmentShowStroke    : true,
      //String - The colour of each segment stroke
      segmentStrokeColor   : '#fff',
      //Number - The width of each segment stroke
      segmentStrokeWidth   : 2,
      //Number - The percentage of the chart that we cut out of the middle
      percentageInnerCutout: 50, // This is 0 for Pie charts
      //Number - Amount of animation steps
      animationSteps       : 100,
      //String - Animation easing effect
      animationEasing      : 'easeOutBounce',
      //Boolean - Whether we animate the rotation of the Doughnut
      animateRotate        : true,
      //Boolean - Whether we animate scaling the Doughnut from the centre
      animateScale         : false,
      //Boolean - whether to make the chart responsive to window resizing
      responsive           : true,
      // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio  : true,
      //String - A legend template
    }
    pieChart3.Doughnut(PieData3, pieOptions3);


    let anaGecici=[];
    <c:forEach items="${pageSessionTimes}" var="sessionItem">
    var temp=[];
    var ad="${sessionItem.name}";
    var zaman=${sessionItem.time};
    temp.push(ad,zaman);
    anaGecici.push(temp);
    </c:forEach>

    let bar_data = {
      data : anaGecici ,
      color   : '#3c8dbc'
    }
    $.plot('#bar-chart', [bar_data], {
      grid  : {
        borderWidth: 1,
        borderColor: '#f3f3f3',
        tickColor  : '#f3f3f3'
      },
      series: {
        bars: {
          show    : true,
          barWidth: 0.25,
          align   : 'center'
        }
      },
      xaxis : {
        mode      : 'categories',
        tickLength: 0
      }
    })




  })
</script>
</body>
</html>
