package servlet;

import model.DCF;
import service.Impl.DCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteDCF extends HttpServlet{

	private DCF DCF;
	private ServletFindAllDCF servletFindAllDCF=new ServletFindAllDCF();
	private DCFServiceImpl DCFServiceImpl=new DCFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int DCFID = Integer.parseInt(request.getParameter("DCFID"));
	
		int rs=DCFServiceImpl.deleteDCF(DCFID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllDCF.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllDCF.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
