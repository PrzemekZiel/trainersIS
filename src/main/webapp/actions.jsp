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
        <h5> Now is ${DateFormatters.displayDate()}</>
    </div>
</div>

<body>
<h3>There are ${actions.size()} action(s) in our base.</h3>

<div class="table table-striped">
    <table>
        <th>Numbers</th>
        <th>IP</th>
        <th>Action Type</th>
        <th>Date</th>
        <th>Admin Email</th>
        <th></th>
        <c:forEach var="action" items="${actions}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${action.userIP}"/> </td>
                <td><c:out value="${action.actionType}"/> </td>
                <td><c:out value="${action.date}"/> </td>
                <td><c:out value="${action.adminEmail}"/> </td>
                <td>
                    <form class="d-flex" method="post" action="${pageContext.request.contextPath}/edit">
                        <label>
                            <input hidden name="trainerId" value="${action.urlLink}">
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
