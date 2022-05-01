<%-- 
    Document   : createTeacher
    Created on : Feb 28, 2022, 12:13:15 PM
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
        <link rel="stylesheet" href="CSS/index.css">
        <title>Document</title>
    </head>
    <style>
        body{
            background-color: #EEEEF1;
        }
        .wapper{
            position: relative;
            max-width: 1000px;
            height : 600px;
            margin-top: 20px;
        }
    </style>
    <body>

        <div class="wapper">
            <h2><a href="adminHome"> home </a></h2>
            <h2>Create teacher</h2>

            <form action="create-teacher" method="POST">
                <div class="input-box">
                    <input type="text" placeholder="Enter full name" name="name" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter code" name="code" required>
                </div>
                <div class="policy">
                    <p> Nam  <input type="radio" name="gender" value="Nam" checked> Nữ <input type="radio" name="gender" value="Nữ"> </p>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter phone" name="phone" value="" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter email" name="email" value="" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter address" name="address" value="" required>
                </div>
                <div class="input-box">
                    <p>Birthday</p>
                    <input type="date"  name="birthday" value="" required>
                </div>
                <div class="input-box">
                    <p>Account</p>
                    <select name="loginId"> 
                        <c:forEach items="${acc}" var = "L">
                            <option value="${L.id}"> ${L.loginAccount} </option>
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

