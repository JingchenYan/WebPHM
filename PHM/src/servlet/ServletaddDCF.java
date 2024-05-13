package servlet;

import model.DCF;
import service.Impl.DCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddDCF extends HttpServlet{

	private DCF dcf;
	private ServletFindAllDCF servletFindAllDCF=new ServletFindAllDCF();
	private DCFServiceImpl DCFServiceImpl=new DCFServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("DCFName").isEmpty()
				|| request.getParameter("DCFDate").isEmpty()
				|| request.getParameter("DCFault").isEmpty()){
			request.setAttribute("msg", "������������Ϣ����");
			request.getRequestDispatcher("admin/addDCF.jsp").forward(request, response);
		}
		String DCFName = request.getParameter("DCFName");
		String DCFDate1 = request.getParameter("DCFDate");
		Date DCFDate=null;
		try {
			DCFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DCFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String DCFault = request.getParameter("DCFault");


		dcf=new DCF(DCFName,DCFDate,DCFault);
		DCF DCF=DCFServiceImpl.selectOneDC(dcf);
			int rs=DCFServiceImpl.addDCF(dcf,DCFDate1);
			if(rs>0){
				request.setAttribute("msg", "��ӳɹ�����");
				servletFindAllDCF.doGet(request, response);
			}else{
				request.setAttribute("msg", "���ʧ�ܣ���");
				request.getRequestDispatcher("admin/addDCF.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
