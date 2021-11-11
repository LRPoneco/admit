<%--
  Created by IntelliJ IDEA.
  User: MI
  Date: 2021/10/27
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<script>

</script>
<body>
<div>
    <li>你已经成功登录养殖管理系统！</li>
</div>
<table align="center">
</table>
<a href="../index.jsp">返回首页</a>
<a href="exit.jsp">退出登录！</a>
<%
    int count = (int)session.getAttribute("count");
    for ( int fontSize = 1; fontSize <=count; fontSize++){
        out.print("pdgjskgfdkngfsngsdngdl");
    }
%>
</body>
</html>
