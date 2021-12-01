package upis.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ops")
public class Primeiro extends HttpServlet{
	
	private int contIncorreto;
	private int contCorreto;
	private String usuario;
	private String senha;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		usuario = req.getParameter("user");
		senha = req.getParameter("password");
		
		if(testeLogin() == true){
			contCorreto++;
		}
	
		metodoComum(req,resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute(getServletName()) == null){
		
			String url = "index.html";
			
			resp.setStatus(HttpServletResponse.SC_FOUND);
			resp.setHeader("Location", url);
	
		}else
			if(session.getAttribute(getServletName()).equals("teste")) {
			
				metodoComum(req,resp);

			}
	}
	
	private void metodoComum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Web-UPIS</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style=\"font-family: Arial;text-align:center;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);\">");
		out.println("<h1>Método Comum</h1>");
		
		if(testeLogin() == true) {
			out.println("<h3>Seja bem vindo! <br /><br /> Usuário: "+ usuario + "<br /> Senha: " + senha + "</h3>");
			out.println("<h3>Logins corretos: "+ contCorreto + "</h3>");	
			session.setAttribute(getServletName(), usuario);
			session.setMaxInactiveInterval(10);
		}else {
			out.println("<h2>Usuário ou senha incorretos </h2>");
			contIncorreto++;
			out.println("<h3>Logins incorretos: " + contIncorreto + "</h3>");
		}
		
		
		out.println("<h3>ID de sessão: "+ session.getId() + "</h3>");
		out.println("<h3>Objeto de sessão: "+ session.getAttribute(getServletName()) + "</h3>");
		out.println("<a href=\"fim\"><input type=\"button\" value=\"SAIR\"></a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	private boolean testeLogin() {
		
		if (usuario.equals("teste")) {
			if (senha.equals("123"))
				return true;
		}
		return false;
	}
	
}
