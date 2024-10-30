package mypack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.dao.impl.CartDAO;
import mypack.dao.impl.OrderDAO;
import mypack.dao.impl.PaymentDAO;
import mypack.model.CartItem;
import mypack.model.Order;
import mypack.model.Payment;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Lấy thông tin từ form
       
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        
        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa tồn tại
		if (session != null) {
			Integer userId = (Integer) session.getAttribute("userId");
		    if (userId != null) {
		        // Sử dụng userId để thực hiện các thao tác chính
		    	 //
		        CartDAO cartDAO = new CartDAO();
		        List<CartItem> cartItems = cartDAO.getCartItems(userId);
		        // Tạo mã đơn hàng
		        OrderDAO orderDAO = new OrderDAO();
		        String orderId = orderDAO.generateOrderCode(userId);


		        // Thêm thông tin thanh toán
		        Payment payment = new Payment(orderId, request.getParameter("name"), request.getParameter("num"), request.getParameter("month"), request.getParameter("year"), request.getParameter("cvv"));
		        PaymentDAO paymentDAO = new PaymentDAO();
		        paymentDAO.addPayment(payment);
		        
		        // Tạo và lưu đơn hàng
		        Order order = new Order(orderId, cartItems, userId, name, email, address, city, state, payment, 0.0);
		        order.setTotal(order.calculateTotal(cartItems)); // Tính total trước khi lưu vào cơ sở dữ liệu
		        orderDAO.addOrder(order);

		        // Lưu chi tiết sản phẩm
		        for (CartItem item : cartItems) {
		            orderDAO.addOrderDetail(orderId, item);
		        }
		        
		        //Xóa sản phẩm trong giỏ hàng.
		        cartDAO.deleteFromCart(userId);

		        // Redirect to confirmation page
		        request.getRequestDispatcher("Home").forward(request, response);
		    	
	        } else {
	            request.getRequestDispatcher("html/login.jsp").forward(request, response);
	        }
	    } else {
	        request.getRequestDispatcher("html/login.jsp").forward(request, response);
	    }
        
       
	}

}
