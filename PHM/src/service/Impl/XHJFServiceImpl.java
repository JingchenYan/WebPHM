package service.Impl;

import dao.Impl.XHJFDaoImpl;
import model.PageBean;
import model.XHJF;
import service.XHJFService;

import java.util.List;

public class XHJFServiceImpl implements XHJFService{
	
	private XHJFDaoImpl XHJFDaoImpl=new XHJFDaoImpl();

	public int addXHJF(XHJF xhjf, String XHJFDate, String XHJRDate) {

		int rs=XHJFDaoImpl.addXHJF(xhjf,XHJFDate,XHJRDate);
		return rs;
	}

	public int deleteXHJF(int XHJFID) {
		
		int rs = XHJFDaoImpl.deleteXHJF(XHJFID);
		return rs;
	}

	public int editXHJF(XHJF xhjf, String XHJFDate, String XHJRDate) {
		
		int rs=XHJFDaoImpl.editXHJF(xhjf,XHJFDate,XHJRDate);
		return rs;
	}

	public List findAll() {
		
		List rs=XHJFDaoImpl.findAll();
		return rs;
	}

	public List findOne(int XHJFID) {
		
		List rs=XHJFDaoImpl.findOne(XHJFID);
		return rs;
	}

	public XHJF selectOneXHJ(XHJF xhjf1) {
		
		XHJF rs=XHJFDaoImpl.selectOneXHJF(xhjf1);
		return rs;
	}
	public PageBean selectXHJF(int pageNo, int pageCount, String XHJFName) {

		PageBean rs=XHJFDaoImpl.selectXHJF(pageNo, pageCount, XHJFName);
		return rs;
	}

	public PageBean XHJFListPage(int pageNo, int pageCount) {
		
		PageBean rs=XHJFDaoImpl.XHJFListPage(pageNo, pageCount);
		return rs;
	}

}
