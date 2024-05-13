package servlet;

import model.DC;
import service.Impl.DCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddDC extends HttpServlet{

	private DC dc;
	private ServletFindAllDC servletFindAllDC=new ServletFindAllDC();
	private DCServiceImpl DCServiceImpl=new DCServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("DCName").isEmpty()
				|| request.getParameter("DCMDate").isEmpty()
				|| request.getParameter("DCIDate").isEmpty()
				|| request.getParameter("DCHealth").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addDC.jsp").forward(request, response);
		}
		String DCName = request.getParameter("DCName");
		String DCMDate1 = request.getParameter("DCMDate");
		String DCIDate1 = request.getParameter("DCIDate");
		Date DCMDate=null;
		Date DCIDate=null;
		try {
			DCMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DCMDate"));
			DCIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DCIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String DCHealth = request.getParameter("DCHealth");


		dc=new DC(DCName,DCMDate,DCIDate,DCHealth);
		//验证是否存在该设备
		DC DC=DCServiceImpl.selectOneDC(dc);
		if(DC==null){
			int rs=DCServiceImpl.addDC(dc,DCMDate1,DCIDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllDC.doGet(request, response);
			//	request.getRequestDispatcher("admin/addDC.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addDC.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该设备已存在，请重新输入！！");
			request.getRequestDispatcher("admin/addDC.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
