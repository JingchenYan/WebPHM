package service;

import model.PageBean;
import model.LSXTF;

import java.util.List;

public interface LSXTFService {
	/*
	 * 添加故障
	 */
	int addLSXTF(LSXTF lsxtf,String LSXTFDate);
	/*
	 * 删除故障
	 */
	int deleteLSXTF(int LSXTFID);
	/*
	 * 修改故障
	 */
	int editLSXTF(LSXTF lsxtf,String LSXTFDate);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 查询一个故障
	 */
	List findOne(int LSXTFID);
	/*
	 * 查询该故障是否存在
	 */
	LSXTF selectOneLSXT(LSXTF lsxtf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectLSXTF(int pageNo,int pageCount, String LSXTFName);
	/*
	 * 查询一个故障
	 */
	PageBean LSXTFListPage(int pageNo,int pageCount);


}
