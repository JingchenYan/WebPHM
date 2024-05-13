package servlet;

import model.GDQD;
import service.Impl.GDQDServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteGDQD extends HttpServlet{

	private GDQD GDQD;
	private ServletFindAllGDQD servletFindAllGDQD=new ServletFindAllGDQD();
	private GDQDServiceImpl GDQDServiceImpl=new GDQDServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int GDQDID = Integer.parseInt(request.getParameter("GDQDID"));
	
		int rs=GDQDServiceImpl.deleteGDQD(GDQDID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllGDQD.doGet(request, response);
			//	request.getRequestDispatcher("admin/addGDQD.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllGDQD.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
