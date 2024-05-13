package service.Impl;

import dao.Impl.YDQFDaoImpl;
import model.PageBean;
import model.YDQF;
import service.YDQFService;

import java.util.List;

public class YDQFServiceImpl implements YDQFService{
	
	private YDQFDaoImpl YDQFDaoImpl=new YDQFDaoImpl();

	public int addYDQF(YDQF ydqf, String YDQFDate) {

		int rs=YDQFDaoImpl.addYDQF(ydqf,YDQFDate);
		return rs;
	}

	public int deleteYDQF(int YDQFID) {
		
		int rs = YDQFDaoImpl.deleteYDQF(YDQFID);
		return rs;
	}

	public int editYDQF(YDQF ydqf, String YDQFDate) {
		
		int rs=YDQFDaoImpl.editYDQF(ydqf,YDQFDate);
		return rs;
	}

	public List findAll() {
		
		List rs=YDQFDaoImpl.findAll();
		return rs;
	}

	public List findOne(int YDQFID) {
		
		List rs=YDQFDaoImpl.findOne(YDQFID);
		return rs;
	}

	public YDQF selectOneYDQ(YDQF ydqf1) {
		
		YDQF rs=YDQFDaoImpl.selectOneYDQF(ydqf1);
		return rs;
	}
	public PageBean selectYDQF(int pageNo, int pageCount, String YDQFName) {

		PageBean rs=YDQFDaoImpl.selectYDQF(pageNo, pageCount, YDQFName);
		return rs;
	}

	public PageBean YDQFListPage(int pageNo, int pageCount) {
		
		PageBean rs=YDQFDaoImpl.YDQFListPage(pageNo, pageCount);
		return rs;
	}

}
