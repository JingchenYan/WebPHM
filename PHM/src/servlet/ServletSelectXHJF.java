package servlet;

import model.XHJF;
import service.Impl.XHJFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectXHJF extends HttpServlet{

	private XHJF XHJF;
	private ServletFindAllXHJF servletFindAllXHJF=new ServletFindAllXHJF();
	private XHJFServiceImpl XHJFServiceImpl=new XHJFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJFID = Integer.parseInt(request.getParameter("XHJFID"));
	
		List rs=XHJFServiceImpl.findOne(XHJFID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editXHJF.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
