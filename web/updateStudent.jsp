<%-- 
    Document   : updateStudent
    Created on : Feb 27, 2022, 10:19:55 PM
    Author     : PHUONG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/style.css">
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
            <h2>Update student</h2>

            <form action="update-student" method="POST">
                <input  type="hidden" name="id" value="${student.id}">
                <div class="input-box">
                    <input type="text" placeholder="Enter full name" name="name" value="${student.name}" >
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter code" name="code" value="${student.code}" >
                </div>
                <div class="policy">
                    <p> Nam  <input type="radio" name="gender" value="Nam" checked="${student.gender}"> Nữ <input type="radio" name="gender" value="Nữ" checked="${student.gender}"> </p>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter phone" name="phone" value="${student.phone}" >
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter email" name="email" value="${student.email}" >
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter address" name="address" value="${student.address}" >
                </div>
                <div class="input-box">
                    <p>Birthday</p>
                    <input type="date" name="birthday" value="${student.birthday}" >
                </div>
                <div class="input-box">
                    <p>Account</p>
                    <select name="loginId"> 
                        <c:forEach items="${acc}" var = "L">
                            <option ${L.id == student.loginId ? "selected":""} value="${L.id}"> ${L.loginAccount} </option>
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
