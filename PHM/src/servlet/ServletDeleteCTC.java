package servlet;

import model.CTC;
import service.Impl.CTCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteCTC extends HttpServlet{

	private CTC CTC;
	private ServletFindAllCTC servletFindAllCTC=new ServletFindAllCTC();
	private CTCServiceImpl CTCServiceImpl=new CTCServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CTCID = Integer.parseInt(request.getParameter("CTCID"));
	
		int rs=CTCServiceImpl.deleteCTC(CTCID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllCTC.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCTC.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllCTC.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
