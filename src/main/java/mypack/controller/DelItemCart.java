package mypack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.dao.impl.CartDAO;

/**
 * Servlet implementation class DelItemCart
 */
@WebServlet("/DelItemCart")
public class DelItemCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelItemCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa tồn tại
		if (session != null) {
		    Integer userId = (Integer) session.getAttribute("userId");
		    if (userId != null) {
		        // Sử dụng userId để thực hiện các thao tác chính
		    	String productIdStr = request.getParameter("id");
		    	String size = request.getParameter("size");
		        int productId = 0;
		        
		        try {
		            productId = Integer.parseInt(productIdStr);
		        } catch (NumberFormatException e) {
		            // Xử lý trường hợp ID không hợp lệ
		            request.setAttribute("error", "Invalid product ID");
		            request.getRequestDispatcher("error.jsp").forward(request, response);
		            return;
		        }
		        
		        CartDAO cartDAO = new CartDAO();
		        cartDAO.removeFromCart(userId, productId, size);
		        response.sendRedirect("Cart");
		    	
	        } else {
	            request.getRequestDispatcher("html/login.jsp").forward(request, response);
	        }
	    } else {
	        request.getRequestDispatcher("html/login.jsp").forward(request, response);
	    }
	}
}