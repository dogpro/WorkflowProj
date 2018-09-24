<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Documents</title>
    </head>
    <body>
        <table>
            <c:forEach var="document" items="${document}">
                <tr class="font" style="height: 32px">
                    <td scope="row" ><a href="http://localhost:8080/parent-project-1.0-SNAPSHOT/ecm/persons/document/${document.id}">
                        №${document.id} ${document.name}</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
