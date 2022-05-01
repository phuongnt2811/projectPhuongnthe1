<%-- 
    Document   : Home
    Created on : Feb 6, 2022, 2:04:54 AM
    Author     : PHUONG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="CSS/HomeAcss.css">
    <title>Document</title>
</head>

<body>
    <div class="sidebar ">
        <div class="logo-details">
            <i class='bx bx-leaf'></i>
            <span class="logo_name">Jell Center</span>
        </div>
        <ul class="nav-links">
            <li>
                <div class="icon-link">
                    <a href="#">
                        <i class='bx bx-home'></i>
                        <span class="link_name">Trang chủ</span>
                    </a>
                </div>
            </li>


            <li>
                <div class="icon-link">
                    <a href="#">
                        <i class='bx bxs-collection'></i>
                        <span class="link_name">
                            Đào tạo
                        </span>
                    </a>
                    <i class='bx bx-chevron-down arrow'></i>

                </div>
                <ul class="sub-menu">
               
               <li> <a class="link_name" href="#">Đào tạo</a></li>
                <li> <a href="#">Khóa học</a></li>
                <li> <a href="#">Lớp học</a></li>
                <li> <a href="#">Thời khóa biểu</a></li>
                <li> <a href="#">Điểm danh</a></li>
                 </ul>
            </li>

            <li>
                <div class="icon-link">
                    <a href="#">
                        <i class='bx bx-receipt'></i>

                        <span class="link_name">
                            Báo cáo
                        </span>
                    </a>
                    <i class='bx bx-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
               
                    <li> <a class="link_name" href="#">Báo cáo</a></li>
                    <li> <a href="#">Báo cáo điểm danh</a></li>
                    <li> <a href="#">Báo cáo điểm</a></li>
                    <li> <a href="#">Báo cáo khóa học</a></li>
                </ul>
            </li>

            <li>
                <div class="icon-link">
                    <a href="#">
                        <i class='bx bxs-contact'></i>

                        <span class="link_name">
                            Quản lí
                        </span>
                    </a>
                    <i class='bx bx-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
                <li> <a class="link_name" href="#">Quản lí</a></li>
                <li> <a href="#">Khóa học</a></li>
                <li> <a href="#">Lớp học</a></li>
                <li> <a href="#">Thời khóa biểu</a></li>
                <li> <a href="#">Điểm danh</a></li>
                </ul>
            </li>
            <li>
                <div class="icon-link">
                    <a href="#">
                        <i class='bx bx-group'></i>

                        <span class="link_name">
                            Tài khoản
                        </span>
                    </a>
                    <i class='bx bx-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
               
                    <li> <a class="link_name" href="#">Tài khoản</a></li>
                    <li> <a href="#">Danh sách học viên</a></li>
                    <li> <a href="#">Danh sách giáo viên</a></li>
                     </ul>
            </li>
            <li>
                <div class="icon-link">
                    <a href="#">
                        <i class='bx bxs-cog'></i>

                        <span class="link_name">
                            Thiết lập
                        </span>
                    </a>
                    <i class='bx bx-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
               
                    <li> <a class="link_name" href="#">Thiết lập</a></li>
                    <li> <a href="#">Phòng học</a></li>
                    <li> <a href="#">Lịch nghỉ</a></li>
                    <li> <a href="#">Lịch thi</a></li>
                     </ul>
            </li>
            <li>
                <div class="profile-details">
                    <div class="profile-content">
                        <img src="/index/anhdaidien1.jpg" alt="anhdaidien">
                    </div>
                    <div class="name-job">
                        <div class="profile_name">Phuong</div>
                        <div class="job">Admin</div>
                    </div>
                    <i class='bx bx-log-out'></i>
                </div>
            </li>
        </ul>

    </div>
    <section class="home-section">
        <nav>
        <div class="sidebar-button">
            <i class="bx bx-menu"></i>
           <span class="dashboard">Menu</span>
        </div>
        <div class="search-box">

            <input type="text" name="bx-search" id="" placeholder="Tìm kiếm...">
            
        </div>
        <!-- <div class="profile-details">
            <span class="admin_name">A</span>
            <i class='bs bs-chevron-down'></i>
        </div> -->
    </nav>
    </section>
    <script>
        let arrow = document.querySelectorAll(".arrow");
        for (var i = 0; i <arrow.length; i++){
            arrow[i].addEventListener("click",(e)=>{
                let arrowParent = e.target.parentElement.parentElement; // selecting main parent of arrow;
                arrowParent.classList.toggle("showMenu");
            });
        }
        let sidebar = document.querySelector(".sidebar");
        let sidebarBtn = document.querySelector(".bx-menu");
        console.log(sidebarBtn);
        sidebarBtn.addEventListener("click", ()=>{
            sidebar.classList.toggle("close");
        });
    </script>
</body>

</html>