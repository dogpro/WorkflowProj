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
    <script src="${pageContext.request.contextPath}/js/post.js"></script>
</head>
<body>
<table width=430>
    <tr>
        <form>
            <c:set var="person" value="${person}"/>
            <b>Идентификатор:</b><br>
            <input id="id" type="text" size="40" value="${person.id}"><br>

            <b>Фамилия:</b><br>
            <input id="surname" type="text" size="40" value=${person.surname}><br>

            <b>Имя:</b><br>
            <input id="firstName" type="text" size="40" value=${person.firstName}><br><br>

            <b>Отчество:</b><br>
            <input id="lastName" type="text" size="40" value=${person.lastName}><br><br>

            <b>Дата рождения:</b><br>
            <input id="birthday" type="text" size="40" value=${person.birthday}><br><br>

            <b>Должность:</b><br>
            <input id="post" type="text" size="40" value=${person.post}><br><br>

            <b>Фото:</b><br>
            <input id="photo" type="text" size="40" value=${person.photo}><br><br>

            <input id="update" type="button" value=" Сохранить " onclick="getData('/ecm/persons/update')">

            <input id="delete" type="button" value=" Удалить " onclick="getData('/ecm/persons/update/delete')">

            <input type="button" value=" Закрыть " onclick="location.href=back()">
        </form>
    </tr>
</table>
</body>
</html>
