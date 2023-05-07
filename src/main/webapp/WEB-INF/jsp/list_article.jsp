<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.springmvc_v_finale.model.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArticleHardi | Hardi</title>
    <link rel="stylesheet" href="<c:url value='/ressources/theme/bootstrap/css/bootstrap.min.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/fonts/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/css/Login-Form-Basic-icons.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/css/Sidebar-Menu-sidebar.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/css/Sidebar-Menu.css' />">
    <meta name="description" content="Hardi est celibataire">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<%
    ArrayList<Article> list = (ArrayList<Article>) request.getAttribute("list");
%>
    <h1>Article Hardi</h1>
</body>
</html>
