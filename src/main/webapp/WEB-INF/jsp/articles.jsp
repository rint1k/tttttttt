<%@ page import="models.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<div align="center">
    <% Article[] articles = (Article[]) request.getSession().getAttribute("articles");
        for (Article a : articles) {
        out.print("<p>" + a.getArticleText() + "</p><br>");
        }%>
</div>
</body>
</html>
