<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <meta name="description" content="" />
        <title>LucVs Stu. | Tops</title>
        <link href="css/productbar.css" rel="stylesheet" />
        <link href="css/footer.css" rel="stylesheet" />
        <link href="css/cardproduct.css" rel="stylesheet" />
        <link href="css/banner.css" rel="stylesheet" />
    </head>
<body>

    <header>
        <div class="navbar">
            <div class="logo"><a href="Home">LucVs</a></div>
            <ul class="links">
                <li><a href="ToAllProduct">All Products</a> </li>
                <li><a href="ToNewProduct">New Products</a> </li>
                <li><a href="GetTopsProduct" style="color: black;">Tops</a> </li>
                <li><a href="ToBottomProduct">Bottom</a> </li>
                <li><a href="ToAccessories">Accessories</a> </li>
            </ul>
            <a href="Cart" class="action-btn"><i class="fa-solid fa-cart-shopping"></i></a>
            <div class="toggle-btn">
                <i class="fa-solid fa-bars"></i>
            </div>

            <div class="drop-menu">
            <ul>
                <li><a href="ToAllProduct">All Products</a> </li>
                <li><a href="ToNewProduct">New Products</a> </li>
                <li><a href="GetTopsProduct" style="color: black;">Tops</a> </li>
                <li><a href="ToBottomProduct">Bottom</a> </li>
                <li><a href="ToAccessories">Accessories</a> </li>
                <li><a href="Cart" class="action-btn"><i class="fa-solid fa-cart-shopping"></i></a></li>
             </ul>
            </div>
        </div>
    </header>

    <section class="products">
        <section class="baner" style="background-image: url('img/banner4.png');">
        </section>
        <h1>Tops</h1>
        <div class="all-products">
        
            <c:forEach var="product" items="${products}">
            <div class="product" onclick="location.href='ProductDetail?id=${product.id}'" style="cursor: pointer;">
                <img src="${product.imageUrl}">
                <div class="product-info">
                    <h4 class="product-title">
                        ${product.name}
                    </h4>
                    <p class="product-price"> ${product.price} $ </p>
                    <a href="ProductDetail?id=${product.id}" class="product-btn">Buy Now</a>
                </div>
            </div>
        </c:forEach>
        </div>
    </section>

    <footer class="footer-distributed">

        <div class="footer-left">
            <h3>LucVs<span>Stu.</span></h3>

            <p class="footer-company-name">Copyright © 2024 <strong>LucVs Studio</strong> All rights reserved</p>
            <div class="footer-icons">
                <a href="https://www.facebook.com/profile.php?id=100054581052266"><i class="fa-brands fa-facebook"></i></a>
                <a href="https://www.instagram.com/tlocc_6/?hl=en"><i class="fa-brands fa-instagram"></i></a>
                <a href="#"><i class="fa-brands fa-github"></i></a>
            </div>
        </div>

        <div class="footer-center">
            <div>
                <i class="fa fa-map-marker"></i>
                <p><span>Võ Thành Lộc - 22110180</span></p>
            </div>

            <div>
                <i class="fa fa-phone"></i>
                <p>+84 947 166 477</p>
            </div>
            <div>
                <i class="fa fa-envelope"></i>
                <p><a href="mailto:22110180@student.hcmute.edu.vn">22110180@student.hcmute.edu.vn</a></p>
            </div>
        </div>
        <div class="footer-right">
            <p class="footer-company-about">
                <span>LucVs Stu. website</span>
                <strong>LucVs Stu.</strong> là một trang web được xây dựng trong quá trình
                thực hiện đề tài môn học <strong>Đồ án Công nghệ thông tin</strong> được xây dựng bởi Võ Thành Lộc - 22110180,
                 sinh viên trường Đại học Sư phạm Kỹ thuật TP.Hồ Chí Minh. Trang web được xây dựng bằng HTML,
                  CSS, Java Scipt, Java và cơ sở dữ liệu được xây dựng bằng MySQL cùng với các công nghệ 
                  Servlet, Bootstrap, ...
            </p>
        </div>
    </footer>
    <script src="js/togglebtn.js"></script>

</body>
</html>