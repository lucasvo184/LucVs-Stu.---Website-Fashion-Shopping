package mypack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.dao.impl.ProductDAO;
import mypack.model.Product;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lấy ID của sản phẩm từ tham số truy vấn URL
        String productIdStr = request.getParameter("id");
        int productId = 0;
        
        try {
            productId = Integer.parseInt(productIdStr);
        } catch (NumberFormatException e) {
            // Xử lý trường hợp ID không hợp lệ
            request.setAttribute("error", "Invalid product ID");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
     // Gọi ProductDAO để lấy thông tin sản phẩm
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);
        
        if (product != null) {
            // Truyền đối tượng sản phẩm vào request và chuyển tới trang JSP
            request.setAttribute("product", product);
            request.getRequestDispatcher("html/productdetail.jsp").forward(request, response);
        } else {
            // Trường hợp không tìm thấy sản phẩm
            request.setAttribute("error", "Product not found");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
