package servlet;

import model.LSXTF;
import service.Impl.LSXTFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteLSXTF extends HttpServlet{

	private LSXTF LSXTF;
	private ServletFindAllLSXTF servletFindAllLSXTF=new ServletFindAllLSXTF();
	private LSXTFServiceImpl LSXTFServiceImpl=new LSXTFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int LSXTFID = Integer.parseInt(request.getParameter("LSXTFID"));
	
		int rs=LSXTFServiceImpl.deleteLSXTF(LSXTFID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllLSXTF.doGet(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllLSXTF.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
