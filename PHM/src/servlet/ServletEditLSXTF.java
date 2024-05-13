package servlet;

import model.LSXTF;
import service.Impl.LSXTFServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletEditLSXTF extends HttpServlet{

	private LSXTF LSXTF;
	private ServletFindAllLSXTF servletFindAllLSXTF=new ServletFindAllLSXTF();
	private ServletSelectLSXTF selectOne=new ServletSelectLSXTF();
	private LSXTFServiceImpl LSXTFServiceImpl=new LSXTFServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int LSXTFID=Integer.parseInt(request.getParameter("LSXTFID"));
		String LSXTFName = request.getParameter("LSXTFName");
		String LSXTFault = request.getParameter("LSXTFault");
		String LSXTFDate1 = request.getParameter("LSXTFDate");
		Date LSXTFDate=null;
		try {
			LSXTFDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("LSXTFDate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		LSXTF=new LSXTF(LSXTFID,LSXTFName,LSXTFDate,LSXTFault);
		int rs=LSXTFServiceImpl.editLSXTF(LSXTF,LSXTFDate1);
		if(rs>0){
			request.setAttribute("msg", " ޸ĳɹ     ");
			servletFindAllLSXTF.doGet(request, response);
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
