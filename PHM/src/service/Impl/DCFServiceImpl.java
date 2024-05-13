package service.Impl;

import dao.Impl.DCFDaoImpl;
import model.PageBean;
import model.DCF;
import service.DCFService;

import java.util.List;

public class DCFServiceImpl implements DCFService{
	
	private DCFDaoImpl DCFDaoImpl=new DCFDaoImpl();

	public int addDCF(DCF dcf, String DCFDate) {

		int rs=DCFDaoImpl.addDCF(dcf,DCFDate);
		return rs;
	}

	public int deleteDCF(int DCFID) {
		
		int rs = DCFDaoImpl.deleteDCF(DCFID);
		return rs;
	}

	public int editDCF(DCF dcf, String DCFDate) {
		
		int rs=DCFDaoImpl.editDCF(dcf,DCFDate);
		return rs;
	}

	public List findAll() {
		
		List rs=DCFDaoImpl.findAll();
		return rs;
	}

	public List findOne(int DCFID) {
		
		List rs=DCFDaoImpl.findOne(DCFID);
		return rs;
	}

	public DCF selectOneDC(DCF dcf1) {
		
		DCF rs=DCFDaoImpl.selectOneDCF(dcf1);
		return rs;
	}
	public PageBean selectDCF(int pageNo, int pageCount, String DCFName) {

		PageBean rs=DCFDaoImpl.selectDCF(pageNo, pageCount, DCFName);
		return rs;
	}

	public PageBean DCFListPage(int pageNo, int pageCount) {
		
		PageBean rs=DCFDaoImpl.DCFListPage(pageNo, pageCount);
		return rs;
	}

}
