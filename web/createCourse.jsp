<%-- 
    Document   : createCourse
    Created on : Mar 2, 2022, 9:14:11 PM
    Author     : PHUONG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/style.css">
        <title>JSP Page</title>
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
        <div class="wapper" >
            <h2><a href="adminHome"> home </a></h2>
            <h2>Create course</h2>

            <form action="create-course" method="POST">
                <div class="input-box">
                    <input type="text" placeholder="Enter full name" name="name" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter lesson" name="code" required>
                </div>

                <div class="input-box">
                    <input type="text" placeholder="Enter prize" name="email" value="" required>
                </div>
                <div class="input-box">
                    <select name="levelId"> 
                        <c:forEach items="${listLevel}" var = "L">
                            <option value="${L.id}"> ${L.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>

    </body>
</html>
