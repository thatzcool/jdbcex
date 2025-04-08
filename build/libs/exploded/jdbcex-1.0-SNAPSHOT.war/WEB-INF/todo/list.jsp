<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-04-07
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo List Page<h1>
    <ul>
        <c:forEach items="${dtoList}" var ="dto">
            <li> ${dto}</li>
        </c:forEach>
    </ul>

</body>
</html>
