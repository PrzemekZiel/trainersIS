<%@ page contentType="text/html;charset=UTF-8" %>

<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>TrainersManagingSystem</title>
</head>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">

  <a class="navbar-brand" href="index.html">Main Page</a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarCommands">
    <ul class="navbar-nav pull-left">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownTrainerMenu" data-toggle="dropdown"
           role="button" aria-haspopup="true" aria-expanded="false">Trainer Menu<span class="caret"></span>
        </a>
        <div class="dropdown-menu dropdown-menu-left" aria-labelledby="dropdownTrainerMenu">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/base">List of trainers</a>
          <a class="dropdown-item" href="add-trainer.html">Add trainer</a>
        </div>
      </li>
      <li class="nav-item active">
        <a class="nav-link" aria-current="page" href="/track">Tracking</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/info">Info</a>
      </li>
    </ul>

    <ul class="navbar-nav pull-left">
      <li class="nav-item dropdown">
        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          Profile <span class="caret"></span>
        </a>
        <div class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="login.html">Log in</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log out</a>
        </div>
      </li>
    </ul>

    <form class="d-flex" method="get" action="search">
      <input class="form-control me-2" type="text" name="query" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>

  </div>

</nav>


<div class="card text-center">

  <div class="card-header" style="margin-top: 100px">
    <h4>InfoShare Trainer Managing System</h4>
  </div>

  <div class="form-group">
    <h1>Hi ${admin.getName()}, you are successfully logged.</h1>
  </div>
  <div>
    <p style="text-align:center">You may check the base by clicking <a href="${pageContext.request.contextPath}/base">here</a> or go
      back to the
      <a href="index.html">main page</a>.</p>
  </div>
</div>

