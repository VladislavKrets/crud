<%--
  Created by IntelliJ IDEA.
  User: Slava
  Date: 20.07.2016
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
    <link href="../../style.css" rel="stylesheet" type="text/css">

</head>
<body>
<h1>
    Search result:
</h1>
<c:if test="${!empty searchResult}">
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
            <th>ADMIN</th>
            <th>CREATE/EDIT DATE</th>
            <th class="clear"></th>
            <th class="clear"></th>
        </tr>
        <c:forEach items="${searchResult}" var="user">

            <tr>
                <td width="80">${user.id}</td>
                <td width="120">${user.name}</td>
                <td width="120">${user.age}</td>
                <td width="120">${user.admin}</td>
                <td width="200">${user.createDate}</td>
                <td width="120"><a href="<c:url value='/edit/${user.id}/'/>">Edit</a></td>
                <td width="120"><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/users">Back</a>
</body>
</html>
