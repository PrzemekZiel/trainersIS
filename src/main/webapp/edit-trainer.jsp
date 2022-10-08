<%@ include file="navbar.html"%><

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<div class="card-header" style="margin-top: 100px">
    <h1>InfoShare Trainer Managing System</h1>
</div>

<body>
<div>
    <form action="${pageContext.request.contextPath}/update" method="post" var="trainerToEdit">
        <table class="table table-striped">
            <tr>
                <td>
                    Id:
                </td>
                <td>
                    <label>
                        <input disabled type="text" name="trainerId" value="${trainerToEdit.trainerId}">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <label>
                        <input type="text" name="name" value="${trainerToEdit.name}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Surname:
                </td>
                <td>
                    <label>
                        <input type="text" name="surname" value="${trainerToEdit.surname}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    <label>
                        <input type="text" name="email" value="${trainerToEdit.email}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Phone:
                </td>
                <td>
                    <label>
                        <input type="text" name="phone" value="${trainerToEdit.phone}"/>
                    </label>
                </td>
            </tr>

        </table>

        <form class="d-flex" method="post" action="${pageContext.request.contextPath}/edit">
            <label>
                <input hidden name="trainerId" value="${trainer.trainerId}">
            </label>
            <button class="btn btn-outline-success" type="submit">Update</button>
        </form>


    </form>


</div>


</body>
