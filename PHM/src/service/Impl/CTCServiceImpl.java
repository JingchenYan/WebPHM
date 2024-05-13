package service.Impl;

import dao.Impl.CTCDaoImpl;
import model.CTC;
import model.PageBean;
import service.CTCService;

import java.util.List;

public class CTCServiceImpl implements CTCService{
	
	private CTCDaoImpl CTCDaoImpl=new CTCDaoImpl();

	public int addCTC(CTC ctc, String CTCMDate, String CTCIDate) {

		int rs=CTCDaoImpl.addCTC(ctc,CTCMDate,CTCIDate);
		return rs;
	}

	public int deleteCTC(int CTCID) {
		
		int rs = CTCDaoImpl.deleteCTC(CTCID);
		return rs;
	}

	public int editCTC(CTC ctc, String CTCMDate, String CTCIDate) {
		
		int rs=CTCDaoImpl.editCTC(ctc,CTCMDate,CTCIDate);
		return rs;
	}

	public List findAll() {
		
		List rs=CTCDaoImpl.findAll();
		return rs;
	}

	public List findOne(int CTCID) {
		
		List rs=CTCDaoImpl.findOne(CTCID);
		return rs;
	}

	public CTC selectOneCTC(CTC ctc1) {
		
		CTC rs=CTCDaoImpl.selectOneCTC(ctc1);
		return rs;
	}
	public PageBean selectCTC(int pageNo, int pageCount, String CTCName) {

		PageBean rs=CTCDaoImpl.selectCTC(pageNo, pageCount, CTCName);
		return rs;
	}

	public PageBean CTCListPage(int pageNo, int pageCount) {
		
		PageBean rs=CTCDaoImpl.CTCListPage(pageNo, pageCount);
		return rs;
	}

}
