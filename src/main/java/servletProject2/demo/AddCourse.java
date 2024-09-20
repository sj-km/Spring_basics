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

@WebServlet("/addcourse")
public class AddCourse extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int number=Integer.parseInt(req.getParameter("number"));
		
		Course course = new Course();
		course.setCourse_name(name);
		course.setNoOfStudent(number);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(course);
		transaction.commit();
		
		resp.getWriter().print("<h1>Course Added Successfully</h1>");
		req.getRequestDispatcher("dashboard.html").include(req, resp);
		
	}

}
