package servlet;

import model.XHJF;
import service.Impl.XHJFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditXHJF extends HttpServlet{

	private XHJF XHJF;
	private ServletFindAllXHJF servletFindAllXHJF=new ServletFindAllXHJF();
	private ServletSelectXHJF selectOne=new ServletSelectXHJF();
	private XHJFServiceImpl XHJFServiceImpl=new XHJFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJFID=Integer.parseInt(request.getParameter("XHJFID"));
		String XHJFName = request.getParameter("XHJFName");
		String XHJFault = request.getParameter("XHJFault");
		String XHJPop = request.getParameter("XHJPop");
		String XHJFDate1 = request.getParameter("XHJFDate");
		String XHJRDate1 = request.getParameter("XHJRDate");
		Date XHJFDate=null;
		Date XHJRDate=null;
		try {
			XHJFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("XHJFDate"));
			XHJRDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("XHJRDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		XHJF=new XHJF(XHJFID,XHJFName,XHJFDate,XHJRDate,XHJPop,XHJFault);
		int rs=XHJFServiceImpl.editXHJF(XHJF,XHJFDate1,XHJRDate1);
		if(rs>0){
			request.setAttribute("msg", " ???     ");
			servletFindAllXHJF.doGet(request, response);
		}else{
			request.setAttribute("msg", " ? ? ?   ");
			selectOne.doGet(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
