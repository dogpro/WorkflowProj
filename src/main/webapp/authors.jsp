<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Authors</title>
    </head>
    <body>
    <form action="http://localhost:8080/parent-project-1.0-SNAPSHOT/createAuthor.jsp">
        <p><input type="submit" value=" Создать нового сотруддника " onclick="getData('createAuthor/')"></p>
    </form>
    <table>
        <c:forEach var="person" items="${persons}">
            <tr class="font" style="height: 32px">
                <td scope="row" ><a href="http://localhost:8080/parent-project-1.0-SNAPSHOT/ecm/persons/documents/${person.id}">
                        ${person.surname} ${person.firstName} ${person.lastName}</a></td>
                <td><form action="http://localhost:8080/parent-project-1.0-SNAPSHOT/ecm/persons/update/${person.id}">
                    <p><input type="submit" value=" Открыть карточку "></p>
                </form></td>
            </tr>
        </c:forEach>

    </table>
    </body>
</html>
