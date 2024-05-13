package dao;

import model.PageBean;
import model.LSXTF;

import java.util.List;


public interface LSXTFDao {
	/*
	 * 添加故障
	 */
	int addLSXTF(LSXTF lsxtf,String LSXTMDate);
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
	LSXTF selectOneLSXTF(LSXTF lsxtf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectLSXTF(int pageNo,int pageCount, String LSXTFName);
	/*
	 * 查询一个故障
	 */
	PageBean LSXTFListPage(int pageNo,int pageCount);

}
