package upis.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cv")
public class CicloVida extends HttpServlet {
	
	private int contador;

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Iniciado.");
		System.out.println("Contador inicial: " + contador);
	}
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		contador = contador + 1;
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Acesso de número: " + contador + "</h3>");
		out.println("</body>");
		out.println("</html>");
	
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet destruido.");
		System.out.println("Contador final: " + contador);
	}
}
