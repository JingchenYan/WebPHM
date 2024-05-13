package servlet;

import model.YDQ;
import service.Impl.YDQServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDeleteYDQ extends HttpServlet{

	private YDQ YDQ;
	private ServletFindAllYDQ servletFindAllYDQ=new ServletFindAllYDQ();
	private YDQServiceImpl YDQServiceImpl=new YDQServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int YDQID = Integer.parseInt(request.getParameter("YDQID"));
	
		int rs=YDQServiceImpl.deleteYDQ(YDQID);
		if(rs>0){
			request.setAttribute("msg", "ɾ���ɹ�����");
			servletFindAllYDQ.doGet(request, response);
			//	request.getRequestDispatcher("admin/addYDQ.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "ɾ��ʧ�ܣ���");
			servletFindAllYDQ.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
