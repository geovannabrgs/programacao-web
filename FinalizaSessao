package upis.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/fim")
public class FinalizaSessao extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		session.invalidate();

		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Web-UPIS</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style=\"font-family: Arial;text-align:center;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);\">");
		out.println("<h1>Sessão finalizada!</h1>");
		out.println("<a href=\"index.html\"><input type=\"button\" value=\"RETORNAR\"></a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
