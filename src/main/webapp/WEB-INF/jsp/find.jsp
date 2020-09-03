<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>registration</title>
    <link rel="stylesheet"
          href="OtherElements/registration/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="OtherElements/registration/assets/css/styles.min.css">
</head>

<body>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"
             style="background-image: url(&quot;${pageContext.request.contextPath}/OtherElements/registration/assets/img/student-education.jpg&quot;);"></div>
        <form method="post" action="/signup">
            <h2 class="text-center"><strong>Регистрация</strong>.</h2>
            <input class="form-control" type="text" name="fileName" placeholder="FileName" value=""><br>
            <input class="form-control" type="text" name="author" placeholder="Auhtor" value=""><br>
            <table>
                <tr>
                    <th>
                        <small>
                            <input type="submit" name="save" value="Сохранить">
                        </small>
                    <th>
                        <small>
                            <input type="submit" name="cancel" value="Выйти">
                        </small>
            </table>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Найти</button>
            </div>
        </form>
    </div>
</div>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"></div>
    </div>
</div>
<script src="OtherElements/registration/assets/js/jquery.min.js"></script>
<script src="OtherElements/registration/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>