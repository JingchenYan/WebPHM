package servlet.student;

import model.PageBean;
import service.Impl.YDQFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletFindAllYDQF extends HttpServlet{

	
	private YDQFServiceImpl YDQFServiceImpl=new YDQFServiceImpl();
	
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
		
		PageBean list=YDQFServiceImpl.YDQFListPage(pageNo, pageCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("student/YDQFAllInfo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
