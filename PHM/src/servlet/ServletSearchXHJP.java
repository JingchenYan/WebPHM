package servlet;

import model.PageBean;
import model.XHJP;
import service.Impl.XHJPServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchXHJP extends HttpServlet{

	private XHJP xhjp;
	private XHJPServiceImpl XHJPServiceImpl=new XHJPServiceImpl();

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
		String XHJPName=request.getParameter("XHJPName");
        String XHJPDate1 = request.getParameter("XHJPDate");
        Date XHJPDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (XHJPDate1 != null && !XHJPDate1.isEmpty()) {
				XHJPDate = sdf.parse(XHJPDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		xhjp=new XHJP(XHJPName, XHJPDate);
		PageBean rs=XHJPServiceImpl.selectXHJP(pageNo, pageCount, XHJPName);
		request.setAttribute("list", rs);
		request.setAttribute("xhjf", xhjp);
		request.getRequestDispatcher("admin/selectXHJP.jsp").forward(request, response);
	}

}
