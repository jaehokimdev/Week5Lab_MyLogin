<%-- 
    Document   : home
    Created on : Oct 5, 2022, 10:37:04 PM
    Author     : joekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Home page</h1>
        <h2>Hello ${loginUser.username}.</h2>
        <a href="login?action=logout">Log out</a>
    </body>
</html>
