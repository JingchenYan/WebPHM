package servlet;

import model.YDQF;
import service.Impl.YDQFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteYDQF extends HttpServlet{

	private YDQF YDQF;
	private ServletFindAllYDQF servletFindAllYDQF=new ServletFindAllYDQF();
	private YDQFServiceImpl YDQFServiceImpl=new YDQFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int YDQFID = Integer.parseInt(request.getParameter("YDQFID"));
	
		int rs=YDQFServiceImpl.deleteYDQF(YDQFID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllYDQF.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllYDQF.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
