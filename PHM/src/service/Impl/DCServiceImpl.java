package service.Impl;

import dao.Impl.DCDaoImpl;
import model.DC;
import model.PageBean;
import service.DCService;

import java.util.List;

public class DCServiceImpl implements DCService{
	
	private DCDaoImpl DCDaoImpl=new DCDaoImpl();

	public int addDC(DC dc, String DCMDate, String DCIDate) {

		int rs=DCDaoImpl.addDC(dc,DCMDate,DCIDate);
		return rs;
	}

	public int deleteDC(int DCID) {
		
		int rs = DCDaoImpl.deleteDC(DCID);
		return rs;
	}

	public int editDC(DC dc, String DCMDate, String DCIDate) {
		
		int rs=DCDaoImpl.editDC(dc,DCMDate,DCIDate);
		return rs;
	}

	public List findAll() {
		
		List rs=DCDaoImpl.findAll();
		return rs;
	}

	public List findOne(int DCID) {
		
		List rs=DCDaoImpl.findOne(DCID);
		return rs;
	}

	public DC selectOneDC(DC dc1) {
		
		DC rs=DCDaoImpl.selectOneDC(dc1);
		return rs;
	}
	public PageBean selectDC(int pageNo, int pageCount, String DCName) {

		PageBean rs=DCDaoImpl.selectDC(pageNo, pageCount, DCName);
		return rs;
	}

	public PageBean DCListPage(int pageNo, int pageCount) {
		
		PageBean rs=DCDaoImpl.DCListPage(pageNo, pageCount);
		return rs;
	}

}
