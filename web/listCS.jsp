<%-- 
    Document   : listCS
    Created on : Mar 4, 2022, 10:24:49 PM
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
        <link rel="stylesheet" href="CSS/index.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <div class="sidebar">
            <div class="logo-details">
                <i class='bx bxs-leaf'></i>
                <span class="logo_name">Jell center</span>       
            </div>
            <ul class="nav-links" >
                <li>
                    <a href="adminHome" class="active">
                        <i class='bx bxs-grid-alt' ></i>
                        <span class="links_name">Dash board</span>
                    </a>
                </li>
               <c:if test="${sessionScope.account.getRole() eq 'TEACHER' or sessionScope.account.getRole() eq 'ADMIN'}">


                    <li>
                        <a href="listStudentsControl">
                            <i class='bx bxs-face'></i>
                            <span class="links_name">Student</span>
                        </a>
                    </li>
                    <li>
                        <a href="list-teacher">
                            <i class='bx bx-circle-three-quarter' ></i>
                            <span class="links_name">Teacher</span>
                        </a>
                    </li>
                    <li>
                        <a href="listAT">
                            <i class='bx bxl-xing'></i>
                            <span class="links_name">Account</span>
                        </a>
                    </li>
                </c:if>
                <li>
                    <a href="list-levels">
                        <i class='bx bx-collection' ></i>
                        <span class="links_name">Level</span>
                    </a>
                </li>
                <li>
                    <a href="list-course">
                        <i class='bx bx-book-open' ></i>
                        <span class="links_name">Course</span>
                    </a>
                </li>
                <li>
                    <a href="list-class">
                        <i class='bx bxs-graduation' ></i>
                        <span class="links_name">Class</span>
                    </a>
                </li>
                <li>
                    <a href="list-class-student">
                        <i class='bx bxs-id-card'></i>
                        <span class="links_name">Class Student</span>
                    </a>
                </li>
                <li>
                    <a href="list-mark">
                        <i class='bx bxs-bookmark-heart' ></i>
                        <span class="links_name">Mark</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-message-square' ></i>
                        <span class="links_name">Attendance</span>
                    </a>

                </li>
                <li>
                    <a href="logoutControl" class="log_out">
                        <i class='bx bx-log-out'></i>
                        <span class="links_name">log out</span>
                    </a>
                </li>
            </ul>
        </div>
        <section class="home-section">
            <nav>
                <div class="sidebar-button">
                    <i class='bx bx-menu sidebarBtn' ></i>
                    <span class="dashboard">Dashboard</span>
                </div>
                <div class="search-box">
                    <input type="text" placeholder="Search...">
                    <i class='bx bx-search'></i>
                </div>
                <div class="profile-details">

                    <img src="image/index/anhdaidien1.jpg" alt="">
                    <a href="update-profile"><span class="admin_name">${ad.name}</span>
                        <!-- <i class='bx bx-chevron-down'></i> --></a>
                </div>
            </nav>

            <div class="home-content">
                <div class="home-table">
                    <div class="box">

                        <div class="table-details" style="margin: 15px 0">
                            <c:if test="${sessionScope.account.getRole() eq 'ADMIN'}">
                                <a style="color: #081D45; background:#4070f4; border: 1px solid #2697FF; border-radius: 5px; padding: 5px; " href="add-student-class" role="button">Add new student</a>
                                <!--<a style="color: #081D45; background:#4070f4; border: 1px solid #2697FF; border-radius: 5px; padding: 5px; " href="create-class" role="button">Add Student</a>-->
                            </c:if>
                            <a style="color: #081D45; background:#4070f4; border: 1px solid #2697FF; border-radius: 5px; padding: 5px; " href="list-class-student" role="All student">List All student</a>
                            <p name = "classId" style="margin: 15px 0">
                                Class: 
                                <c:forEach items="${listC}" var ="A">
                                    <a style="color: #081D45; background:#E4E9F7; border: 1px solid #2697FF; border-radius: 5px; padding: 5px;" href="filter-class?classId=${A.id}" role="button">${A.name}</a>
                                </c:forEach>
                            </p>

                            <table>
                                <thead>

                                    <tr>
                                        <th> Class Name</th>
                                        <th>CODE</th>
                                        <th>NAME</th>
                                            <c:if test="${sessionScope.account.getRole() eq 'ADMIN'}">
                                            <th>ACTION</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listCSa}" var = "C">
                                        <tr class="tr-hover"> 
                                            <td>${C.className}</td>
                                            <td>${C.studentCode}</td>
                                            <td>${C.studentName}</td>
                                            <c:if test="${sessionScope.account.getRole() eq 'ADMIN'}">
                                                <td><a href="delete-student-class?id=${C.id}">Delete</a>|<a href="update-student-class?id=${C.id}">Update</a></td>  
                                            </c:if>
                                        </tr>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div style="margin: auto">
                            Show <select name="records"> 
                                <option>10</option>
                                <option>15</option>
                                <option>20</option>
                            </select>  Records
                            <button style="padding: 5px 10px " >Previous</button>
                            <button style="padding: 5px 10px;">1</button>
                            <button style="padding: 5px 10px;">2</button>
                            <button style="padding: 5px 10px; ">3</button>
                            <button style="padding: 5px 10px">Next</button>
                        </div>


                    </div>

                </div>
            </div>
        </section>
    </div>
    <script>
        let sidebar = document.querySelector(".sidebar");
        let sidebarBtn = document.querySelector(".sidebarBtn");
        sidebarBtn.onclick = function () {
            sidebar.classList.toggle("active");
            if (sidebar.classList.contains("active")) {
                sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
            } else {
                sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
            }
        }
    </script>
</body>
</html>           
