package servlet;

import model.XHJF;
import service.Impl.XHJFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteXHJF extends HttpServlet{

	private XHJF XHJF;
	private ServletFindAllXHJF servletFindAllXHJF=new ServletFindAllXHJF();
	private XHJFServiceImpl XHJFServiceImpl=new XHJFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJFID = Integer.parseInt(request.getParameter("XHJFID"));
	
		int rs=XHJFServiceImpl.deleteXHJF(XHJFID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllXHJF.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllXHJF.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
