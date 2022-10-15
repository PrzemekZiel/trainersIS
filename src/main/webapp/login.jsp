<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" import="parsers.DateFormatters" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="card text-center">

  <div class="card-header" style="margin-top: 100px">
    <h1>InfoShare Trainer Managing System</h1>
    <h5>You must be logged to work!</h5>
  </div>

<div>

<form method="get" action="/login">
  <div class="form-group row" align="left" style="margin: 10px">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Login (email address)</label>
    <div class="col-sm-4">
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Enter email">
    </div>
  </div>
  <div class="form-group row" align="left" style="margin: 10px">
    <label for="exampleInputPassword1" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-4">
    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
    </div>
  </div>
  <div class="col-sm-6 col-form-label">
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>
</div>
</div>