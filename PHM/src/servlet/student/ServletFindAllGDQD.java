package servlet.student;

import model.PageBean;
import service.Impl.GDQDServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletFindAllGDQD extends HttpServlet{

	
	private GDQDServiceImpl GDQDServiceImpl=new GDQDServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		int pageNo=1;
		int pageCount=10;
		
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
		PageBean list=GDQDServiceImpl.GDQDListPage(pageNo, pageCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("student/GDQDAllInfo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
