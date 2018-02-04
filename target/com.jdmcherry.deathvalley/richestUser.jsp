<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0">
    <thead>
    <th>Name</th>
    <th>Surname</th>
    <th>Balance</th>
    </thead>
    <tbody>
    <c:forEach items="${richestUser}" var="account">
        <tr>
            <td><c:out value="${account.user.name}"/></td>
            <td><c:out value="${account.user.surname}"/></td>
            <td><c:out value="${account.balance}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
