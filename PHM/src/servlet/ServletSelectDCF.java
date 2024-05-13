package servlet;

import model.DCF;
import service.Impl.DCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectDCF extends HttpServlet{

	private DCF DCF;
	private ServletFindAllDCF servletFindAllDCF=new ServletFindAllDCF();
	private DCFServiceImpl DCFServiceImpl=new DCFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int DCFID = Integer.parseInt(request.getParameter("DCFID"));

		List rs=DCFServiceImpl.findOne(DCFID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editDCF.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
