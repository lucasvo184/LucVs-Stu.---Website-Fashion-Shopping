package mypack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.dao.impl.ProductDAO;
import mypack.dao.impl.UserDAO;
import mypack.model.Product;
import mypack.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmailAndPassword(email, password);

        if (user != null) {
            // Đăng nhập thành công: Lưu userId vào session
            HttpSession session = req.getSession();
            session.setAttribute("email", user.getEmail());
            session.setAttribute("userId", user.getId());
            ProductDAO productDAO = new ProductDAO();
            List<Product> productList = productDAO.getTrendProducts("'In Stock - Hot'");
            req.setAttribute("products", productList);
            req.getRequestDispatcher("html/homepage.jsp").forward(req, resp);
        } else {
            // Đăng nhập thất bại
            resp.sendRedirect("error.jsp");
        }
    }
}
