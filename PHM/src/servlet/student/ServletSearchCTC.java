package servlet.student;

import model.CTC;
import model.PageBean;
import service.Impl.CTCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchCTC extends HttpServlet{

	private CTC ctc;
	private CTCServiceImpl CTCServiceImpl=new CTCServiceImpl();

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
		String CTCName=request.getParameter("CTCName");
		String CTCHealth=request.getParameter("CTCHealth");
        String CTCMDate1 = request.getParameter("CTCMDate");
        String CTCIDate1 = request.getParameter("CTCIDate");
        Date CTCMDate=null;
        Date CTCIDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (CTCMDate1 != null && !CTCMDate1.isEmpty()) {
				CTCMDate = sdf.parse(CTCMDate1);
			}
			if (CTCIDate1 != null && !CTCIDate1.isEmpty()) {
				CTCIDate = sdf.parse(CTCIDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ctc=new CTC(CTCName, CTCMDate, CTCIDate, CTCHealth);
		PageBean rs=CTCServiceImpl.selectCTC(pageNo, pageCount, CTCName);
		request.setAttribute("list", rs);
		request.setAttribute("ctc", ctc);
		request.getRequestDispatcher("student/selectCTC.jsp").forward(request, response);
	}

}
