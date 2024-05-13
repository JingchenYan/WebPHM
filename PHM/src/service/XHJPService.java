package service;

import model.PageBean;
import model.XHJP;

import java.util.List;

public interface XHJPService {
	/*
	 * 删除故障
	 */
	int deleteXHJP(int XHJPID);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 分页查询故障
	 */
	PageBean selectXHJP(int pageNo,int pageCount, String XHJPName);
	/*
	 * 查询一个故障
	 */
	PageBean XHJPListPage(int pageNo,int pageCount);


}
