<%--
  Created by IntelliJ IDEA.
  User: wujun
  Date: 2020/8/11
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% request.setAttribute("key","value"); %>
JSP表达式脚本得到的值；<%=request.getAttribute("key1")%><br>
EL表达式得到的值：${key1}

</body>
</html>
