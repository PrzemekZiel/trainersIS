<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" import="parsers.DateFormatters" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
      <a href="index.jsp">main page</a>.</p>
  </div>
</div>