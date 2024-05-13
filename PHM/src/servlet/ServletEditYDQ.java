package servlet;

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

public class ServletEditYDQ extends HttpServlet{

	private YDQ YDQ;
	private ServletFindAllYDQ servletFindAllYDQ=new ServletFindAllYDQ();
	private ServletSelectYDQ selectOne=new ServletSelectYDQ();
	private YDQServiceImpl YDQServiceImpl=new YDQServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int YDQID=Integer.parseInt(request.getParameter("YDQID"));
		String YDQName = request.getParameter("YDQName");
		String YDQHealth = request.getParameter("YDQHealth");
		String YDQMDate1 = request.getParameter("YDQMDate");
		String YDQIDate1 = request.getParameter("YDQIDate");
		Date YDQMDate=null;
		Date YDQIDate=null;
		try {
			YDQMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("YDQMDate"));
			YDQIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("YDQIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		YDQ=new YDQ(YDQID,YDQName,YDQMDate,YDQIDate,YDQHealth);
		int rs=YDQServiceImpl.editYDQ(YDQ,YDQMDate1,YDQIDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllYDQ.doGet(request, response);
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
