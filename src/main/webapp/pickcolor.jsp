<%--
  Created by IntelliJ IDEA.
  User: justinleemccaleb
  Date: 7/15/20
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.


#### Color Page

A user goes to a url "/pickcolor.jsp". On the "pickcolor.jsp" page, the user is prompted to enter their favorite color. Upon clicking submit, they are redirected to a page with a background color of their favorite color.

- use a POST request on the form
- use two JSPs
- use style tags
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="partials/head.jsp"%>
    <body>
        <form method="post" action="favcolorbackground.jsp">
            <label for="favcolor">Input your favorite color!</label>
            <input type="text" id="favcolor" name="favcolor">
            <button type="submit">Submit</button>
        </form>

    </body>
</html>
