<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Trang đăng nhập | LucVs Stu.</title>
</head>

<body>
    <div class="notifications"></div>
    <div class="container" id="container">
        <div class="form-container sign-up">
            <form action="Register" method="post">
                <h1>Tạo tài khoản</h1>
                <div class="social-icons">
                    <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                </div>
                <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
				<% if (errorMessage != null) { %>
   					 <p class="error"><%= errorMessage %></p>
				<% } %>
                <span></span>
                <input type="text" placeholder="Tên" name="name">
                <input type="tel" placeholder="Số điện thoại" name="phone">
                <input type="email" placeholder="Email" name="email">
                <input type="password" placeholder="Mật khẩu" name="password1">
                <input type="password" placeholder="Nhập lại mật khẩu" name="enterPassword">
                <button id="btn-sign-up">Đăng ký</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="Login" method="post">
                <h1>Đăng nhập</h1>
                <div class="social-icons">
                    <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                </div>
                <span></span>
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Mật khẩu" required>
                <a href="#">Quên mật khẩu?</a>
                <button type="submit">Đăng nhập</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Đã có tài khoản</h1>
                    <p>Chúc bạn sẽ có những trải nghiệm tuyệt vời với LucVs Stu. nhé!</p>
                    <button class="hidden" id="login">Đăng nhập</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Tạo tài khoản</h1>
                    <p>Nhanh chóng, chỉ 1 phút 30 giây</p>
                    <button class="hidden" id="register">Đăng ký tài khoản</button>
                </div>
            </div>
        </div>
    </div>

    <script src="js/login.js"></script>
</body>

</html>