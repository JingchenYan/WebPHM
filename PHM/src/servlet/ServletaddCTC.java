package servlet;

import model.CTC;
import service.Impl.CTCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddCTC extends HttpServlet{

	private CTC ctc;
	private ServletFindAllCTC servletFindAllCTC=new ServletFindAllCTC();
	private CTCServiceImpl CTCServiceImpl=new CTCServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("CTCName").isEmpty()
				|| request.getParameter("CTCMDate").isEmpty()
				|| request.getParameter("CTCIDate").isEmpty()
				|| request.getParameter("CTCHealth").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addCTC.jsp").forward(request, response);
		}
		String CTCName = request.getParameter("CTCName");
		String CTCMDate1 = request.getParameter("CTCMDate");
		String CTCIDate1 = request.getParameter("CTCIDate");
		Date CTCMDate=null;
		Date CTCIDate=null;
		try {
			CTCMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCMDate"));
			CTCIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String CTCHealth = request.getParameter("CTCHealth");


		ctc=new CTC(CTCName,CTCMDate,CTCIDate,CTCHealth);
		//验证是否存在该设备
		CTC CTC=CTCServiceImpl.selectOneCTC(ctc);
		if(CTC==null){
			int rs=CTCServiceImpl.addCTC(ctc,CTCMDate1,CTCIDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllCTC.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCTC.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addCTC.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该设备已存在，请重新输入！！");
			request.getRequestDispatcher("admin/addCTC.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
