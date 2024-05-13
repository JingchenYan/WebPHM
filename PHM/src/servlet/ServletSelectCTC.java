package servlet;

import model.CTC;
import service.Impl.CTCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectCTC extends HttpServlet{

	private CTC CTC;
	private ServletFindAllCTC servletFindAllCTC=new ServletFindAllCTC();
	private CTCServiceImpl CTCServiceImpl=new CTCServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CTCID = Integer.parseInt(request.getParameter("CTCID"));
	
		List rs=CTCServiceImpl.findOne(CTCID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editCTC.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
