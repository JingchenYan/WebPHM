package servlet;

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

public class ServletEditYDQF extends HttpServlet{

	private YDQF YDQF;
	private ServletFindAllYDQF servletFindAllYDQF=new ServletFindAllYDQF();
	private ServletSelectYDQF selectOne=new ServletSelectYDQF();
	private YDQFServiceImpl YDQFServiceImpl=new YDQFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int YDQFID=Integer.parseInt(request.getParameter("YDQFID"));
		String YDQFName = request.getParameter("YDQFName");
		String YDQFault = request.getParameter("YDQFault");
		String YDQFDate1 = request.getParameter("YDQFDate");
		Date YDQFDate=null;
		try {
			YDQFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("YDQFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		YDQF=new YDQF(YDQFID,YDQFName,YDQFDate,YDQFault);
		int rs=YDQFServiceImpl.editYDQF(YDQF,YDQFDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllYDQF.doGet(request, response);
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
