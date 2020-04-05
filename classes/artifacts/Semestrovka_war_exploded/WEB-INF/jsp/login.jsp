<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="login">
    <table>
        <tr>
            <td>
                <label>
                    Username:
                </label>
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    Password:
                </label>
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Login">
            </td>
        </tr>
    </table>
</form>
<br>
<a href="/HW104_war_exploded/signup">Register</a>
</body>
</html>