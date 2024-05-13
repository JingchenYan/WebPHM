package service;

import model.XHJ;
import model.PageBean;

import java.util.List;

public interface XHJService {
	/*
	 * ����豸
	 */
	int addXHJ(XHJ xhj,String XHJMDate,String XHJIDate);
	/*
	 * ɾ���豸
	 */
	int deleteXHJ(int XHJID);
	/*
	 * �޸��豸
	 */
	int editXHJ(XHJ xhj,String XHJMDate,String XHJIDate);
	/*
	 * ��ѯ�����豸
	 */
	List findAll();
	/*
	 * ��ѯһ���豸
	 */
	List findOne(int XHJID);
	/*
	 * ��ѯ���豸�Ƿ����
	 */
	XHJ selectOneXHJ(XHJ xhj1);
	/*
	 * ��ҳ��ѯ�豸
	 */
	PageBean selectXHJ(int pageNo,int pageCount, String XHJName);
	/*
	 * ��ѯһ���豸
	 */
	PageBean XHJListPage(int pageNo,int pageCount);


}
