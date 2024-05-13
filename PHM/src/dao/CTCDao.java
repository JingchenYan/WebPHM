package dao;

import model.CTC;
import model.PageBean;

import java.util.List;


public interface CTCDao {
	/*
	 * 添加设备
	 */
	int addCTC(CTC ctc,String CTCMDate,String CTCIDate);
	/*
	 * 删除设备
	 */
	int deleteCTC(int CTCID);
	/*
	 * 修改设备
	 */
	int editCTC(CTC ctc,String CTCMDate,String CTCIDate);
	/*
	 * 查询所有设备
	 */
	List findAll();
	/*
	 * 查询一个设备
	 */
	List findOne(int CTCID);
	/*
	 * 查询该设备是否存在
	 */
	CTC selectOneCTC(CTC ctc1);
	/*
	 * 分页查询设备
	 */
	PageBean selectCTC(int pageNo,int pageCount, String CTCName);
	/*
	 * 查询一个设备
	 */
	PageBean CTCListPage(int pageNo,int pageCount);

}
