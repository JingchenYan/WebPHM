package dao;

import model.PageBean;
import model.XHJF;

import java.util.List;


public interface XHJFDao {
	/*
	 * 添加故障
	 */
	int addXHJF(XHJF xhjf,String XHJMDate,String XHJRDate);
	/*
	 * 删除故障
	 */
	int deleteXHJF(int XHJFID);
	/*
	 * 修改故障
	 */
	int editXHJF(XHJF xhjf,String XHJFDate,String XHJRDate);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 查询一个故障
	 */
	List findOne(int XHJFID);
	/*
	 * 查询该故障是否存在
	 */
	XHJF selectOneXHJF(XHJF xhjf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectXHJF(int pageNo,int pageCount, String XHJFName);
	/*
	 * 查询一个故障
	 */
	PageBean XHJFListPage(int pageNo,int pageCount);

}
