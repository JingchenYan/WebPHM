package service.Impl;

import dao.Impl.GDQDDaoImpl;
import model.GDQD;
import model.PageBean;
import service.GDQDService;

import java.util.List;

public class GDQDServiceImpl implements GDQDService{
	
	private GDQDDaoImpl GDQDDaoImpl=new GDQDDaoImpl();

	public int addGDQD(GDQD gdqd, String GDQDMDate, String GDQDIDate) {

		int rs=GDQDDaoImpl.addGDQD(gdqd,GDQDMDate,GDQDIDate);
		return rs;
	}

	public int deleteGDQD(int GDQDID) {
		
		int rs = GDQDDaoImpl.deleteGDQD(GDQDID);
		return rs;
	}

	public int editGDQD(GDQD gdqd, String GDQDMDate, String GDQDIDate) {
		
		int rs=GDQDDaoImpl.editGDQD(gdqd,GDQDMDate,GDQDIDate);
		return rs;
	}

	public List findAll() {
		
		List rs=GDQDDaoImpl.findAll();
		return rs;
	}

	public List findOne(int GDQDID) {
		
		List rs=GDQDDaoImpl.findOne(GDQDID);
		return rs;
	}

	public GDQD selectOneGDQD(GDQD gdqd1) {
		
		GDQD rs=GDQDDaoImpl.selectOneGDQD(gdqd1);
		return rs;
	}
	public PageBean selectGDQD(int pageNo, int pageCount, String GDQDName) {

		PageBean rs=GDQDDaoImpl.selectGDQD(pageNo, pageCount, GDQDName);
		return rs;
	}

	public PageBean GDQDListPage(int pageNo, int pageCount) {
		
		PageBean rs=GDQDDaoImpl.GDQDListPage(pageNo, pageCount);
		return rs;
	}

}
