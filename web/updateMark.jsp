<%-- 
    Document   : updateCourse
    Created on : Mar 3, 2022, 11:51:10 PM
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
            <h2>Update teacher</h2>

            <form action="update-mark" method="POST">
                <input  type="hidden" name="id" value="${ma.id}">
                <div class="input-box">
                    <p>CLass:</p> 
                    <select name="classId"> 
                        <c:forEach items="${listC}" var = "LC">
                            <option ${LC.id == ma.classId? "selected":""} value="${LC.id}"> ${LC.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <p>Teacher</p> 
                    <select name="teacherId"> 
                        <c:forEach items="${listT}" var = "T">
                            <option ${T.id == ma.teacherId? "selected":""} value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <p>Student:</p> 
                    <select name="studentId"> 
                        <c:forEach items="${listS}" var = "T">
                            <option ${T.id == ma.studentId? "selected":""} value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark listening" name="listening" value = "${ma.listening}"required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark writting" name="writting" value="${ma.writting}" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark reading" name="reading" value="${ma.reading}" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark speaking" name="speaking" value="${ma.speaking}" required>
                </div>

                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>
        </div>
    </body>
</html>
