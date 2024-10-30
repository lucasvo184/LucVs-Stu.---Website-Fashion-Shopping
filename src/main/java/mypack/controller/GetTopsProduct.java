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
 * Servlet implementation class GetTopsProduct
 */
@WebServlet("/GetTopsProduct")
public class GetTopsProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopsProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = productDAO.getProducts("'Tops'");
        req.setAttribute("products", productList);
		req.getRequestDispatcher("html/topsproduct.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
