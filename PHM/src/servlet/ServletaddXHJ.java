package servlet;

import model.XHJ;
import service.Impl.XHJServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletaddXHJ extends HttpServlet{

	private XHJ xhj;
	private ServletFindAllXHJ servletFindAllXHJ=new ServletFindAllXHJ();
	private XHJServiceImpl XHJServiceImpl=new XHJServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("XHJName").isEmpty()
				|| request.getParameter("XHJMDate").isEmpty()
				|| request.getParameter("XHJIDate").isEmpty()
				|| request.getParameter("XHJHealth").isEmpty()){
			request.setAttribute("msg", "������������Ϣ����");
			request.getRequestDispatcher("admin/addXHJ.jsp").forward(request, response);
		}
		String XHJName = request.getParameter("XHJName");
		String XHJMDate1 = request.getParameter("XHJMDate");
		String XHJIDate1 = request.getParameter("XHJIDate");
		Date XHJMDate=null;
		Date XHJIDate=null;
		try {
			XHJMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("XHJMDate"));
			XHJIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("XHJIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String XHJHealth = request.getParameter("XHJHealth");


		xhj=new XHJ(XHJName,XHJMDate,XHJIDate,XHJHealth);
		//��֤�Ƿ���ڸ��豸
		XHJ XHJ=XHJServiceImpl.selectOneXHJ(xhj);
		if(XHJ==null){
			int rs=XHJServiceImpl.addXHJ(xhj,XHJMDate1,XHJIDate1);
			if(rs>0){
				request.setAttribute("msg", "��ӳɹ�����");
				servletFindAllXHJ.doGet(request, response);
			//	request.getRequestDispatcher("admin/addXHJ.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "���ʧ�ܣ���");
				request.getRequestDispatcher("admin/addXHJ.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "���豸�Ѵ��ڣ����������룡��");
			request.getRequestDispatcher("admin/addXHJ.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
