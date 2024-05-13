package service.Impl;

import dao.Impl.XHJPDaoImpl;
import model.PageBean;
import model.XHJP;
import service.XHJPService;

import java.util.List;

public class XHJPServiceImpl implements XHJPService{
	
	private XHJPDaoImpl XHJPDaoImpl=new XHJPDaoImpl();

	public int deleteXHJP(int XHJPID) {

		int rs = XHJPDaoImpl.deleteXHJP(XHJPID);
		return rs;
	}
	public List findAll() {

		List rs=XHJPDaoImpl.findAll();
		return rs;
	}
	public PageBean selectXHJP(int pageNo, int pageCount, String XHJPName) {

		PageBean rs=XHJPDaoImpl.selectXHJP(pageNo, pageCount, XHJPName);
		return rs;
	}

	public PageBean XHJPListPage(int pageNo, int pageCount) {
		
		PageBean rs=XHJPDaoImpl.XHJPListPage(pageNo, pageCount);
		return rs;
	}

}
