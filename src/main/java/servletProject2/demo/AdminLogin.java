package servletProject2.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class AdminLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		if(name.equals("admin") && pass.equals("admin")) {
			resp.getWriter().print("<h1>Login Successfully</h1>");
			req.getRequestDispatcher("dashboard.html").include(req, resp);
		}else {
			resp.getWriter().print("<h1>Login failed");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}

}
