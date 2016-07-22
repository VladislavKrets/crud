<%--
  Created by IntelliJ IDEA.
  User: Slava
  Date: 19.07.2016
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<head>
    <title>List Of Users</title>
    <link href="../../style.css" rel="stylesheet" type="text/css">

</head>

<h1>
    User list
</h1>
<c:if test="${!empty listUsers}">
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
        <c:forEach items="${listUsers}" var="user">

            <tr>
                <td width="80">${user.id}</td>
                <td width="120">${user.name}</td>
                <td width="120">${user.age}</td>
                <td width="120">${user.admin}</td>
                <td width="200">${user.createDate}</td>
                <td width="120"><a href="<c:url value='/edit/${user.id}/?page=${page}'/>">Edit</a></td>
                <td width="120"><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

Pages:
<c:choose>
    <c:when test="${numberOfRecords%10==0}">
        <c:forEach begin="0" end="${numberOfRecords/10-1}" var="x">
            <a href="/users/?page=${x}"> ${x+1}</a>
        </c:forEach>
    </c:when>
    <c:when test="${numberOfRecords%10!=0}">
        <c:forEach begin="0" end="${numberOfRecords/10}" var="x">
            <a href="/users/?page=${x}"> ${x+1}</a>
        </c:forEach>
    </c:when>
</c:choose>

<h1>${message}</h1>

<c:url var="addAction" value="/users/add"/>
<form:form action="${addAction}" commandName="userEntity">
    <c:if test="${!empty userEntity.name}">

        <div class="layer1">
            <div class="layer2">
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </div>
            <form:input path="id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="id"/>
        </div>
    </c:if>
    <div class="layer1">
        <div class="layer2">
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </div>
        <form:input path="name"/>
    </div>

    <div class="layer1">
        <div class="layer2">
            <form:label path="age">
                <spring:message text="Age"/>
            </form:label>
        </div>
        <form:input path="age"/>
    </div>
    <div class="layer1">
        <div class="layer2">
            Admin?
        </div>
        <div class="center"><form:checkbox path="admin"/></div>
    </div>


    <div class="button">
        <c:if test="${!empty userEntity.name}">
            <input type="submit"
                   value="<spring:message text="Edit User"/>"/>
        </c:if>
        <c:if test="${empty userEntity.name}">
            <input type="submit"
                   value="<spring:message text="Add User"/>"/>
        </c:if>
    </div>
</form:form>
<c:url var="searchAction" value="/search"/>

<h1>Search users by name</h1>

<div class="layer1">
<div class="layer2">
    User name
</div>

<form:form action="${searchAction}" commandName="search">
    <input type="text" id="txt" name="searchString">
    </div>
    <div class="button">
        <button id="button-id" type="submit">Search</button>
    </div>
</form:form>

</body>
</html>
