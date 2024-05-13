package servlet;

import model.XHJ;
import service.Impl.XHJServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditXHJ extends HttpServlet{

	private XHJ XHJ;
	private ServletFindAllXHJ servletFindAllXHJ=new ServletFindAllXHJ();
	private ServletSelectXHJ selectOne=new ServletSelectXHJ();
	private XHJServiceImpl XHJServiceImpl=new XHJServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int XHJID=Integer.parseInt(request.getParameter("XHJID"));
		String XHJName = request.getParameter("XHJName");
		String XHJHealth = request.getParameter("XHJHealth");
		String XHJMDate1 = request.getParameter("XHJMDate");
		String XHJIDate1 = request.getParameter("XHJIDate");
		Date XHJMDate=null;
		Date XHJIDate=null;
		try {
			XHJMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("XHJMDate"));
			XHJIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("XHJIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		XHJ=new XHJ(XHJID,XHJName,XHJMDate,XHJIDate,XHJHealth);
		int rs=XHJServiceImpl.editXHJ(XHJ,XHJMDate1,XHJIDate1);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			servletFindAllXHJ.doGet(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			selectOne.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
