package dao;

import model.PageBean;
import model.YDQF;

import java.util.List;


public interface YDQFDao {
	/*
	 * ��ӹ���
	 */
	int addYDQF(YDQF ydqf,String YDQMDate);
	/*
	 * ɾ������
	 */
	int deleteYDQF(int YDQFID);
	/*
	 * �޸Ĺ���
	 */
	int editYDQF(YDQF ydqf,String YDQFDate);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ѯһ������
	 */
	List findOne(int YDQFID);
	/*
	 * ��ѯ�ù����Ƿ����
	 */
	YDQF selectOneYDQF(YDQF ydqf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectYDQF(int pageNo,int pageCount, String YDQFName);
	/*
	 * ��ѯһ������
	 */
	PageBean YDQFListPage(int pageNo,int pageCount);

}
