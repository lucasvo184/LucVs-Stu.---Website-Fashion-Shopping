<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>LucVs Stu. | Checkout Cart</title>
    <link rel="stylesheet" href="css/payment.css">

</head>
<body>

<div class="container">

    <form action="CheckOut" method="post">

        <div class="row">

            <div class="col">

                <h3 class="title">information ship</h3>

                <div class="inputBox">
                    <span>full name :</span>
                    <input type="text" name="fullname"placeholder="Nguyen Van A">
                </div>
                <div class="inputBox">
                    <span>email :</span>
                    <input type="email" name="email" placeholder="example@gmail.com">
                </div>
                <div class="inputBox">
                    <span>address :</span>
                    <input type="text" name="address" placeholder="1 Vo Van Ngan, quan Thu Duc">
                </div>
                <div class="inputBox">
                    <span>city :</span>
                    <input type="text" name="city" placeholder="TP.Ho Chi Minh">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>state :</span>
                        <input type="text" name="state" placeholder="Viet Nam">
                    </div>
                </div>

            </div>

            <div class="col">

                <h3 class="title">payment</h3>

                <div class="inputBox">
                    <span>cards accepted :</span>
                    <img src="img/card_img.png" alt="">
                </div>
                <div class="inputBox">
                    <span>name on card :</span>
                    <input type="text" name="name" placeholder="NGUYEN VAN A">
                </div>
                <div class="inputBox">
                    <span>credit card number :</span>
                    <input type="number" name="num" placeholder="1111-2222-3333-4444">
                </div>
                <div class="inputBox">
                    <span>exp month :</span>
                    <input type="text" name="month" placeholder="January">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>exp year :</span>
                        <input type="number" name="year" placeholder="2022">
                    </div>
                    <div class="inputBox">
                        <span>CVV :</span>
                        <input type="text" name="cvv" placeholder="1234">
                    </div>
                </div>
            </div>
    
        </div>

        <input type="submit" value="checkout" class="submit-btn">

    </form>

</div>    
    
</body>
</html>