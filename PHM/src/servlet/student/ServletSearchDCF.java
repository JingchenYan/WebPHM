package servlet.student;

import model.DCF;
import model.PageBean;
import service.Impl.DCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchDCF extends HttpServlet{

	private DCF dcf;
	private DCFServiceImpl DCFServiceImpl=new DCFServiceImpl();

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
		String DCFName=request.getParameter("DCFName");
		String DCFault=request.getParameter("DCFault");
        String DCFDate1 = request.getParameter("DCFDate");
        Date DCFDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (DCFDate1 != null && !DCFDate1.isEmpty()) {
				DCFDate = sdf.parse(DCFDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dcf=new DCF(DCFName, DCFDate, DCFault);
		PageBean rs=DCFServiceImpl.selectDCF(pageNo, pageCount, DCFName);
		request.setAttribute("list", rs);
		request.setAttribute("dcf", dcf);
		request.getRequestDispatcher("student/selectDCF.jsp").forward(request, response);
	}

}
