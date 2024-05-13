package service;

import model.XHJ;
import model.PageBean;

import java.util.List;

public interface XHJService {
	/*
	 * 添加设备
	 */
	int addXHJ(XHJ xhj,String XHJMDate,String XHJIDate);
	/*
	 * 删除设备
	 */
	int deleteXHJ(int XHJID);
	/*
	 * 修改设备
	 */
	int editXHJ(XHJ xhj,String XHJMDate,String XHJIDate);
	/*
	 * 查询所有设备
	 */
	List findAll();
	/*
	 * 查询一个设备
	 */
	List findOne(int XHJID);
	/*
	 * 查询该设备是否存在
	 */
	XHJ selectOneXHJ(XHJ xhj1);
	/*
	 * 分页查询设备
	 */
	PageBean selectXHJ(int pageNo,int pageCount, String XHJName);
	/*
	 * 查询一个设备
	 */
	PageBean XHJListPage(int pageNo,int pageCount);


}
