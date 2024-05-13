package servlet;

import model.GDQDF;
import service.Impl.GDQDFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddGDQDF extends HttpServlet{

	private GDQDF gdqdf;
	private ServletFindAllGDQDF servletFindAllGDQDF=new ServletFindAllGDQDF();
	private GDQDFServiceImpl GDQDFServiceImpl=new GDQDFServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("GDQDFName").isEmpty()
				|| request.getParameter("GDQDFDate").isEmpty()
				|| request.getParameter("GDQDFault").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addGDQDF.jsp").forward(request, response);
		}
		String GDQDFName = request.getParameter("GDQDFName");
		String GDQDFDate1 = request.getParameter("GDQDFDate");
		Date GDQDFDate=null;
		try {
			GDQDFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("GDQDFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String GDQDFault = request.getParameter("GDQDFault");


		gdqdf=new GDQDF(GDQDFName,GDQDFDate,GDQDFault);
		GDQDF GDQDF=GDQDFServiceImpl.selectOneGDQD(gdqdf);
			int rs=GDQDFServiceImpl.addGDQDF(gdqdf,GDQDFDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllGDQDF.doGet(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addGDQDF.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
