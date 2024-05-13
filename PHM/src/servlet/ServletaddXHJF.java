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

public class ServletaddXHJF extends HttpServlet{

	private XHJF xhjf;
	private ServletFindAllXHJF servletFindAllXHJF=new ServletFindAllXHJF();
	private XHJFServiceImpl XHJFServiceImpl=new XHJFServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("XHJFName").isEmpty()
				|| request.getParameter("XHJFDate").isEmpty()
				|| request.getParameter("XHJRDate").isEmpty()
				|| request.getParameter("XHJPop").isEmpty()
				|| request.getParameter("XHJFault").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addXHJF.jsp").forward(request, response);
		}
		String XHJFName = request.getParameter("XHJFName");
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
		String XHJPop = request.getParameter("XHJPop");
		String XHJFault = request.getParameter("XHJFault");


		xhjf=new XHJF(XHJFName,XHJFDate,XHJRDate,XHJPop,XHJFault);
		XHJF XHJF=XHJFServiceImpl.selectOneXHJ(xhjf);
		int rs=XHJFServiceImpl.addXHJF(xhjf,XHJFDate1,XHJRDate1);
		if(rs>0){
			request.setAttribute("msg", "添加成功！！");
			servletFindAllXHJF.doGet(request, response);
		}else{
			request.setAttribute("msg", "添加失败！！");
			request.getRequestDispatcher("admin/addXHJF.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
