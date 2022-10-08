<%@ include file="navbar.html"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<div class="card text-center">

    <div class="card-header" style="margin-top: 100px">
        <h1>InfoShare Trainer Managing System</h1>

    </div>

</div>
<body>

<div>
    <table class="table table-striped">
    <th>Name</th>
    <th>Surname</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Actions</th>
    <c:forEach var="trainer" items="${textToFind}">
        <tr>
            <td><c:out value="${trainer.name}" /></td>
            <td><c:out value="${trainer.surname}" /></td>
            <td><c:out value="${trainer.email}" /></td>
            <td><c:out value="${trainer.phone}" /></td>
            <td>
                <div>
                    <form action="/delete" method="post">
                        <input type="submit" title="delete" value="${trainer.trainerId}" name="trainerId">
                    </form>
                </div>
                <div>
                    <form action="/edit" method="post">
                        <input type="submit" title="edit" value="${trainer.trainerId}" name="trainerId">
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
    </table>
</div>

<br><br>

</body>
</html>

