<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <meta name="description" content="" />
        <title>LucVs Stu. | Cart</title>
        <link href="css/cart.css" rel="stylesheet"/>
        <link href="css/productbar.css" rel="stylesheet" />
        <link href="css/paymentbtn.css" rel="stylesheet"/>
        <link href="css/footer.css" rel="stylesheet" />
    </head>
<body>
    <header>
        <div class="navbar">
            <div class="logo"><a href="Home">LucVs</a></div>
            <a href="" class="action-btn"><i class="fa-solid fa-cart-shopping"></i></a>
            <div class="toggle-btn">
                <i class="fa-solid fa-bars"></i>
            </div>
        </div>
    </header>
    <section>
    <div class="small-container cart-page">
    <c:set var="cartTotal" value="0" />
        <table>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
            <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>
                    <div class="cart-info">
                        <img src="${item.product.imageUrl}" alt="${item.product.name}">
                        <div>
                            <p>${item.product.name}</p>
                            <small>Size: ${item.size}</small>
                            <br/>
                            <small>Price: ${item.product.price}$</small>
                            <br/>
                            <input type="hidden" name="productId" value="${item.product.id}">
                            <a href="DelItemCart?id=${item.product.id}&size=${item.size}">Remove</a>
                        </div>
                    </div>
                </td>
                <td>
                        <input type="hidden" name="action" value="update">
                        <input type="number" name="quantity" min="1" value="${item.quantity}">
                        <button onclick="location.href='UpdateItemCart?id=${item.product.id}&size=${item.size}'">Update</button>
                </td>
                <td>${item.subtotal}$</td>
            </tr>
            <c:set var="cartTotal" value="${cartTotal + item.subtotal}" />
        </c:forEach>
        </table>
		
		 <c:if test="${cartTotal > 0}">
        <div class="total-price">
        <c:set var="shippingFee" value="1" />
        <c:set var="grandTotal" value="${cartTotal + shippingFee}" />
        <table>
            <tr>
                <td>Subtotal</td>
                <td>${cartTotal}$</td>
            </tr>
            <tr>
                <td>Ship</td>
                <td>${shippingFee}$</td>
            </tr>
            <tr>
                <td>Total</td>
                <td>${grandTotal}$</td>
            </tr>
        </table>
    	</div>
    	<div class="button-container">
    	<button class="Btn" onclick = "location.href='ToCheckOut'">
  				Pay
  				<svg viewBox="0 0 576 512" class="svgIcon"><path d="M512 80c8.8 0 16 7.2 16 16v32H48V96c0-8.8 7.2-16 16-16H512zm16 144V416c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16V224H528zM64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H512c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zm56 304c-13.3 0-24 10.7-24 24s10.7 24 24 24h48c13.3 0 24-10.7 24-24s-10.7-24-24-24H120zm128 0c-13.3 0-24 10.7-24 24s10.7 24 24 24H360c13.3 0 24-10.7 24-24s-10.7-24-24-24H248z"></path></svg>
		</button>
    	</div>
    	</c:if>
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
</body>
</html>