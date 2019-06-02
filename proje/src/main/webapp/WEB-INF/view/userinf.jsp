<%@ page import="com.ugurlu.gurkan.analysis.mydiffmodels.OsNames" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/css/adminlte.min.css">
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
                        <a href="/admin/adminpanel" class="nav-link">
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
                        <h1 class="m-0 text-dark"><strong> Aegis Management Panel</strong></h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">userinf</li>
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
                    <h3 class="card-title"><b>User Session Information</b></h3>

                </div>
                <div style="font-size:18px; padding-left: 50px ">
                    <div style="padding:10px ">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/countdown.png"/> <b>Id:</b> ${webUser.id}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/rss.png"/>    <b>Name:</b> ${webUser.localeName}
                </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/id.png"/> <b>Session Id:</b> ${webUser.analysis_session.sessionId}
                </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/school.png"/> <b>Creation Time:</b> ${webUser.analysis_session.creationTime}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/cln.png"/> <b>Expiration Time:</b> ${webUser.analysis_session.lastAccessedTime}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/star.png"/> <b>User Ip:</b> ${webUser.name}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/shipping.png"/><b>Accepting Language:</b> ${webUser.acceptLanguage.substring(0,5)}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/tag.png"/><b>Connection Port:</b> ${webUser.localPort}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/faq.png"/>  <b>Cookies:</b> ${webUser.cookie}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/id.png"/> <b>Index Count:</b> ${webUser.indexCount}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/movie.png"/>   <b>Index Time:</b> ${webUser.totalIndexTime}seconds
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/id.png"/><b>Contact Count</b> ${webUser.contactCount}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/movie.png"/>  <b>Contact Time:</b> ${webUser.totalContactTime}seconds
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/id.png"/> <b>Single Count:</b> ${webUser.singleCount}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/movie.png"/>   <b>Single Time:</b> ${webUser.totalSingleTime} seconds
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/id.png"/> <b>About Count:</b> ${webUser.aboutCount}
                    </div>

                </div>
            </div>
            <div class="card">

                <div class="card-header">
                    <h3 class="card-title"><b>User Browser Information</b></h3>

                </div>
                <div style="font-size:18px; padding-left: 50px ">
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/data.png"/>  <b>Code:</b> ${webUser.browser_details.code}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/chrome.png"/> <b>Group:</b> ${webUser.browser_details.browserGroup}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/search.png"/> <b>Name:</b> ${webUser.browser_details.browserName}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/factory.png"/>   <b>Manufacturer:</b> ${webUser.browser_details.manufacturer}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/palet.png"/><b>Type:</b> ${webUser.browser_details.browserType}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/robot.png"/> <b>Engine:</b> ${webUser.browser_details.engine}
                    </div>

                </div>
            </div>
            <div class="card">

                <div class="card-header">
                    <h3 class="card-title"><b>User Operating System Information</b></h3>

                </div>
                <div style="font-size:18px; padding-left: 50px ">
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/data.png"/>  <b>Code:</b> ${webUser.os_details.code}
                    </div>
                    <div style="padding: 10px">
                    <img alt="Image" src="${pageContext.request.contextPath}/resources/images/palet.png"/> <b>Device Type:</b> ${webUser.os_details.deviceType}
                    </div>
                    <div style="padding: 10px">
                        <img alt="Image" src="${pageContext.request.contextPath}/resources/images/visual.png"/>   <b>Group Name:</b> ${webUser.os_details.groupName}
                    </div>
                    <div style="padding: 10px">
                        <img alt="Image" src="${pageContext.request.contextPath}/resources/images/windows.png"/>  <b>Name:</b> ${webUser.os_details.name}
                    </div>
                    <div style="padding: 10px">
                        <img alt="Image" src="${pageContext.request.contextPath}/resources/images/robot.png"/>   <b>Manufacturer:</b> ${webUser.os_details.manufacturer}
                    </div>


                </div>
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
<script src="/resources/js/Chart.min.js"></script>
<script src="/resources/js/bootstrap.bundle.min.js"></script>
<script src="/resources/js/jquery.slimscroll.min.js"></script>
<script src="/resources/js/fastclick.js"></script>
<script src="/resources/js/jquery.dataTables.js"></script>
<script src="/resources/js/dataTables.bootstrap4.js"></script>

<script src="/resources/js/adminlte.min.js"></script>
<script src="/resources/js/demo.js"></script>
</body>
</html>
