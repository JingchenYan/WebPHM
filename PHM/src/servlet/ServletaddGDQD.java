package servlet;

import model.GDQD;
import service.Impl.GDQDServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddGDQD extends HttpServlet{

	private GDQD gdqd;
	private ServletFindAllGDQD servletFindAllGDQD=new ServletFindAllGDQD();
	private GDQDServiceImpl GDQDServiceImpl=new GDQDServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("GDQDName").isEmpty()
				|| request.getParameter("GDQDMDate").isEmpty()
				|| request.getParameter("GDQDIDate").isEmpty()
				|| request.getParameter("GDQDHealth").isEmpty()){
			request.setAttribute("msg", "������������Ϣ����");
			request.getRequestDispatcher("admin/addGDQD.jsp").forward(request, response);
		}
		String GDQDName = request.getParameter("GDQDName");
		String GDQDMDate1 = request.getParameter("GDQDMDate");
		String GDQDIDate1 = request.getParameter("GDQDIDate");
		Date GDQDMDate=null;
		Date GDQDIDate=null;
		try {
			GDQDMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("GDQDMDate"));
			GDQDIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("GDQDIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String GDQDHealth = request.getParameter("GDQDHealth");


		gdqd=new GDQD(GDQDName,GDQDMDate,GDQDIDate,GDQDHealth);
		//��֤�Ƿ���ڸ��豸
		GDQD GDQD=GDQDServiceImpl.selectOneGDQD(gdqd);
		if(GDQD==null){
			int rs=GDQDServiceImpl.addGDQD(gdqd,GDQDMDate1,GDQDIDate1);
			if(rs>0){
				request.setAttribute("msg", "��ӳɹ�����");
				servletFindAllGDQD.doGet(request, response);
			//	request.getRequestDispatcher("admin/addGDQD.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "���ʧ�ܣ���");
				request.getRequestDispatcher("admin/addGDQD.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "���豸�Ѵ��ڣ����������룡��");
			request.getRequestDispatcher("admin/addGDQD.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
