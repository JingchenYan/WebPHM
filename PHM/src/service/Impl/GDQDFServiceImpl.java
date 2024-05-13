package service.Impl;

import dao.Impl.GDQDFDaoImpl;
import model.PageBean;
import model.GDQDF;
import service.GDQDFService;

import java.util.List;

public class GDQDFServiceImpl implements GDQDFService{
	
	private GDQDFDaoImpl GDQDFDaoImpl=new GDQDFDaoImpl();

	public int addGDQDF(GDQDF gdqdf, String GDQDFDate) {

		int rs=GDQDFDaoImpl.addGDQDF(gdqdf,GDQDFDate);
		return rs;
	}

	public int deleteGDQDF(int GDQDFID) {
		
		int rs = GDQDFDaoImpl.deleteGDQDF(GDQDFID);
		return rs;
	}

	public int editGDQDF(GDQDF gdqdf, String GDQDFDate) {
		
		int rs=GDQDFDaoImpl.editGDQDF(gdqdf,GDQDFDate);
		return rs;
	}

	public List findAll() {
		
		List rs=GDQDFDaoImpl.findAll();
		return rs;
	}

	public List findOne(int GDQDFID) {
		
		List rs=GDQDFDaoImpl.findOne(GDQDFID);
		return rs;
	}

	public GDQDF selectOneGDQD(GDQDF gdqdf1) {
		
		GDQDF rs=GDQDFDaoImpl.selectOneGDQDF(gdqdf1);
		return rs;
	}
	public PageBean selectGDQDF(int pageNo, int pageCount, String GDQDFName) {

		PageBean rs=GDQDFDaoImpl.selectGDQDF(pageNo, pageCount, GDQDFName);
		return rs;
	}

	public PageBean GDQDFListPage(int pageNo, int pageCount) {
		
		PageBean rs=GDQDFDaoImpl.GDQDFListPage(pageNo, pageCount);
		return rs;
	}

}
