package dao;

import model.PageBean;
import model.XHJF;

import java.util.List;


public interface XHJFDao {
	/*
	 * ��ӹ���
	 */
	int addXHJF(XHJF xhjf,String XHJMDate,String XHJRDate);
	/*
	 * ɾ������
	 */
	int deleteXHJF(int XHJFID);
	/*
	 * �޸Ĺ���
	 */
	int editXHJF(XHJF xhjf,String XHJFDate,String XHJRDate);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ѯһ������
	 */
	List findOne(int XHJFID);
	/*
	 * ��ѯ�ù����Ƿ����
	 */
	XHJF selectOneXHJF(XHJF xhjf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectXHJF(int pageNo,int pageCount, String XHJFName);
	/*
	 * ��ѯһ������
	 */
	PageBean XHJFListPage(int pageNo,int pageCount);

}
