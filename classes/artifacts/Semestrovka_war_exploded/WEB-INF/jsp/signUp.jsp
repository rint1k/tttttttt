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
            <input class="form-control" type="text" name="login" placeholder="Логин" size="10"><br>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Пароль"></div>
            <div class="form-group"><input class="form-control" type="password2" name="password" placeholder="Повторите пароль"></div><input class="form-control" type="text" name="firstname" placeholder="Имя"><br>
            <input class="form-control" type="text" name="secondname" placeholder="Фамилия"><br>
            <input class="form-control" type="text" name="patronymic" placeholder="Отчество"><br>
            <input class="form-control" type="text" name="email" placeholder="e-mail"><br>
            <input class="form-control" type="text" name="birthday"
                   placeholder="Дата Рождения(дд.мм.гггг)"><br>
            <input class="form-control" type="text" name="sex" placeholder="Пол"><br>
            <input class="form-control" type="text" name="age" placeholder="Возраст"><br>
            <input class="form-control" type="text" name="address" placeholder="Адрес"><br>
            <input class="form-control" type="text" name="phone" placeholder="Телефон"><br>
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
                <div class="form-check"><label class="form-check-label"><input class="form-check-input" name="" type="checkbox">Я
                    даю согласие на обработку персональных данных.</label></div>
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Зарегистрироваться</button>
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