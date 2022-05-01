<%-- 
    Document   : createLevel
    Created on : Mar 2, 2022, 5:32:03 PM
    Author     : PHUONG
--%>

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

            <form action="create-level" method="POST">
                <div class="input-box">
                    <input type="text" placeholder="Enter full name" name="name" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter sign code" name="code" required>
                </div>
                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>

    </body>
    
</html>
