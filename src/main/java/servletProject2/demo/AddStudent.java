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

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String section = req.getParameter("sec");
		String address=req.getParameter("addr");
		int age=Integer.parseInt(req.getParameter("age"));
		
		Student student = new Student();
		student.setName(name);
		student.setSection(section);
		student.setAddress(address);
		student.setAge(age);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		
		resp.getWriter().print("<h1>Student Added Successfully</h1>");
		req.getRequestDispatcher("dashboard.html").include(req, resp);
		
		
	}

}
