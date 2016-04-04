package hu.sol.mik.hw.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().print("I'm PageServlet\n");
		String parameter = req.getParameter("param");
		if(parameter == null){
			throw new RuntimeException("Missing parameter");
		}
		RequestDispatcher pageRequestDispatcher = getServletContext().getRequestDispatcher("/page.jsp");
		if("include".equals(parameter)){
			pageRequestDispatcher.include(req, resp);
		}else if("forward".equals(parameter)){
			pageRequestDispatcher.forward(req, resp);
		}else{
			throw new RuntimeException("Invalid parameter: " + parameter);
		}
		
	}

	
	
	
}
