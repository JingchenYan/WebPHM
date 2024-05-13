package service;

import model.PageBean;
import model.CTCF;

import java.util.List;

public interface CTCFService {
	/*
	 * 添加故障
	 */
	int addCTCF(CTCF ctcf,String CTCFDate,String CTCRDate);
	/*
	 * 删除故障
	 */
	int deleteCTCF(int CTCFID);
	/*
	 * 修改故障
	 */
	int editCTCF(CTCF ctcf,String CTCFDate,String CTCRDate);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 查询一个故障
	 */
	List findOne(int CTCFID);
	/*
	 * 查询该故障是否存在
	 */
	CTCF selectOneCTC(CTCF ctcf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectCTCF(int pageNo,int pageCount, String CTCFName);
	/*
	 * 查询一个故障
	 */
	PageBean CTCFListPage(int pageNo,int pageCount);


}
