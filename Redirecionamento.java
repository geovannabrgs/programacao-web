package upis.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/rediext")
public class RedirecionamentoExterno extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = "http://upis.br";
		
		resp.setStatus(HttpServletResponse.SC_FOUND);
		resp.setHeader("Location", url);
		
		//resp.sendRedirect(url);

	}
}
