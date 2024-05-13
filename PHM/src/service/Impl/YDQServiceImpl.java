package service.Impl;

import dao.Impl.YDQDaoImpl;
import model.YDQ;
import model.PageBean;
import service.YDQService;

import java.util.List;

public class YDQServiceImpl implements YDQService{
	
	private YDQDaoImpl YDQDaoImpl=new YDQDaoImpl();

	public int addYDQ(YDQ ydq, String YDQMDate, String YDQIDate) {

		int rs=YDQDaoImpl.addYDQ(ydq,YDQMDate,YDQIDate);
		return rs;
	}

	public int deleteYDQ(int YDQID) {
		
		int rs = YDQDaoImpl.deleteYDQ(YDQID);
		return rs;
	}

	public int editYDQ(YDQ ydq, String YDQMDate, String YDQIDate) {
		
		int rs=YDQDaoImpl.editYDQ(ydq,YDQMDate,YDQIDate);
		return rs;
	}

	public List findAll() {
		
		List rs=YDQDaoImpl.findAll();
		return rs;
	}

	public List findOne(int YDQID) {
		
		List rs=YDQDaoImpl.findOne(YDQID);
		return rs;
	}

	public YDQ selectOneYDQ(YDQ ydq1) {
		
		YDQ rs=YDQDaoImpl.selectOneYDQ(ydq1);
		return rs;
	}
	public PageBean selectYDQ(int pageNo, int pageCount, String YDQName) {

		PageBean rs=YDQDaoImpl.selectYDQ(pageNo, pageCount, YDQName);
		return rs;
	}

	public PageBean YDQListPage(int pageNo, int pageCount) {
		
		PageBean rs=YDQDaoImpl.YDQListPage(pageNo, pageCount);
		return rs;
	}

}
