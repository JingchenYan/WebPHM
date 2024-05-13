package servlet.student;

import model.GDQD;
import model.PageBean;
import service.Impl.GDQDServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchGDQD extends HttpServlet{

	private GDQD gdqd;
	private GDQDServiceImpl GDQDServiceImpl=new GDQDServiceImpl();

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
		String GDQDName=request.getParameter("GDQDName");
		String GDQDHealth=request.getParameter("GDQDHealth");
        String GDQDMDate1 = request.getParameter("GDQDMDate");
        String GDQDIDate1 = request.getParameter("GDQDIDate");
        Date GDQDMDate=null;
        Date GDQDIDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (GDQDMDate1 != null && !GDQDMDate1.isEmpty()) {
				GDQDMDate = sdf.parse(GDQDMDate1);
			}
			if (GDQDIDate1 != null && !GDQDIDate1.isEmpty()) {
				GDQDIDate = sdf.parse(GDQDIDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		gdqd=new GDQD(GDQDName, GDQDMDate, GDQDIDate, GDQDHealth);
		PageBean rs=GDQDServiceImpl.selectGDQD(pageNo, pageCount, GDQDName);
		request.setAttribute("list", rs);
		request.setAttribute("gdqd", gdqd);
		request.getRequestDispatcher("student/selectGDQD.jsp").forward(request, response);
	}

}
