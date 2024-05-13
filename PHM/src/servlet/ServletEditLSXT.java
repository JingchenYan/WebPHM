package servlet;

import model.LSXT;
import service.Impl.LSXTServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditLSXT extends HttpServlet{

	private LSXT LSXT;
	private ServletFindAllLSXT servletFindAllLSXT=new ServletFindAllLSXT();
	private ServletSelectLSXT selectOne=new ServletSelectLSXT();
	private LSXTServiceImpl LSXTServiceImpl=new LSXTServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int LSXTID=Integer.parseInt(request.getParameter("LSXTID"));
		String LSXTName = request.getParameter("LSXTName");
		String LSXTHealth = request.getParameter("LSXTHealth");
		String LSXTMDate1 = request.getParameter("LSXTMDate");
		String LSXTIDate1 = request.getParameter("LSXTIDate");
		Date LSXTMDate=null;
		Date LSXTIDate=null;
		try {
			LSXTMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("LSXTMDate"));
			LSXTIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("LSXTIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		LSXT=new LSXT(LSXTID,LSXTName,LSXTMDate,LSXTIDate,LSXTHealth);
		int rs=LSXTServiceImpl.editLSXT(LSXT,LSXTMDate1,LSXTIDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllLSXT.doGet(request, response);
		}else{
			request.setAttribute("msg", " ޸ ʧ ܣ   ");
			selectOne.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
