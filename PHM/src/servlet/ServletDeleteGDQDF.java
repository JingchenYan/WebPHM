package servlet;

import model.GDQDF;
import service.Impl.GDQDFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteGDQDF extends HttpServlet{

	private GDQDF GDQDF;
	private ServletFindAllGDQDF servletFindAllGDQDF=new ServletFindAllGDQDF();
	private GDQDFServiceImpl GDQDFServiceImpl=new GDQDFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int GDQDFID = Integer.parseInt(request.getParameter("GDQDFID"));
	
		int rs=GDQDFServiceImpl.deleteGDQDF(GDQDFID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllGDQDF.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllGDQDF.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
