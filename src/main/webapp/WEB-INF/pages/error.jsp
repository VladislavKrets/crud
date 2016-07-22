<%--
  Created by IntelliJ IDEA.
  User: Slava
  Date: 22.07.2016
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Error Page</title>
</head>
<body>
Exception occured!
<br>
<h3>${exception.cause.message}</h3>

</body>
</html>
