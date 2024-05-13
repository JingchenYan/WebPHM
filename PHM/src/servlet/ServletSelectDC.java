package servlet;

import model.DC;
import service.Impl.DCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectDC extends HttpServlet{

	private DC DC;
	private ServletFindAllDC servletFindAllDC=new ServletFindAllDC();
	private DCServiceImpl DCServiceImpl=new DCServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int DCID = Integer.parseInt(request.getParameter("DCID"));
	
		List rs=DCServiceImpl.findOne(DCID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editDC.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
