package dao;

import model.PageBean;
import model.YDQF;

import java.util.List;


public interface YDQFDao {
	/*
	 * 添加故障
	 */
	int addYDQF(YDQF ydqf,String YDQMDate);
	/*
	 * 删除故障
	 */
	int deleteYDQF(int YDQFID);
	/*
	 * 修改故障
	 */
	int editYDQF(YDQF ydqf,String YDQFDate);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 查询一个故障
	 */
	List findOne(int YDQFID);
	/*
	 * 查询该故障是否存在
	 */
	YDQF selectOneYDQF(YDQF ydqf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectYDQF(int pageNo,int pageCount, String YDQFName);
	/*
	 * 查询一个故障
	 */
	PageBean YDQFListPage(int pageNo,int pageCount);

}
