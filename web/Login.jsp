<%-- 
    Document   : Login
    Created on : Feb 6, 2022, 1:14:55 AM
    Author     : PHUONG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel ="icon" href="image/index/Jell center.png" type="image/x-icon">

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--        <link rel="stylesheet" href="CSS/login.css">-->
        <link rel="stylesheet" href="index.js">
        <title>Jell Center</title>
    </head>



    <body>

        <div id ="login">
            <div class="logo">
                <img src="image/index/Jell center.png" alt="logo">
            </div>
            <div class="content">
                <form action="login-control" method="post">
                    <td><input type="text" name="username" class="form-control" placeholder=  "Account" > <br></td>
                    <td><input type="password" name="password" class="form-control" placeholder="Password"> <br></td> 
<!--                    <td><input type="checkbox" name="remember" value="true"> Remember me </td> -->
                    <a href="update-pasword"> Forgot password?</a> <br>
                    <h4 style="color: red">${error} </h4>

                    <div class="Submit">
                        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login"> 
                    </div>

                </form> 
            </div>


        </div>

    </body>
    <style>
        @keyframes animate {
            /* bắt đầu và tăng dần từ 0-100 rồi lại quay về 0 */
            0%,
            100% {
                background-image: url(image/index/1.jpg);
            }

            20% {
                background-image: url(image/index/2.jpg);
            }

            40% {
                background-image: url(image/index/3.jpg);
            }

            60% {
                background-image: url(image/index/4.jpg);
            }

            80% {
                background-image: url(image/index/5.jpg);
            }

            100% {
                background-image: url(image/index/6.jpg);
            }
        }

        body {
            position: relative;
            color: black;
            animation: animate 25s ease-in-out infinite;
            background-size: cover;
            text-align: center;
            margin: 150px auto;

            /* margin-top: 50px; */
        }

        body {
            height: auto;
            width: 30%;

        }

        #login {
            min-height: 100px;
            display: inline-block; 
            padding: 10px;
            background-color: #ffffffcc;
            justify-content: center;
            align-items: center;
        }

        .form-control {
            position: relative;
            font-size: 16px;
            height: auto;
            padding: 10px;
            border: 1px solid gray;	
        }
        .form-select {
            position: relative;
            font-size: 16px;
            height: 40px;
            width: 150px;
            padding: 10px;
            border: 1px solid gray; 
            margin-bottom: 10px;
        }

        input[type="text"] {
            margin-bottom: -1px;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
        }

        input[type="password"] {
            margin-bottom: 20px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
        .logo img{
            display: inline-block;
            height: 250px;
            width: 250px;

        }

        input[type = "submit"]{
            margin-top: 10px;
            margin-bottom: 20px;
            min-height: 30px;
            width: 150px;
            height: 40px;
            font-size: 16px;
            text-align: center;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
            background-color: rgb(106, 106, 235);
            border: 1px solid activeborder;
        }

    </style>
</html>