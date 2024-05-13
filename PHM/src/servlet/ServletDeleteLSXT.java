package servlet;

import model.LSXT;
import service.Impl.LSXTServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteLSXT extends HttpServlet{

	private LSXT LSXT;
	private ServletFindAllLSXT servletFindAllLSXT=new ServletFindAllLSXT();
	private LSXTServiceImpl LSXTServiceImpl=new LSXTServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int LSXTID = Integer.parseInt(request.getParameter("LSXTID"));
	
		int rs=LSXTServiceImpl.deleteLSXT(LSXTID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllLSXT.doGet(request, response);
			//	request.getRequestDispatcher("admin/addLSXT.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllLSXT.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
