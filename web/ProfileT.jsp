<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
    <style>
        .contents{
           margin: 100px 280px;
           padding: 0 100px;
            background-color: white;
            color: black;
            border: 1px solid white;
        }
        .contents .input-box{
            margin:  10px;
            padding: 10px;
            padding-left: 100px;
            height: 50px;
            width: 100px;
        }
        .contents .input-box input{
            width: 300px;
            height: 30px;
            border-radius: 5px;
        }
        .contents .input-box button{
            display: flex;
            text-align: center;
           padding: 0 40px;
           justify-content: center;
        }
    </style>
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
                    <a href="#">
                        <i class='bx bxl-xing'></i>
                        <span class="links_name">Account teacher</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxl-xing'></i>
                        <span class="links_name">Account Student</span>
                    </a>
                </li>
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
                        <i class='bx bxs-graduation' ></i>
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
                        <span class="links_name">Attendace</span>
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
                
                     <div class="contents"> 
                         
                         <form action="updateProfileT" method="POST">
                          <input  type="hidden" name="id" value="${tea.id}">
                             <div class="input-box">
                                  <label>Name</label><br>
                                  <input type="text"  name="name" value="${tea.name}" >
                            </div>
                            <div class="input-box">
                                 <label>Code</label><br>
                                <input type="text"  name="code" value="${tea.code}" >
                            </div>
                            <div class="input-box">
                                <label>Gender</label><br>
                                <input type="text" name="gender" value="${tea.gender?"Nam":"Nữ"}" >
                            </div>
                            <div class="input-box">
                                <label>Phone</label><br>
                                <input type="text" name="phone" value="${tea.phone}" >
                            </div>
                            <div class="input-box">
                                <label>Email</label><br>
                                <input type="text"  name="email" value="${tea.email}" >
                            </div>
                            <div class="input-box">
                                <label>Address</label><br>
                                <input type="text"  name="address" value="${tea.address}" >
                            </div>
                            <div class="input-box">
                                <label>Birthday</label> <br>
                                <input type="text"  name="birthday" value="${tea.birthday}" >
                            </div>
                            
                                
                                <div class="input-box">
                                    
                                    <input type="submit" value = "update">
                                </div>   
                            
               </form>
                        
                    
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
