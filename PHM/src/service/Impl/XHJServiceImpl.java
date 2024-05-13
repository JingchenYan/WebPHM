package service.Impl;

import dao.Impl.XHJDaoImpl;
import model.XHJ;
import model.PageBean;
import service.XHJService;

import java.util.List;

public class XHJServiceImpl implements XHJService{
	
	private XHJDaoImpl XHJDaoImpl=new XHJDaoImpl();

	public int addXHJ(XHJ xhj, String XHJMDate, String XHJIDate) {

		int rs=XHJDaoImpl.addXHJ(xhj,XHJMDate,XHJIDate);
		return rs;
	}

	public int deleteXHJ(int XHJID) {
		
		int rs = XHJDaoImpl.deleteXHJ(XHJID);
		return rs;
	}

	public int editXHJ(XHJ xhj, String XHJMDate, String XHJIDate) {
		
		int rs=XHJDaoImpl.editXHJ(xhj,XHJMDate,XHJIDate);
		return rs;
	}

	public List findAll() {
		
		List rs=XHJDaoImpl.findAll();
		return rs;
	}

	public List findOne(int XHJID) {
		
		List rs=XHJDaoImpl.findOne(XHJID);
		return rs;
	}

	public XHJ selectOneXHJ(XHJ xhj1) {
		
		XHJ rs=XHJDaoImpl.selectOneXHJ(xhj1);
		return rs;
	}
	public PageBean selectXHJ(int pageNo, int pageCount, String XHJName) {

		PageBean rs=XHJDaoImpl.selectXHJ(pageNo, pageCount, XHJName);
		return rs;
	}

	public PageBean XHJListPage(int pageNo, int pageCount) {
		
		PageBean rs=XHJDaoImpl.XHJListPage(pageNo, pageCount);
		return rs;
	}

}
