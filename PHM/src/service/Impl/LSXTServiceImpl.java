package service.Impl;

import dao.Impl.LSXTDaoImpl;
import model.LSXT;
import model.PageBean;
import service.LSXTService;

import java.util.List;

public class LSXTServiceImpl implements LSXTService{
	
	private LSXTDaoImpl LSXTDaoImpl=new LSXTDaoImpl();

	public int addLSXT(LSXT lsxt, String LSXTMDate, String LSXTIDate) {

		int rs=LSXTDaoImpl.addLSXT(lsxt,LSXTMDate,LSXTIDate);
		return rs;
	}

	public int deleteLSXT(int LSXTID) {
		
		int rs = LSXTDaoImpl.deleteLSXT(LSXTID);
		return rs;
	}

	public int editLSXT(LSXT lsxt, String LSXTMDate, String LSXTIDate) {
		
		int rs=LSXTDaoImpl.editLSXT(lsxt,LSXTMDate,LSXTIDate);
		return rs;
	}

	public List findAll() {
		
		List rs=LSXTDaoImpl.findAll();
		return rs;
	}

	public List findOne(int LSXTID) {
		
		List rs=LSXTDaoImpl.findOne(LSXTID);
		return rs;
	}

	public LSXT selectOneLSXT(LSXT lsxt1) {
		
		LSXT rs=LSXTDaoImpl.selectOneLSXT(lsxt1);
		return rs;
	}
	public PageBean selectLSXT(int pageNo, int pageCount, String LSXTName) {

		PageBean rs=LSXTDaoImpl.selectLSXT(pageNo, pageCount, LSXTName);
		return rs;
	}

	public PageBean LSXTListPage(int pageNo, int pageCount) {
		
		PageBean rs=LSXTDaoImpl.LSXTListPage(pageNo, pageCount);
		return rs;
	}

}
