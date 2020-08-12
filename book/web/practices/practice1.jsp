<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wujun
  Date: 2020/8/11
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求重定向</title>
    <style>
        table{
            border:1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border:1px red solid;
        }
    </style>
</head>
<body>

<%--输出表格，里面有3个用户信息--%>

    <%
//        List<User> userList  = new ArrayList<User>();
//        for (int i = 0; i < 3; i++){
//            userList.add(new User(i+1,"name"+i,"password","name"+i+"@gmail.com"));
//        }
        List<User> userList = (List<User>) request.getAttribute("userList");
    %>

<table>
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>邮箱</td>
    </tr>
    <% for(User user:userList) {  %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getEmail()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
