package servlet;

import model.LSXTF;
import service.Impl.LSXTFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddLSXTF extends HttpServlet{

	private LSXTF lsxtf;
	private ServletFindAllLSXTF servletFindAllLSXTF=new ServletFindAllLSXTF();
	private LSXTFServiceImpl LSXTFServiceImpl=new LSXTFServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("LSXTFName").isEmpty()
				|| request.getParameter("LSXTFDate").isEmpty()
				|| request.getParameter("LSXTFault").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addLSXTF.jsp").forward(request, response);
		}
		String LSXTFName = request.getParameter("LSXTFName");
		String LSXTFDate1 = request.getParameter("LSXTFDate");
		Date LSXTFDate=null;
		try {
			LSXTFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("LSXTFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String LSXTFault = request.getParameter("LSXTFault");


		lsxtf=new LSXTF(LSXTFName,LSXTFDate,LSXTFault);
		LSXTF LSXTF=LSXTFServiceImpl.selectOneLSXT(lsxtf);
			int rs=LSXTFServiceImpl.addLSXTF(lsxtf,LSXTFDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllLSXTF.doGet(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addLSXTF.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
