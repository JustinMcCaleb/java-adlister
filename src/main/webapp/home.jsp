<%--
  Created by IntelliJ IDEA.
  User: justinleemccaleb
  Date: 7/14/20
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String firstName = "Justin";
    String lastName = "McCaleb";
%>
<%--<%! String lastName = "McCaleb"; %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Include navbar--%>
<%@ include file ="partials/navbar.jsp"%>

<h1>Hello, <%= firstName %> <%= lastName %>!</h1>
<%--include aboutme--%>
<%@ include file ="partials/aboutme.jsp"%>

<%--Forms--%>
<h3>What would you like to do?</h3>

<h3>View Your Profile</h3>
<form action="user-profile.jsp" method="get">
    <input type="hidden" id="username" name="username" value="Justin">
    <button type="submit">Go There Now</button>
</form>

<h3>Add a To Do</h3>
<form action="todo.jsp" method="post">
    <input type="text" id="item" name="item">
    <button type="submit">Add to List</button>
</form>

<%--include footer--%>
<%@ include file ="partials/footer.jsp"%>


</body>
</html>
