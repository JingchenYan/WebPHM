package servlet;

import model.XHJ;
import service.Impl.XHJServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectXHJ extends HttpServlet{

	private XHJ XHJ;
	private ServletFindAllXHJ servletFindAllXHJ=new ServletFindAllXHJ();
	private XHJServiceImpl XHJServiceImpl=new XHJServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJID = Integer.parseInt(request.getParameter("XHJID"));
	
		List rs=XHJServiceImpl.findOne(XHJID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editXHJ.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
