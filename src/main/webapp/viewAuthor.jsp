<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrdru
  Date: 14.09.2018
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width=430>

    <tr>
        <td><form action="/submit" method="post">
            <input type="submit" value=" Сохранить "></form></td>

        <td><form action="http://localhost:8080/parent-project-1.0-SNAPSHOT/ecm/persons/update/delete/">
            <input type="submit" value=" Удалить "></form></td>

        <td><form action="http://localhost:8080/parent-project-1.0-SNAPSHOT/ecm/persons/">
            <input type="submit" value=" Закрыть "></form></td>
    </tr>
    <tr>
        <form>
            <c:set var="person" value="${person}"/>
            <b>Фамилия:</b><br>
            <input name="surname" type="text" size="40" value=${person.surname}><br>

            <b>Имя:</b><br>
            <input name="firstName" type="text" size="40" value=${person.firstName}><br><br>

            <b>Отчество:</b><br>
            <input name="lastName" type="text" size="40" value=${person.lastName}><br><br>

            <b>Дата рождения:</b><br>
            <input name="birthday" type="text" size="40" value=${person.birthday}><br><br>

            <b>Должность:</b><br>
            <input name="post" type="text" size="40" value=${person.post}><br><br>

        </form>
    </tr>
</table>
</body>
</html>
