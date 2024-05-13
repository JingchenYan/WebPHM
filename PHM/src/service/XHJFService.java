package service;

import model.PageBean;
import model.XHJF;

import java.util.List;

public interface XHJFService {
	/*
	 * ��ӹ���
	 */
	int addXHJF(XHJF xhjf,String XHJFDate,String XHJRDate);
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
	XHJF selectOneXHJ(XHJF xhjf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectXHJF(int pageNo,int pageCount, String XHJFName);
	/*
	 * ��ѯһ������
	 */
	PageBean XHJFListPage(int pageNo,int pageCount);


}
