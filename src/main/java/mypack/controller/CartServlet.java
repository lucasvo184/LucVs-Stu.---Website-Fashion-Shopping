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
import mypack.model.CartItem;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CartDAO cartDAO;

    @Override
    public void init() {
        cartDAO = new CartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa tồn tại
		if (session != null) {
			Integer userId = (Integer) session.getAttribute("userId");
		    if (userId != null) {
		        // Sử dụng userId để thực hiện các thao tác chính
		    	List<CartItem> cartItems = cartDAO.getCartItems(userId);

		        request.setAttribute("cartItems", cartItems);
		        request.getRequestDispatcher("html/cartview.jsp").forward(request, response);
		    	
	        } else {
	            request.getRequestDispatcher("html/login.jsp").forward(request, response);
	        }
	    } else {
	        request.getRequestDispatcher("html/login.jsp").forward(request, response);
	    }
    }
}