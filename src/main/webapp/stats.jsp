<%@ include file="navbar.html"%>
<%@ page contentType="text/html;charset=UTF-8" import="parsers.DateFormatters" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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

<div class="table table-striped">
    <table>
        <th>Number</th>
        <th>Action Type</th>
        <th>Occurrence</th>
        <th>Percentage</th>
        <c:forEach var="stat" items="${statistics}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${stat[0]}"/> </td>
                <td><c:out value="${stat[1]}"/> </td>
                <td><fmt:formatNumber value="${stat[1] / actions.size()*100}" maxFractionDigits="2"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <p style="text-align:center">You may see all actions by clicking <a href="${pageContext.request.contextPath}/actions">here</a> or go
        back to the <a href="index.jsp">main page</a>.</p>
</div>

</body>
</html>

