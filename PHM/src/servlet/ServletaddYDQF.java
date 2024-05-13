package servlet;

import model.YDQF;
import service.Impl.YDQFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddYDQF extends HttpServlet{

	private YDQF ydqf;
	private ServletFindAllYDQF servletFindAllYDQF=new ServletFindAllYDQF();
	private YDQFServiceImpl YDQFServiceImpl=new YDQFServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("YDQFName").isEmpty()
				|| request.getParameter("YDQFDate").isEmpty()
				|| request.getParameter("YDQFault").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addYDQF.jsp").forward(request, response);
		}
		String YDQFName = request.getParameter("YDQFName");
		String YDQFDate1 = request.getParameter("YDQFDate");
		Date YDQFDate=null;
		try {
			YDQFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("YDQFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String YDQFault = request.getParameter("YDQFault");


		ydqf=new YDQF(YDQFName,YDQFDate,YDQFault);
		YDQF YDQF=YDQFServiceImpl.selectOneYDQ(ydqf);
			int rs=YDQFServiceImpl.addYDQF(ydqf,YDQFDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllYDQF.doGet(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addYDQF.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
