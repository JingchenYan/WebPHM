package servlet;

import model.YDQ;
import service.Impl.YDQServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddYDQ extends HttpServlet{

	private YDQ ydq;
	private ServletFindAllYDQ servletFindAllYDQ=new ServletFindAllYDQ();
	private YDQServiceImpl YDQServiceImpl=new YDQServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("YDQName").isEmpty()
				|| request.getParameter("YDQMDate").isEmpty()
				|| request.getParameter("YDQIDate").isEmpty()
				|| request.getParameter("YDQHealth").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addYDQ.jsp").forward(request, response);
		}
		String YDQName = request.getParameter("YDQName");
		String YDQMDate1 = request.getParameter("YDQMDate");
		String YDQIDate1 = request.getParameter("YDQIDate");
		Date YDQMDate=null;
		Date YDQIDate=null;
		try {
			YDQMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("YDQMDate"));
			YDQIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("YDQIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String YDQHealth = request.getParameter("YDQHealth");


		ydq=new YDQ(YDQName,YDQMDate,YDQIDate,YDQHealth);
		//验证是否存在该设备
		YDQ YDQ=YDQServiceImpl.selectOneYDQ(ydq);
		if(YDQ==null){
			int rs=YDQServiceImpl.addYDQ(ydq,YDQMDate1,YDQIDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllYDQ.doGet(request, response);
			//	request.getRequestDispatcher("admin/addYDQ.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addYDQ.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该设备已存在，请重新输入！！");
			request.getRequestDispatcher("admin/addYDQ.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
