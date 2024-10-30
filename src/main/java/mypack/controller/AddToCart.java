package mypack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.dao.impl.ProductDAO;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa tồn tại
		if (session != null) {
		    Integer userId = (Integer) session.getAttribute("userId");
		    if (userId != null) {
		        // Sử dụng userId để thực hiện các thao tác chính
		    	String productIdStr = request.getParameter("productID");
	            String quantityStr = request.getParameter("quantity");
	            String size = request.getParameter("size");
	            response.getWriter().println(productIdStr);
	            response.getWriter().println(size);
	            response.getWriter().println(quantityStr);

	            if (productIdStr != null && quantityStr != null) {
	                try {
	                    int productID = Integer.parseInt(productIdStr);
	                    int quantity = Integer.parseInt(quantityStr);

	                    // Use the DAO to add to cart
	                    boolean isAdded = productDAO.addToCart(userId, productID, quantity, size);

	                    // Redirect based on the outcome
	                    if (isAdded) {
	                    	response.sendRedirect("Cart");
	                    } else {
	                        response.getWriter().println("Failed to add to cart.");
	                    }
	                } catch (NumberFormatException e) {
	                    // Handle parsing errors
	                    response.getWriter().println("Invalid input format for product ID or quantity.");
	                }
	            } else {
	                response.getWriter().println("Product ID or quantity is missing.");
	            }
	        } else {
	            request.getRequestDispatcher("html/login.jsp").forward(request, response);
	        }
	    } else {
	        request.getRequestDispatcher("html/login.jsp").forward(request, response);
	    }
	}
}