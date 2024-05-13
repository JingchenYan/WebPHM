package servlet.student;

import model.LSXTF;
import model.PageBean;
import service.Impl.LSXTFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletSearchLSXTF extends HttpServlet{

	private LSXTF lsxtf;
	private LSXTFServiceImpl LSXTFServiceImpl=new LSXTFServiceImpl();

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
		String LSXTFName=request.getParameter("LSXTFName");
		String LSXTFault=request.getParameter("LSXTFault");
        String LSXTFDate1 = request.getParameter("LSXTFDate");
        Date LSXTFDate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (LSXTFDate1 != null && !LSXTFDate1.isEmpty()) {
				LSXTFDate = sdf.parse(LSXTFDate1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lsxtf=new LSXTF(LSXTFName, LSXTFDate, LSXTFault);
		PageBean rs=LSXTFServiceImpl.selectLSXTF(pageNo, pageCount, LSXTFName);
		request.setAttribute("list", rs);
		request.setAttribute("lsxtf", lsxtf);
		request.getRequestDispatcher("student/selectLSXTF.jsp").forward(request, response);
	}

}
