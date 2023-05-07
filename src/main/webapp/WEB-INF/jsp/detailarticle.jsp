<%@ page import="com.spring.springmvc_v_finale.model.Article" %><%--
  Created by IntelliJ IDEA.
  User: Myranto
  Date: 17/03/2023
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>detail article</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<%
    Article article = (Article) request.getAttribute("article");
%>
    <h1><%= article.getName() %></h1>
    <h2>Category : <%= article.getCategory().getName_category() %></h2>
    <p><%= article.getDescription() %></p>


</body>
</html>
