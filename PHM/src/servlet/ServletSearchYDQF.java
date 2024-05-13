package servlet;

import model.PageBean;
import model.YDQF;
import service.Impl.YDQFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchYDQF extends HttpServlet{

	private YDQF ydqf;
	private YDQFServiceImpl YDQFServiceImpl=new YDQFServiceImpl();

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
		String YDQFName=request.getParameter("YDQFName");
		String YDQFault=request.getParameter("YDQFault");
        String YDQFDate1 = request.getParameter("YDQFDate");
        Date YDQFDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (YDQFDate1 != null && !YDQFDate1.isEmpty()) {
				YDQFDate = sdf.parse(YDQFDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ydqf=new YDQF(YDQFName, YDQFDate, YDQFault);
		PageBean rs=YDQFServiceImpl.selectYDQF(pageNo, pageCount, YDQFName);
		request.setAttribute("list", rs);
		request.setAttribute("ydqf", ydqf);
		request.getRequestDispatcher("admin/selectYDQF.jsp").forward(request, response);
	}

}
