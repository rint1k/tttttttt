<%@ page import="models.User" %>
<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Profile</title>
    <link rel="stylesheet" href="jsp/OtherElements/profile/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="jsp/OtherElements/profile/assets/css/styles.min.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="#">${user.getUsername()}</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item" role="presentation"><a class="nav-link active"
                                                            href="<c:url value="http://localhost:8080/AboutMyself"/>">О себе</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="<c:url value="http://localhost:8080/articles"/>">Статьи</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link active"
                                                            href="<c:url value="http://localhost:8080/interests"/>">Интересы</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<script src="jsp/OtherElements/profile/assets/js/jquery.min.js"></script>
<script src="jsp/OtherElements/profile/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>