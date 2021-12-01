package upis.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet ("/cs")
public class ControleSessao extends HttpServlet {

	private int contador;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Acesso de número: " + (++contador) + "</h1>");
		out.println("<h3>ID sessão: " + session.getId() + "</h3>");
		out.println("<h3>Tempo ID sessão: " + session.getMaxInactiveInterval() + "</h3>");
		out.println("<a href=\"fim\"> SAIR </a>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
