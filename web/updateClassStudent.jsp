<%-- 
    Document   : updateClassStudent
    Created on : Mar 5, 2022, 8:48:02 PM
    Author     : PHUONG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="CSS/style.css">
        <title>JSP Page</title>
    <title>Document</title>
    </head>
    <style>
        body{
            background-color: #EEEEF1;
        }
        .wapper{
            position: relative;
            max-width: 1100px;
            height : 600px;
            margin-top: 20px;
        }
    </style>
    <body>
        <div class="wapper">
            <h2><a href="adminHome"> home </a></h2>
            <h2>Update class student</h2>

            <form action="update-student-class" method="POST">
                 
                <input  type="hidden" name="id" value="${listCSa.id}">
                
                <div class="input-box">
                    <p>Class:</p>
                    <select name="classId"> 
                        <c:forEach items="${listC}" var = "T">
                            <option ${listCSa.classId == T.id ?"selected":""} value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select>
                </div>
                
                <div class="input-box">
                    <p>Student:</p>
                    <select name="studentId"> 
                            <c:forEach items="${listS}" var = "LS">
                                <option ${listCSa.studentId == LS.id ?"selected":""} value="${LS.id}"> ${LS.code} | ${LS.name}</option>
                            </c:forEach>

                        </select>
                </div>
                
                
                
                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>
        </div>
        
    </body>
</html>
