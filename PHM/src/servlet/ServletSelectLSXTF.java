package servlet;

import model.LSXTF;
import service.Impl.LSXTFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectLSXTF extends HttpServlet{

	private LSXTF LSXTF;
	private ServletFindAllLSXTF servletFindAllLSXTF=new ServletFindAllLSXTF();
	private LSXTFServiceImpl LSXTFServiceImpl=new LSXTFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int LSXTFID = Integer.parseInt(request.getParameter("LSXTFID"));
	
		List rs=LSXTFServiceImpl.findOne(LSXTFID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editLSXTF.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
