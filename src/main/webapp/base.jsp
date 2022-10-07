<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 06.10.2022
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<style>
    table, th, td
    {
        border: 1px solid black;
    }
    div
    {
        flex: auto;
    }
</style>

<div class="card text-center">
    <div class="card-header" style="margin-top: 100px">
        <h1>InfoShare Trainer Managing System</h1>
    </div>
</div>

<body>
<div class="table">
    <h3>There are ${trainers.size()} trainers in our base.</h3>
    <table>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Actions</th>
        <c:forEach var="trainer" items="${trainers}">
            <tr>
                <td><c:out value="${trainer.trainerId}"/> </td>
                <td><c:out value="${trainer.name}"/> </td>
                <td><c:out value="${trainer.surname}"/> </td>
                <td><c:out value="${trainer.email}"/> </td>
                <td><c:out value="${trainer.phone}"/></td>
                <td>
                    <div>
                        <button>
                            <form action="/delete" method="post">
                                <input type="submit" value="${trainer.trainerId}">
                            </form>
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>