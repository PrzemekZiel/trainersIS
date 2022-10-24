<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 06.10.2022
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" import="parsers.DateFormatters" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<style>
    {
        flex: auto;
    }
</style>

<div class="card text-center">
    <div class="card-header" style="margin-top: 100px">
        <h1>InfoShare Trainer Managing System</h1>
        <h5> Now is ${DateFormatters.displayDate()}</h5>
    </div>
</div>

<body>
<h3>There are ${trainers.size()} trainer(s) in our base.</h3>

<div class="table table-striped">
    <table>
        <th>Numbers</th>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Phone</th>
        <th></th>
        <th></th>
        <c:forEach var="trainer" items="${trainers}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${trainer.trainerId}"/> </td>
                <td><c:out value="${trainer.name}"/> </td>
                <td><c:out value="${trainer.surname}"/> </td>
                <td><c:out value="${trainer.email}"/> </td>
                <td><c:out value="${trainer.phone}"/></td>
                <td>
                    <form class="d-flex" method="post" action="${pageContext.request.contextPath}/delete">
                        <label>
                            <input hidden name="trainerId" value="${trainer.trainerId}" >
                        </label>
                        <button class="btn btn-outline-success" type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form class="d-flex" method="post" action="${pageContext.request.contextPath}/edit">
                        <label>
                            <input hidden name="trainerId" value="${trainer.trainerId}">
                        </label>
                        <button class="btn btn-outline-success" type="submit">Edit</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <p style="text-align:center">You may add new trainer by clicking <a href="${pageContext.request.contextPath}/add-trainer.jsp">here</a> or go
        back to the <a href="index.jsp">main page</a>.</p>
</div>

</body>
</html>