package servlet;

import model.GDQD;
import service.Impl.GDQDServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditGDQD extends HttpServlet{

	private GDQD GDQD;
	private ServletFindAllGDQD servletFindAllGDQD=new ServletFindAllGDQD();
	private ServletSelectGDQD selectOne=new ServletSelectGDQD();
	private GDQDServiceImpl GDQDServiceImpl=new GDQDServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int GDQDID=Integer.parseInt(request.getParameter("GDQDID"));
		String GDQDName = request.getParameter("GDQDName");
		String GDQDHealth = request.getParameter("GDQDHealth");
		String GDQDMDate1 = request.getParameter("GDQDMDate");
		String GDQDIDate1 = request.getParameter("GDQDIDate");
		Date GDQDMDate=null;
		Date GDQDIDate=null;
		try {
			GDQDMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("GDQDMDate"));
			GDQDIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("GDQDIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		GDQD=new GDQD(GDQDID,GDQDName,GDQDMDate,GDQDIDate,GDQDHealth);
		int rs=GDQDServiceImpl.editGDQD(GDQD,GDQDMDate1,GDQDIDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllGDQD.doGet(request, response);
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
