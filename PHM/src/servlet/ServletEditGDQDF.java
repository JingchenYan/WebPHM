package servlet;

import model.GDQDF;
import service.Impl.GDQDFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditGDQDF extends HttpServlet{

	private GDQDF GDQDF;
	private ServletFindAllGDQDF servletFindAllGDQDF=new ServletFindAllGDQDF();
	private ServletSelectGDQDF selectOne=new ServletSelectGDQDF();
	private GDQDFServiceImpl GDQDFServiceImpl=new GDQDFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int GDQDFID=Integer.parseInt(request.getParameter("GDQDFID"));
		String GDQDFName = request.getParameter("GDQDFName");
		String GDQDFault = request.getParameter("GDQDFault");
		String GDQDFDate1 = request.getParameter("GDQDFDate");
		Date GDQDFDate=null;
		try {
			GDQDFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("GDQDFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		GDQDF=new GDQDF(GDQDFID,GDQDFName,GDQDFDate,GDQDFault);
		int rs=GDQDFServiceImpl.editGDQDF(GDQDF,GDQDFDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllGDQDF.doGet(request, response);
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
