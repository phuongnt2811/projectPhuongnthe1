<%-- 
    Document   : updateLevel
    Created on : Mar 2, 2022, 5:53:41 PM
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

            <form action="update-level" method="POST">
                <input  type="hidden" name="id" value="${level.id}">
                <div class="input-box">
                    <input type="text" placeholder="Enter full name" name="name" value="${level.name}" >
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter sign code" name="code" value="${level.signCode}" >
                </div>

                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>
        </div>
    </body>
</html>

