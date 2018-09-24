<%--
  Created by IntelliJ IDEA.
  User: mrdru
  Date: 13.09.2018
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Создание сотрудника</title>
    <script src="http://code.jquery.com/jquery-2.2.4.js"
            type="text/javascript"></script>
    <script src="js/post.js" type="text/javascript"></script>
</head>
<body>
<table width=430>
    <tr>
        <form>
            <b>Идентификатор:</b><br>
            <input id="id" type="text" size="40"><br>

            <b>Фамилия:</b><br>
            <input id="surname" type="text" size="40"><br>

            <b>Имя:</b><br>
            <input id="firstName" type="text" size="40"><br><br>

            <b>Отчество:</b><br>
            <input id="lastName" type="text" size="40"><br><br>

            <b>Дата рождения:</b><br>
            <input id="birthday" type="text" size="40"><br><br>

            <b>Должность:</b><br>
            <input id="post" type="text" size="40"><br><br>

            <b>Фото:</b><br>
            <input id="photo" type="text" size="40"><br><br>

            <input id="create" type="button" value=" Сохранить " onclick="getData('/ecm/persons/createAuthor/')">
            <input type="button" value=" Закрыть " onclick="location.href=back()">
        </form>

    </tr>
</table>
</body>
</html>