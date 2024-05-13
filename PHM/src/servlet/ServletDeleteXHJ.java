package servlet;

import model.XHJ;
import service.Impl.XHJServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteXHJ extends HttpServlet{

	private XHJ XHJ;
	private ServletFindAllXHJ servletFindAllXHJ=new ServletFindAllXHJ();
	private XHJServiceImpl XHJServiceImpl=new XHJServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJID = Integer.parseInt(request.getParameter("XHJID"));
	
		int rs=XHJServiceImpl.deleteXHJ(XHJID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllXHJ.doGet(request, response);
			//	request.getRequestDispatcher("admin/addXHJ.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllXHJ.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
