package servletProject2.demo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addstaff")
public class AddStaff extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Staff staff = new Staff();
		staff.setName(name);
		staff.setPhone(phone);
		staff.setSubject(subject);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(staff);
		transaction.commit();
		
		resp.getWriter().print("<h1>Staff Added Successfully</h1>");
		req.getRequestDispatcher("dashboard.html").include(req, resp);
	}

}
