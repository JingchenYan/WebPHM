package dao;

import model.YDQ;
import model.PageBean;

import java.util.List;


public interface YDQDao {
	/*
	 * 添加设备
	 */
	int addYDQ(YDQ ydq,String YDQMDate,String YDQIDate);
	/*
	 * 删除设备
	 */
	int deleteYDQ(int YDQID);
	/*
	 * 修改设备
	 */
	int editYDQ(YDQ ydq,String YDQMDate,String YDQIDate);
	/*
	 * 查询所有设备
	 */
	List findAll();
	/*
	 * 查询一个设备
	 */
	List findOne(int YDQID);
	/*
	 * 查询该设备是否存在
	 */
	YDQ selectOneYDQ(YDQ ydq1);
	/*
	 * 分页查询设备
	 */
	PageBean selectYDQ(int pageNo,int pageCount, String YDQName);
	/*
	 * 查询一个设备
	 */
	PageBean YDQListPage(int pageNo,int pageCount);

}
