package servlet.student;

import model.PageBean;
import model.XHJF;
import service.Impl.XHJFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchXHJF extends HttpServlet{

	private XHJF xhjf;
	private XHJFServiceImpl XHJFServiceImpl=new XHJFServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String XHJFName=request.getParameter("XHJFName");
		String XHJFault=request.getParameter("XHJFault");
		String XHJPop=request.getParameter("XHJPop");
		String XHJFDate1 = request.getParameter("XHJFDate");
		String XHJRDate1 = request.getParameter("XHJRDate");
		Date XHJFDate=null;
		Date XHJRDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (XHJFDate1 != null && !XHJFDate1.isEmpty()) {
				XHJFDate = sdf.parse(XHJFDate1);
			}
			if (XHJRDate1 != null && !XHJRDate1.isEmpty()) {
				XHJRDate = sdf.parse(XHJRDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		xhjf=new XHJF(XHJFName, XHJFDate, XHJRDate, XHJPop, XHJFault);
		PageBean rs=XHJFServiceImpl.selectXHJF(pageNo, pageCount, XHJFName);
		request.setAttribute("list", rs);
		request.setAttribute("xhjf", xhjf);
		request.getRequestDispatcher("admin/selectXHJF.jsp").forward(request, response);
	}

}