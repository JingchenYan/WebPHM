package service;

import model.PageBean;
import model.GDQDF;

import java.util.List;

public interface GDQDFService {
	/*
	 * 添加故障
	 */
	int addGDQDF(GDQDF gdqdf,String GDQDFDate);
	/*
	 * 删除故障
	 */
	int deleteGDQDF(int GDQDFID);
	/*
	 * 修改故障
	 */
	int editGDQDF(GDQDF gdqdf,String GDQDFDate);
	/*
	 * 查询所有故障
	 */
	List findAll();
	/*
	 * 查询一个故障
	 */
	List findOne(int GDQDFID);
	/*
	 * 查询该故障是否存在
	 */
	GDQDF selectOneGDQD(GDQDF gdqdf1);
	/*
	 * 分页查询故障
	 */
	PageBean selectGDQDF(int pageNo,int pageCount, String GDQDFName);
	/*
	 * 查询一个故障
	 */
	PageBean GDQDFListPage(int pageNo,int pageCount);


}
