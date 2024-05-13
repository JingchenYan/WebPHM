package servlet;

import model.DC;
import service.Impl.DCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditDC extends HttpServlet{

	private DC DC;
	private ServletFindAllDC servletFindAllDC=new ServletFindAllDC();
	private ServletSelectDC selectOne=new ServletSelectDC();
	private DCServiceImpl DCServiceImpl=new DCServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int DCID=Integer.parseInt(request.getParameter("DCID"));
		String DCName = request.getParameter("DCName");
		String DCHealth = request.getParameter("DCHealth");
		String DCMDate1 = request.getParameter("DCMDate");
		String DCIDate1 = request.getParameter("DCIDate");
		Date DCMDate=null;
		Date DCIDate=null;
		try {
			DCMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DCMDate"));
			DCIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DCIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		DC=new DC(DCID,DCName,DCMDate,DCIDate,DCHealth);
		int rs=DCServiceImpl.editDC(DC,DCMDate1,DCIDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllDC.doGet(request, response);
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
