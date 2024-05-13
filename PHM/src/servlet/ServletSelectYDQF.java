package servlet;

import model.YDQF;
import service.Impl.YDQFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletSelectYDQF extends HttpServlet{

	private YDQF YDQF;
	private ServletFindAllYDQF servletFindAllYDQF=new ServletFindAllYDQF();
	private YDQFServiceImpl YDQFServiceImpl=new YDQFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int YDQFID = Integer.parseInt(request.getParameter("YDQFID"));
	
		List rs=YDQFServiceImpl.findOne(YDQFID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editYDQF.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
