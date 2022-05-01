<%-- 
    Document   : updateClass
    Created on : Mar 5, 2022, 3:28:25 PM
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

            <form action="update-class" method="POST">
                <input  type="hidden" name="id" value="${classes.id}">
                <div class="input-box">
                    <input type="text" placeholder="Enter class name" name="name" value="${classes.name}" >
                </div>

                <div class="input-box">
                    <p style="padding: 0 15px;">Start date</p>
                    <input type="date"  name="startdate" value="${classes.startdate}" >
                </div>
                <div class="input-box">
                    <p style="padding: 0 15px;">End date</p>
                    <input type="date" name="endate" value="${classes.endate}" >
                </div>

                <div class="input-box">
                    <p style="padding: 0 15px;">Money</p>
                    <input type="text" placeholder="Enter prize" name="email" value="${course.money}" >
                </div>

                <div class="input-box">
                    <p style="padding: 0 15px;">Teacher</p>
                    <select name="teacherId"> 
                        <c:forEach items="${listTeacher}" var = "T">
                            <option ${classes.teacherId == T.id ? "selected":""} value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <p style="padding: 0 15px;">Course</p>
                    <select name="courseId"> 
                        <c:forEach items="${listCourse}" var = "LC">
                            <option ${classes.courseId == T.id ? "selected":""} value="${LC.id}"> ${LC.name} </option>
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
