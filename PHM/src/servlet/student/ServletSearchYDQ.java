package servlet.student;

import model.PageBean;
import model.YDQ;
import service.Impl.YDQServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchYDQ extends HttpServlet{

	private YDQ ydq;
	private YDQServiceImpl YDQServiceImpl=new YDQServiceImpl();

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
		String YDQName=request.getParameter("YDQName");
		String YDQHealth=request.getParameter("YDQHealth");
        String YDQMDate1 = request.getParameter("YDQMDate");
        String YDQIDate1 = request.getParameter("YDQIDate");
        Date YDQMDate=null;
        Date YDQIDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (YDQMDate1 != null && !YDQMDate1.isEmpty()) {
				YDQMDate = sdf.parse(YDQMDate1);
			}
			if (YDQIDate1 != null && !YDQIDate1.isEmpty()) {
				YDQIDate = sdf.parse(YDQIDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ydq=new YDQ(YDQName, YDQMDate, YDQIDate, YDQHealth);
		PageBean rs=YDQServiceImpl.selectYDQ(pageNo, pageCount, YDQName);
		request.setAttribute("list", rs);
		request.setAttribute("ydq", ydq);
		request.getRequestDispatcher("student/selectYDQ.jsp").forward(request, response);
	}

}
