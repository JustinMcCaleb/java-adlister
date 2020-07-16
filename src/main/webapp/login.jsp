<%--
  Created by IntelliJ IDEA.
  User: justinleemccaleb
  Date: 7/15/20
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head> 
        <% request.setAttribute("title", "Login"); %> 
        <%@ include file ="partials/head.jsp" %> 
    </head>
    <body>
        <%@ include file ="partials/navbar.jsp" %>

        <h3>Login to your profile.</h3>
        <%-- Login Forms --%>
        <form method="post" action="login.jsp">
            <label for="username">Username</label>
            <input type="text" id="username" name="username">
            <br>

            <label for="password">Password</label>
            <input id="password" name="password" type="password">
            <br>

            <button type="submit">Login</button>
        </form>


<%--         Logic for checking username/password submitted--%>
        <c:choose>

            <c:when test="${param.username.equalsIgnoreCase('admin') && param.password.equalsIgnoreCase('password')}">
                <% response.sendRedirect("profile.jsp"); %>
            </c:when>

        </c:choose>

        <%@ include file ="partials/footer.jsp"%>
    </body>
</html>
