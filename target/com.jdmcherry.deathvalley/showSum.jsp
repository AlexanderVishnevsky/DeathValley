<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
Sum of all the accounts in the bank:
<br>
    <%
        User userList = (User) request.getAttribute("getSum");

        if (userList != null) {
                out.println("<td>" + userList.getAmount() + "</tr>");

        } else out.println("<p>There are no users yet!</p>");
    %>

<br>
<button onclick="location.href='/'">Back to main</button>
</body>
</html>
