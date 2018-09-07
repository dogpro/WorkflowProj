<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Authors</title>
    </head>
    <body>
        <table>
            <c:forEach var="person" items="${persons}">
                <tr class="font" style="height: 32px">
                    <td scope="row" ><a href="http://localhost:8080/parent-project-1.0-SNAPSHOT/Documents?id=${person.id}">
                                    ${person.surname} ${person.firstName} ${person.lastName}</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
