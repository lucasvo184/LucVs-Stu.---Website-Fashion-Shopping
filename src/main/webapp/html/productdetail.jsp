<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mypack.dao.impl.ProductDAO"%>
<%@page import="mypack.model.Product"%>
<%
    String productId = request.getParameter("id");
    ProductDAO productDAO = new ProductDAO();
    Product product = productDAO.getProductById(Integer.parseInt(productId));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="css/productdetail.css">
    <link rel="stylesheet" href="css/productbar.css">
    <title>LucVs Stu. | ${product.name}</title>
</head>
<body>
  <header>
    <div class="navbar">
        <div class="logo"><a href="Home">LucVs</a></div>
        <ul class="links">
            <li><a href="ToAllProduct">All Products</a> </li>
            <li><a href="ToNewProduct">New Products</a> </li>
            <li><a href="GetTopsProduct">Tops</a> </li>
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
           <li><a href="GetTopsProduct">Tops</a> </li>
           <li><a href="ToBottomProduct">Bottom</a> </li>
           <li><a href="ToAccessories">Accessories</a> </li>
           <li><a href="Cart" class="action-btn"><i class="fa-solid fa-cart-shopping"></i></a></li>
        </ul>
        </div>
    </div>
</header>

    <div class = "card-wrapper">
        <div class = "card">
          <!-- card left -->
          <div class = "product-imgs">
            <div class = "img-display">
              <div class = "img-showcase">
                <img src = "${product.imageUrl}">
              </div>
            </div>
          </div>
          <!-- card right -->
          <div class = "product-content">
            <h2 class = "product-title">${product.name}</h2>
      
            <div class = "product-price">
              <p class = "new-price">Price: <span>${product.price}$</span></p>
            </div>
      
            <div class = "product-detail">
              <h2>about this item: </h2>
              <ul>
                <li>Brand: <span>${product.brand}</span></li>
                <li>Color: <span>${product.color}</span></li>
                <li>Available: <span>${product.cond}</span></li>
                <li>Category: <span>${product.type}</span></li>
              </ul>
            </div>
            <form action="AddToCart" method="post">
            <div class = "purchase-info">
    		<input type="hidden" name="productID" value="${product.id}">
                <label for="size">Size:</label>
                <select id="size" name="size">
                  <option value="S">Small</option>
                  <option value="M">Medium</option>
                  <option value="L">Large</option>
                  <option value="XL">Extra Large</option>
                </select>
                <br>
                <label for="size">Quantity:</label>
                <input type = "number" name="quantity" min = "1" value = "1">
            </div>
            <button type="submit" class="cart-button">
              <span class="add-to-cart">
                  Add to Cart
              </span>
              <span class="added">
                  Added
              </span>
              <i class="fas fa-shopping-cart"></i>
              <i class="fas fa-box"></i>
          	</button>
      		</form>
          </div>
        </div>
      </div>
      
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
      <script src="js/productdetail.js"></script>
      <script src="js/togglebtn.js"></script>

</body>
</html>