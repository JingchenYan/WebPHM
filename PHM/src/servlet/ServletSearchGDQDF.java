package servlet;

import model.PageBean;
import model.GDQDF;
import service.Impl.GDQDFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchGDQDF extends HttpServlet{

	private GDQDF gdqdf;
	private GDQDFServiceImpl GDQDFServiceImpl=new GDQDFServiceImpl();

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
		String GDQDFName=request.getParameter("GDQDFName");
		String GDQDFault=request.getParameter("GDQDFault");
        String GDQDFDate1 = request.getParameter("GDQDFDate");
        Date GDQDFDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (GDQDFDate1 != null && !GDQDFDate1.isEmpty()) {
				GDQDFDate = sdf.parse(GDQDFDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		gdqdf=new GDQDF(GDQDFName, GDQDFDate, GDQDFault);
		PageBean rs=GDQDFServiceImpl.selectGDQDF(pageNo, pageCount, GDQDFName);
		request.setAttribute("list", rs);
		request.setAttribute("gdqdf", gdqdf);
		request.getRequestDispatcher("admin/selectGDQDF.jsp").forward(request, response);
	}

}
