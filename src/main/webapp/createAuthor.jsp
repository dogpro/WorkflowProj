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
        <td><form action="">
            <input type="button" value=" Сохранить " onclick="ok()"></form></td>

        <td><form action="http://localhost:8080/parent-project-1.0-SNAPSHOT/authors.jsp">
            <input type="button" onclick="history.back();" value=" Закрыть "></form></td>
    </tr>
    <tr>
        <form>
            <b>Фамилия:</b><br>
            <input type="text" size="40" id="surname"><br>

            <b>Имя:</b><br>
            <input type="text" size="40"><br><br>

            <b>Отчество:</b><br>
            <input type="text" size="40"><br><br>

            <b>Дата рождения:</b><br>
            <input type="text" size="40"><br><br>

            <b>Должность:</b><br>
            <input type="text" size="40"><br><br>

            <span id="ajaxCreateUserServletResponse"></span>
        </form>

    </tr>
</table>
</body>
</html>