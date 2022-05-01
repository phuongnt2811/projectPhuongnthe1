<%-- 
    Document   : Admin
    Created on : Feb 28, 2022, 2:02:12 PM
    Author     : ADM
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

<!--                <li>
                    <a href="list-teacher">
                        <i class='bx bx-circle-three-quarter' ></i>
                        <span class="links_name">Teacher</span>
                    </a>
                </li>-->
                
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
                    <a href="list-admin"><span class="admin_name">${st.name}</span>
                    <!-- <i class='bx bx-chevron-down'></i> --></a>
                </div>
            </nav>
            <div class="home-content">
                <div class="overview-boxes">
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Student</div>
                            <div class="number">${count}</div>
                        </div>
                        <i class='bx bxs-graduation cart'></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total teacher</div>
                            <div class="number">${count2}</div>
                        </div>
                        <i class='bx bxs-briefcase-alt-2 cart two'></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Class</div>
                            <div class="number">${count3}</div>
                        </div>
                        <i class='bx bxs-institution cart three' ></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total course</div>
                            <div class="number">${count4}</div>
                        </div>
                        <i class='bx bxs-school cart four' ></i>
                    </div>
                </div>
            </div>
        </section>
    
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