<%--
  Created by IntelliJ IDEA.
  User: justinleemccaleb
  Date: 7/23/20
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Register"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />

<div class="container">
    <h1>Register as a User</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>

</body>
</html>
