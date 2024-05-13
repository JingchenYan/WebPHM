package servlet;

import model.LSXT;
import service.Impl.LSXTServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectLSXT extends HttpServlet{

	private LSXT LSXT;
	private ServletFindAllLSXT servletFindAllLSXT=new ServletFindAllLSXT();
	private LSXTServiceImpl LSXTServiceImpl=new LSXTServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int LSXTID = Integer.parseInt(request.getParameter("LSXTID"));
	
		List rs=LSXTServiceImpl.findOne(LSXTID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editLSXT.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
