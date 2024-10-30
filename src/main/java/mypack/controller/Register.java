package mypack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.dao.impl.UserDAO;
import mypack.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin người dùng từ form
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        String enterPassword = request.getParameter("enterPassword");

        // Kiểm tra mật khẩu nhập lại
        if (!password.equals(enterPassword)) {
            request.setAttribute("errorMessage", "Mật khẩu không khớp.");
            request.getRequestDispatcher("html/login.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng User và gọi UserDAO để đăng ký
        User user = new User(1, email, password);
        UserDAO userDAO = new UserDAO();

        if (userDAO.registerUser(user, name, phone)) {
        	request.getRequestDispatcher("html/login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Đăng ký thất bại, vui lòng thử lại.");
            request.getRequestDispatcher("html/login.jsp").forward(request, response);
        }
    }
}
