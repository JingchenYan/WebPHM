package dao;

import model.PageBean;
import model.DCF;

import java.util.List;


public interface DCFDao {
	/*
	 * 添加故障
	 */
	int addDCF(DCF dcf,String DCFDate);
	/*
	 * 删除故障
	 */
	int deleteDCF(int DCFID);
	/*
	 * 修改故障
	 */
	int editDCF(DCF dcf,String DCFDate);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 查询一个故障
	 */
	List findOne(int DCFID);
	/*
	 * 查询该故障是否存在
	 */
	DCF selectOneDCF(DCF dcf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectDCF(int pageNo,int pageCount, String DCFName);
	/*
	 * 查询一个故障
	 */
	PageBean DCFListPage(int pageNo,int pageCount);

}
