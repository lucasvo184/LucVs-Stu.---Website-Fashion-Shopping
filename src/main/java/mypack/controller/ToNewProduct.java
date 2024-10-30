package mypack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.dao.impl.ProductDAO;
import mypack.model.Product;

/**
 * Servlet implementation class ToNewProduct
 */
@WebServlet("/ToNewProduct")
public class ToNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToNewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> productList = productDAO.getTrendProducts("'In Stock - New'");
        req.setAttribute("products", productList);
		req.getRequestDispatcher("html/newproductview.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
