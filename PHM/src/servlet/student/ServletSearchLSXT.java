package servlet.student;

import model.LSXT;
import model.PageBean;
import service.Impl.LSXTServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchLSXT extends HttpServlet{

	private LSXT lsxt;
	private LSXTServiceImpl LSXTServiceImpl=new LSXTServiceImpl();

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
		String LSXTName=request.getParameter("LSXTName");
		String LSXTHealth=request.getParameter("LSXTHealth");
        String LSXTMDate1 = request.getParameter("LSXTMDate");
        String LSXTIDate1 = request.getParameter("LSXTIDate");
        Date LSXTMDate=null;
        Date LSXTIDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (LSXTMDate1 != null && !LSXTMDate1.isEmpty()) {
				LSXTMDate = sdf.parse(LSXTMDate1);
			}
			if (LSXTIDate1 != null && !LSXTIDate1.isEmpty()) {
				LSXTIDate = sdf.parse(LSXTIDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lsxt=new LSXT(LSXTName, LSXTMDate, LSXTIDate, LSXTHealth);
		PageBean rs=LSXTServiceImpl.selectLSXT(pageNo, pageCount, LSXTName);
		request.setAttribute("list", rs);
		request.setAttribute("lsxt", lsxt);
		request.getRequestDispatcher("student/selectLSXT.jsp").forward(request, response);
	}

}
