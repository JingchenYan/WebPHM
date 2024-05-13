package servlet;

import model.CTC;
import service.Impl.CTCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditCTC extends HttpServlet{

	private CTC CTC;
	private ServletFindAllCTC servletFindAllCTC=new ServletFindAllCTC();
	private ServletSelectCTC selectOne=new ServletSelectCTC();
	private CTCServiceImpl CTCServiceImpl=new CTCServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CTCID=Integer.parseInt(request.getParameter("CTCID"));
		String CTCName = request.getParameter("CTCName");
		String CTCHealth = request.getParameter("CTCHealth");
		String CTCMDate1 = request.getParameter("CTCMDate");
		String CTCIDate1 = request.getParameter("CTCIDate");
		Date CTCMDate=null;
		Date CTCIDate=null;
		try {
			CTCMDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCMDate"));
			CTCIDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCIDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		CTC=new CTC(CTCID,CTCName,CTCMDate,CTCIDate,CTCHealth);
		int rs=CTCServiceImpl.editCTC(CTC,CTCMDate1,CTCIDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllCTC.doGet(request, response);
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
