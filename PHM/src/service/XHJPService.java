package service;

import model.PageBean;
import model.XHJP;

import java.util.List;

public interface XHJPService {
	/*
	 * ɾ������
	 */
	int deleteXHJP(int XHJPID);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectXHJP(int pageNo,int pageCount, String XHJPName);
	/*
	 * ��ѯһ������
	 */
	PageBean XHJPListPage(int pageNo,int pageCount);


}
