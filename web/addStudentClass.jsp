<%-- 
    Document   : addStudentClass
    Created on : Mar 5, 2022, 6:35:15 PM
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
        <form action="add-student-class" method="POST">
            <table border="1">              
                <td>Class</td>
                <td><select name="classId"> 
                        <c:forEach items="${listC}" var = "T">
                            <option value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select> </td>
                </tr>
                <tr>
                    <td>Student code</td>
                    <td><select name="studentId"> 
                            <td><input type="text" placeholder="Enter code" name="code" value="" required></td>
                            <c:forEach items="${listS}" var = "LS">
                                <option value="${LS.id}"> ${LS.code} | ${LS.name}</option>
                            </c:forEach>

                        </select> </td>
                </tr>
                
                <tr>
                    <td>Submit</td>
                    <td><input type="submit" name="Save" value="Submit"> </td>
                </tr>
            </table>

    </body>
</html>
