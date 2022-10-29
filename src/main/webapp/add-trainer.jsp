<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" import="parsers.DateFormatters" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="card text-center">

    <div class="card-header" style="margin-top: 100px">
        <h1>InfoShare Trainer Managing System</h1>
        <h5>Please enter data of new trainer</h5>
    </div>

<div>

    <form method="post" action="${pageContext.request.contextPath}/add-trainer">
        <div class="form-group row" align="left" style="margin: 10px">
            <label for="inputName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="inputName" name="name" placeholder="Enter name">
            </div>
        </div>
        <div class="form-group row" align="left" style="margin: 10px">
            <label for="inputSurname" class="col-sm-2 col-form-label">Surname</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="inputSurname" name="surname" placeholder="Enter email">
            </div>
        </div>
        <div class="form-group row" align="left" style="margin: 10px">
            <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="inputEmail" name="email" aria-describedby="emailHelp" placeholder="Enter email">
            </div>
        </div>
        <div class="form-group row" align="left" style="margin: 10px">
            <label for="inputPhone" class="col-sm-2 col-form-label">Phone</label>
            <div class="col-sm-4">
                <input type="tel" class="form-control" id="inputPhone" name="phone" placeholder="Enter phone number">
            </div>
        </div>
        <div class="col-sm-6 col-form-label">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
</div>
</html>