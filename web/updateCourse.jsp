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

            <form action="update-course" method="POST">
                <input  type="hidden" name="id" value="${course.id}">
                 <div class="input-box">
                
                <input type="text" placeholder="Enter course name" name="name" value="${course.name}" >
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter lesson" name="code" value="${course.lesson}" >
                </div>
                
                <div class="input-box">
                    <input type="text" placeholder="Enter prize" name="email" value="${course.money}" >
                </div>
                
                <div class="input-box">
                    <p>Level</p>
                    <select name="levelId"> 
                        <c:forEach items="${listLevel}" var = "L">
                            <option ${L.id == course.levelId ? "selected":""} value="${L.id}"> ${L.name} </option>
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
