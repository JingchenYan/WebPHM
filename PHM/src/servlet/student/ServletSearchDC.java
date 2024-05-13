package servlet.student;

import model.DC;
import model.PageBean;
import service.Impl.DCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchDC extends HttpServlet{

	private DC dc;
	private DCServiceImpl DCServiceImpl=new DCServiceImpl();

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
		String DCName=request.getParameter("DCName");
		String DCHealth=request.getParameter("DCHealth");
        String DCMDate1 = request.getParameter("DCMDate");
        String DCIDate1 = request.getParameter("DCIDate");
        Date DCMDate=null;
        Date DCIDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (DCMDate1 != null && !DCMDate1.isEmpty()) {
				DCMDate = sdf.parse(DCMDate1);
			}
			if (DCIDate1 != null && !DCIDate1.isEmpty()) {
				DCIDate = sdf.parse(DCIDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dc=new DC(DCName, DCMDate, DCIDate, DCHealth);
		PageBean rs=DCServiceImpl.selectDC(pageNo, pageCount, DCName);
		request.setAttribute("list", rs);
		request.setAttribute("dc", dc);
		request.getRequestDispatcher("student/selectDC.jsp").forward(request, response);
	}

}
