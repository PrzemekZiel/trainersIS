<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" import="parsers.DateFormatters" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<div class="card text-center">
    <div class="card-header" style="margin-top: 100px">
        <h1>InfoShare Trainer Managing System</h1>
        <h5>${requestScope.getAttribute(errorMessage)}</h5>
        <h5>System designed to manage trainers and their activities.<br> Select option in Navbar above for desired action.</h5>
    </div>
</div>

</html>