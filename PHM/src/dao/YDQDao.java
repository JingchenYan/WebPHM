package dao;

import model.YDQ;
import model.PageBean;

import java.util.List;


public interface YDQDao {
	/*
	 * ����豸
	 */
	int addYDQ(YDQ ydq,String YDQMDate,String YDQIDate);
	/*
	 * ɾ���豸
	 */
	int deleteYDQ(int YDQID);
	/*
	 * �޸��豸
	 */
	int editYDQ(YDQ ydq,String YDQMDate,String YDQIDate);
	/*
	 * ��ѯ�����豸
	 */
	List findAll();
	/*
	 * ��ѯһ���豸
	 */
	List findOne(int YDQID);
	/*
	 * ��ѯ���豸�Ƿ����
	 */
	YDQ selectOneYDQ(YDQ ydq1);
	/*
	 * ��ҳ��ѯ�豸
	 */
	PageBean selectYDQ(int pageNo,int pageCount, String YDQName);
	/*
	 * ��ѯһ���豸
	 */
	PageBean YDQListPage(int pageNo,int pageCount);

}
