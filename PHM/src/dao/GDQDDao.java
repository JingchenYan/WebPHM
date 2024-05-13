package dao;

import model.GDQD;
import model.PageBean;

import java.util.List;


public interface GDQDDao {
	/*
	 * 添加设备
	 */
	int addGDQD(GDQD gdqd,String GDQDMDate,String GDQDIDate);
	/*
	 * 删除设备
	 */
	int deleteGDQD(int GDQDID);
	/*
	 * 修改设备
	 */
	int editGDQD(GDQD gdqd,String GDQDMDate,String GDQDIDate);
	/*
	 * 查询所有设备
	 */
	List findAll();
	/*
	 * 查询一个设备
	 */
	List findOne(int GDQDID);
	/*
	 * 查询该设备是否存在
	 */
	GDQD selectOneGDQD(GDQD gdqd1);
	/*
	 * 分页查询设备
	 */
	PageBean selectGDQD(int pageNo,int pageCount, String GDQDName);
	/*
	 * 查询一个设备
	 */
	PageBean GDQDListPage(int pageNo,int pageCount);

}
