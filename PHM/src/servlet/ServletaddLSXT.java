package servlet;

import model.LSXT;
import service.Impl.LSXTServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddLSXT extends HttpServlet{

	private LSXT lsxt;
	private ServletFindAllLSXT servletFindAllLSXT=new ServletFindAllLSXT();
	private LSXTServiceImpl LSXTServiceImpl=new LSXTServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("LSXTName").isEmpty()
				|| request.getParameter("LSXTMDate").isEmpty()
				|| request.getParameter("LSXTIDate").isEmpty()
				|| request.getParameter("LSXTHealth").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addLSXT.jsp").forward(request, response);
		}
		String LSXTName = request.getParameter("LSXTName");
		String LSXTMDate1 = request.getParameter("LSXTMDate");
		String LSXTIDate1 = request.getParameter("LSXTIDate");
		Date LSXTMDate=null;
		Date LSXTIDate=null;
		try {
			LSXTMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("LSXTMDate"));
			LSXTIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("LSXTIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String LSXTHealth = request.getParameter("LSXTHealth");


		lsxt=new LSXT(LSXTName,LSXTMDate,LSXTIDate,LSXTHealth);
		//验证是否存在该设备
		LSXT LSXT=LSXTServiceImpl.selectOneLSXT(lsxt);
		if(LSXT==null){
			int rs=LSXTServiceImpl.addLSXT(lsxt,LSXTMDate1,LSXTIDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllLSXT.doGet(request, response);
			//	request.getRequestDispatcher("admin/addLSXT.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addLSXT.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该设备已存在，请重新输入！！");
			request.getRequestDispatcher("admin/addLSXT.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
