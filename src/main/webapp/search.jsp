<%@ include file="navbar.html"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<div class="card text-center">

    <div class="card-header" style="margin-top: 100px">
        <h1>InfoShare Trainer Managing System</h1>
        <h5></h5>
    </div>

</div>
<body>

<h3>There are ${textToFind.size()} trainers matching your query in our base.</h3>

<div>
    <table class="table table-striped">
    <th>Name</th>
    <th>Surname</th>
    <th>Email</th>
    <th>Phone</th>
    <c:forEach var="trainer" items="${textToFind}">
        <tr>
            <td><c:out value="${trainer.name}" /></td>
            <td><c:out value="${trainer.surname}" /></td>
            <td><c:out value="${trainer.email}" /></td>
            <td><c:out value="${trainer.phone}" /></td>
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
    <p style="text-align:center">You may check the whole base by clicking <a href="/base">here</a> or go
        back to the <a href="index.html">main page</a>.</p>
</div>

</body>
</html>

