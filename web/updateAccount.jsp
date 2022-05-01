<%-- 
    Document   : updateStudent
    Created on : Feb 27, 2022, 10:19:55 PM
    Author     : PHUONG
--%>

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
            <h2><a href="adminHome"> home </a></h2>
            <h2>Update teacher</h2>

            <form action="update-account" method="POST">
                <div class="input-box">
                    <input type="text" placeholder="Enter account" name="loginAccount" value="${acc.loginAccount}" >
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter password" name="passwordAccount" value="${acc.passwordAccount}" >
                </div>
                <!--                <div class="input-box">
                                    <p>Role</p> 
                                    <input type="text" placeholder="Enter role" name="role" value="" required>
                                </div>-->
                <div class="input-box">
                    <p>Role</p> 
                    <select name="role"> 
                        <option ${acc.role eq "ADMIN" ? "selected":""} value="ADMIN">ADMIN</option>
                        <option ${acc.role eq "TEACHER" ? "selected":""} value="TEACHER">TEACHER</option>
                        <option ${acc.role eq "STUDENT" ? "selected":""} value="STUDENT">STUDENT</option>
                    </select>
                </div>
                <div class="input-box">
                    <p>${error}</p>
                </div>
                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>
        </div>
    </body>
</html>
