package servlet;

import model.DC;
import service.Impl.DCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteDC extends HttpServlet{

	private DC DC;
	private ServletFindAllDC servletFindAllDC=new ServletFindAllDC();
	private DCServiceImpl DCServiceImpl=new DCServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int DCID = Integer.parseInt(request.getParameter("DCID"));
	
		int rs=DCServiceImpl.deleteDC(DCID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllDC.doGet(request, response);
			//	request.getRequestDispatcher("admin/addDC.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllDC.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
