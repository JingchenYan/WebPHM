package servlet;

import model.GDQDF;
import service.Impl.GDQDFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectGDQDF extends HttpServlet{

	private GDQDF GDQDF;
	private ServletFindAllGDQDF servletFindAllGDQDF=new ServletFindAllGDQDF();
	private GDQDFServiceImpl GDQDFServiceImpl=new GDQDFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int GDQDFID = Integer.parseInt(request.getParameter("GDQDFID"));
	
		List rs=GDQDFServiceImpl.findOne(GDQDFID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editGDQDF.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
