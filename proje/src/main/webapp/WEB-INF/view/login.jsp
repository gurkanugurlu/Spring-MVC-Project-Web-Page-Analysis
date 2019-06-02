<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/css/adminlte.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/resources/css/blue.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <h1>
      <a class="navbar-brand logo editContent" href="/home/index">
        <span class="fa fa-angellist"></span> Aegis
      </a>
    </h1>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg"><b> Lets Become Aegis.</b></p>

      <form action="/admin/login" method="post">
        <div class="form-group has-feedback">
          <input type="email" class="form-control" placeholder="Email" name="mail">
          <span class="fa fa-envelope form-control-feedback" style="padding-left: 3px"></span>
        </div>
        <div class="form-group has-feedback">
          <input type="password" class="form-control" placeholder="Password" name="password">
          <span class="fa fa-lock form-control-feedback"style="padding-left: 3px"></span>
        </div>
        <div class="row">
          <div class="col-8">
        </div>
          <!-- /.col -->
          <div class="col-4" style="padding-right: 125px">
            <button type="submit" class="btn btn-primary">Login</button>
          </div>
          <!-- /.col -->
        </div>
      </form>


      <!-- /.social-auth-links -->

    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="/resources/js/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/js/bootstrap.bundle.min.js"></script>
<!-- iCheck -->
<script src="/resources/js/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass   : 'iradio_square-blue',
      increaseArea : '20%' // optional
    })
  })
</script>

</body>
</html>
