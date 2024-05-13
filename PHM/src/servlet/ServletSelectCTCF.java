package servlet;

import model.CTCF;
import service.Impl.CTCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectCTCF extends HttpServlet{

	private CTCF CTCF;
	private ServletFindAllCTCF servletFindAllCTCF=new ServletFindAllCTCF();
	private CTCFServiceImpl CTCFServiceImpl=new CTCFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CTCFID = Integer.parseInt(request.getParameter("CTCFID"));

		List rs=CTCFServiceImpl.findOne(CTCFID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editCTCF.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
