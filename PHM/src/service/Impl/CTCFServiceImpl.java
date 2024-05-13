package service.Impl;

import dao.Impl.CTCFDaoImpl;
import model.PageBean;
import model.CTCF;
import service.CTCFService;

import java.util.List;

public class CTCFServiceImpl implements CTCFService{
	
	private CTCFDaoImpl CTCFDaoImpl=new CTCFDaoImpl();

	public int addCTCF(CTCF ctcf, String CTCFDate, String CTCRDate) {

		int rs=CTCFDaoImpl.addCTCF(ctcf,CTCFDate,CTCRDate);
		return rs;
	}

	public int deleteCTCF(int CTCFID) {
		
		int rs = CTCFDaoImpl.deleteCTCF(CTCFID);
		return rs;
	}

	public int editCTCF(CTCF ctcf, String CTCFDate, String CTCRDate) {
		
		int rs=CTCFDaoImpl.editCTCF(ctcf,CTCFDate,CTCRDate);
		return rs;
	}

	public List findAll() {
		
		List rs=CTCFDaoImpl.findAll();
		return rs;
	}

	public List findOne(int CTCFID) {
		
		List rs=CTCFDaoImpl.findOne(CTCFID);
		return rs;
	}

	public CTCF selectOneCTC(CTCF ctcf1) {
		
		CTCF rs=CTCFDaoImpl.selectOneCTCF(ctcf1);
		return rs;
	}
	public PageBean selectCTCF(int pageNo, int pageCount, String CTCFName) {

		PageBean rs=CTCFDaoImpl.selectCTCF(pageNo, pageCount, CTCFName);
		return rs;
	}

	public PageBean CTCFListPage(int pageNo, int pageCount) {
		
		PageBean rs=CTCFDaoImpl.CTCFListPage(pageNo, pageCount);
		return rs;
	}

}
