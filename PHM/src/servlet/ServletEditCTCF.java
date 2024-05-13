package servlet;

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

public class ServletEditCTCF extends HttpServlet{

	private CTCF CTCF;
	private ServletFindAllCTCF servletFindAllCTCF=new ServletFindAllCTCF();
	private ServletSelectCTCF selectOne=new ServletSelectCTCF();
	private CTCFServiceImpl CTCFServiceImpl=new CTCFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CTCFID=Integer.parseInt(request.getParameter("CTCFID"));
		String CTCFName = request.getParameter("CTCFName");
		String CTCFault = request.getParameter("CTCFault");
		String CTCPop = request.getParameter("CTCPop");
		String CTCFDate1 = request.getParameter("CTCFDate");
		String CTCRDate1 = request.getParameter("CTCRDate");
		Date CTCFDate=null;
		Date CTCRDate=null;
		try {
			CTCFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCFDate"));
			CTCRDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("CTCRDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CTCF=new CTCF(CTCFID,CTCFName,CTCFDate,CTCRDate,CTCPop,CTCFault);
		int rs=CTCFServiceImpl.editCTCF(CTCF,CTCFDate1,CTCRDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllCTCF.doGet(request, response);
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
