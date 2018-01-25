<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>

<table border="1">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Amount</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<User> userList = (List<User>) request.getAttribute("getUser");

        if (userList != null && !userList.isEmpty()) {
            for (User s : userList) {
                out.println("<tr>" + "<td>" + s.getName() + "<td>" + s.getSurName() + "<td>" + s.getAmount() + "</tr>");
            }
        } else out.println("<p>There are no users yet!</p>");
    %>
    </tbody>
</table>
<br>
<button onclick="location.href='/'">Back to main</button>
</body>
</html>
