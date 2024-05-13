package servlet;

import model.YDQ;
import service.Impl.YDQServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectYDQ extends HttpServlet{

	private YDQ YDQ;
	private ServletFindAllYDQ servletFindAllYDQ=new ServletFindAllYDQ();
	private YDQServiceImpl YDQServiceImpl=new YDQServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int YDQID = Integer.parseInt(request.getParameter("YDQID"));
	
		List rs=YDQServiceImpl.findOne(YDQID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editYDQ.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
