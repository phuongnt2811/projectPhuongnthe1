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
    <body  >

        <div class="wapper" >
            <h2><a href="adminHome"> home </a></h2>
            <h2>add mark student</h2>

            <form action="add-mark" method="POST">
                <div class="input-box">
                    <p>Course:</p> 
                    <select name="classId"> 
                        <c:forEach items="${classes}" var = "LC">
                            <option value="${LC.id}"> ${LC.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <p>Teacher:</p> 
                    <select name="teacherId"> 
                        <c:forEach items="${teachers}" var = "T">
                            <option value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <p>Teacher:</p> 
                    <select name="studentId"> 
                        <c:forEach items="${students}" var = "T">
                            <option value="${T.id}"> ${T.name} </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark listening" name="listening" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark writting" name="writting" value="" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark reading" name="reading" value="" required>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter mark speaking" name="speaking" value="" required>
                </div>
                <div class="input-box">
                    <input type="submit" name="save" value="submit">
                </div>
            </form>
        </div>
    </body>
</html>