package servlet;

import model.DCF;
import service.Impl.DCFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditDCF extends HttpServlet{

	private DCF DCF;
	private ServletFindAllDCF servletFindAllDCF=new ServletFindAllDCF();
	private ServletSelectDCF selectOne=new ServletSelectDCF();
	private DCFServiceImpl DCFServiceImpl=new DCFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int DCFID=Integer.parseInt(request.getParameter("DCFID"));
		String DCFName = request.getParameter("DCFName");
		String DCFault = request.getParameter("DCFault");
		String DCFDate1 = request.getParameter("DCFDate");
		Date DCFDate=null;
		try {
			DCFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DCFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		DCF=new DCF(DCFID,DCFName,DCFDate,DCFault);
		int rs=DCFServiceImpl.editDCF(DCF,DCFDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllDCF.doGet(request, response);
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
