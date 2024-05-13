package servlet;

import model.XHJP;
import service.Impl.XHJPServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteXHJP extends HttpServlet{

	private XHJP XHJP;
	private ServletFindAllXHJP servletFindAllXHJP=new ServletFindAllXHJP();
	private XHJPServiceImpl XHJPServiceImpl=new XHJPServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJPID = Integer.parseInt(request.getParameter("XHJPID"));
	
		int rs=XHJPServiceImpl.deleteXHJP(XHJPID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllXHJP.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllXHJP.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
