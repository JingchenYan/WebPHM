package servlet;

import model.CTCF;
import service.Impl.CTCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddCTCF extends HttpServlet{

	private CTCF ctcf;
	private ServletFindAllCTCF servletFindAllCTCF=new ServletFindAllCTCF();
	private CTCFServiceImpl CTCFServiceImpl=new CTCFServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("CTCFName").isEmpty()
				|| request.getParameter("CTCFDate").isEmpty()
				|| request.getParameter("CTCRDate").isEmpty()
				|| request.getParameter("CTCPop").isEmpty()
				|| request.getParameter("CTCFault").isEmpty()){
			request.setAttribute("msg", "请输入完整信息！！");
			request.getRequestDispatcher("admin/addCTCF.jsp").forward(request, response);
		}
		String CTCFName = request.getParameter("CTCFName");
		String CTCFDate1 = request.getParameter("CTCFDate");
		String CTCRDate1 = request.getParameter("CTCRDate");
		Date CTCFDate=null;
		Date CTCRDate=null;
		try {
			CTCFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCFDate"));
			CTCRDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCRDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String CTCPop = request.getParameter("CTCPop");
		String CTCFault = request.getParameter("CTCFault");


		ctcf=new CTCF(CTCFName,CTCFDate,CTCRDate,CTCPop,CTCFault);
		CTCF CTCF=CTCFServiceImpl.selectOneCTC(ctcf);
			int rs=CTCFServiceImpl.addCTCF(ctcf,CTCFDate1,CTCRDate1);
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllCTCF.doGet(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addCTCF.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
