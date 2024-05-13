package dao;

import model.DC;
import model.PageBean;

import java.util.List;


public interface DCDao {
	/*
	 * 添加设备
	 */
	int addDC(DC dc,String DCMDate,String DCIDate);
	/*
	 * 删除设备
	 */
	int deleteDC(int DCID);
	/*
	 * 修改设备
	 */
	int editDC(DC dc,String DCMDate,String DCIDate);
	/*
	 * 查询所有设备
	 */
	List findAll();
	/*
	 * 查询一个设备
	 */
	List findOne(int DCID);
	/*
	 * 查询该设备是否存在
	 */
	DC selectOneDC(DC dc1);
	/*
	 * 分页查询设备
	 */
	PageBean selectDC(int pageNo,int pageCount, String DCName);
	/*
	 * 查询一个设备
	 */
	PageBean DCListPage(int pageNo,int pageCount);

}
