<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!
</h1>

<P>Username is ${username}</P>
<br>
<a href="<c:url value="j_spring_security_logout" />" target="_self">Logout</a>
</body>
</html>
