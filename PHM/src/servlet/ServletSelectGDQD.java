package servlet;

import model.GDQD;
import service.Impl.GDQDServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectGDQD extends HttpServlet{

	private GDQD GDQD;
	private ServletFindAllGDQD servletFindAllGDQD=new ServletFindAllGDQD();
	private GDQDServiceImpl GDQDServiceImpl=new GDQDServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int GDQDID = Integer.parseInt(request.getParameter("GDQDID"));
	
		List rs=GDQDServiceImpl.findOne(GDQDID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editGDQD.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
