package servlet.student;

import model.PageBean;
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

public class ServletSearchXHJ extends HttpServlet{

	private XHJ xhj;
	private XHJServiceImpl XHJServiceImpl=new XHJServiceImpl();

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
		String XHJName=request.getParameter("XHJName");
		String XHJHealth=request.getParameter("XHJHealth");
        String XHJMDate1 = request.getParameter("XHJMDate");
        String XHJIDate1 = request.getParameter("XHJIDate");
        Date XHJMDate=null;
        Date XHJIDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (XHJMDate1 != null && !XHJMDate1.isEmpty()) {
				XHJMDate = sdf.parse(XHJMDate1);
			}
			if (XHJIDate1 != null && !XHJIDate1.isEmpty()) {
				XHJIDate = sdf.parse(XHJIDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		xhj=new XHJ(XHJName, XHJMDate, XHJIDate, XHJHealth);
		PageBean rs=XHJServiceImpl.selectXHJ(pageNo, pageCount, XHJName);
		request.setAttribute("list", rs);
		request.setAttribute("xhj", xhj);
		request.getRequestDispatcher("student/selectXHJ.jsp").forward(request, response);
	}

}
