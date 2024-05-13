package servlet;

import model.PageBean;
import model.CTCF;
import service.Impl.CTCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchCTCF extends HttpServlet{

	private CTCF ctcf;
	private CTCFServiceImpl CTCFServiceImpl=new CTCFServiceImpl();

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
		String CTCFName=request.getParameter("CTCFName");
		String CTCFault=request.getParameter("CTCFault");
		String CTCPop=request.getParameter("CTCPop");
        String CTCFDate1 = request.getParameter("CTCFDate");
		String CTCRDate1 = request.getParameter("CTCRDate");
        Date CTCFDate=null;
		Date CTCRDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (CTCFDate1 != null && !CTCFDate1.isEmpty()) {
				CTCFDate = sdf.parse(CTCFDate1);
			}
			if (CTCRDate1 != null && !CTCRDate1.isEmpty()) {
				CTCRDate = sdf.parse(CTCRDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ctcf=new CTCF(CTCFName, CTCFDate, CTCRDate, CTCPop, CTCFault);
		PageBean rs=CTCFServiceImpl.selectCTCF(pageNo, pageCount, CTCFName);
		request.setAttribute("list", rs);
		request.setAttribute("ctcf", ctcf);
		request.getRequestDispatcher("admin/selectCTCF.jsp").forward(request, response);
	}

}
