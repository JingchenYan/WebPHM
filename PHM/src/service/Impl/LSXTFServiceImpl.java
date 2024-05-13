package service.Impl;

import dao.Impl.LSXTFDaoImpl;
import model.PageBean;
import model.LSXTF;
import service.LSXTFService;

import java.util.List;

public class LSXTFServiceImpl implements LSXTFService{
	
	private LSXTFDaoImpl LSXTFDaoImpl=new LSXTFDaoImpl();

	public int addLSXTF(LSXTF lsxtf, String LSXTFDate) {

		int rs=LSXTFDaoImpl.addLSXTF(lsxtf,LSXTFDate);
		return rs;
	}

	public int deleteLSXTF(int LSXTFID) {
		
		int rs = LSXTFDaoImpl.deleteLSXTF(LSXTFID);
		return rs;
	}

	public int editLSXTF(LSXTF lsxtf, String LSXTFDate) {
		
		int rs=LSXTFDaoImpl.editLSXTF(lsxtf,LSXTFDate);
		return rs;
	}

	public List findAll() {
		
		List rs=LSXTFDaoImpl.findAll();
		return rs;
	}

	public List findOne(int LSXTFID) {
		
		List rs=LSXTFDaoImpl.findOne(LSXTFID);
		return rs;
	}

	public LSXTF selectOneLSXT(LSXTF lsxtf1) {
		
		LSXTF rs=LSXTFDaoImpl.selectOneLSXTF(lsxtf1);
		return rs;
	}
	public PageBean selectLSXTF(int pageNo, int pageCount, String LSXTFName) {

		PageBean rs=LSXTFDaoImpl.selectLSXTF(pageNo, pageCount, LSXTFName);
		return rs;
	}

	public PageBean LSXTFListPage(int pageNo, int pageCount) {
		
		PageBean rs=LSXTFDaoImpl.LSXTFListPage(pageNo, pageCount);
		return rs;
	}

}
