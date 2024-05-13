package dao;

import model.LSXT;
import model.PageBean;

import java.util.List;


public interface LSXTDao {
	/*
	 * 添加设备
	 */
	int addLSXT(LSXT lsxt,String LSXTMDate,String LSXTIDate);
	/*
	 * 删除设备
	 */
	int deleteLSXT(int LSXTID);
	/*
	 * 修改设备
	 */
	int editLSXT(LSXT lsxt,String LSXTMDate,String LSXTIDate);
	/*
	 * 查询所有设备
	 */
	List findAll();
	/*
	 * 查询一个设备
	 */
	List findOne(int LSXTID);
	/*
	 * 查询该设备是否存在
	 */
	LSXT selectOneLSXT(LSXT lsxt1);
	/*
	 * 分页查询设备
	 */
	PageBean selectLSXT(int pageNo,int pageCount, String LSXTName);
	/*
	 * 查询一个设备
	 */
	PageBean LSXTListPage(int pageNo,int pageCount);

}
