package servlet;

import model.CTCF;
import service.Impl.CTCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteCTCF extends HttpServlet{

	private CTCF CTCF;
	private ServletFindAllCTCF servletFindAllCTCF=new ServletFindAllCTCF();
	private CTCFServiceImpl CTCFServiceImpl=new CTCFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CTCFID = Integer.parseInt(request.getParameter("CTCFID"));
	
		int rs=CTCFServiceImpl.deleteCTCF(CTCFID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllCTCF.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllCTCF.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
