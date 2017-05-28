
<%--
  Created by IntelliJ IDEA.
  User: цифра
  Date: 27.05.2017
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
<p> Hello, ${requestScope.user.getName()} ${requestScope.user.getSecondName()}.
<p> Your e-mail: ${requestScope.user.getMail()}
</body>
</html>
