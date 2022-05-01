<%-- 
    Document   : weekday
    Created on : Mar 6, 2022, 11:23:28 AM
    Author     : PHUONG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${weekday}" var="weekday">
                <tr>
                   
                    <td>${weekday.id}</td>
                    <td>${weekday.name}</td>
                
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
