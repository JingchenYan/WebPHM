package service;

import model.PageBean;
import model.GDQDF;

import java.util.List;

public interface GDQDFService {
	/*
	 * ��ӹ���
	 */
	int addGDQDF(GDQDF gdqdf,String GDQDFDate);
	/*
	 * ɾ������
	 */
	int deleteGDQDF(int GDQDFID);
	/*
	 * �޸Ĺ���
	 */
	int editGDQDF(GDQDF gdqdf,String GDQDFDate);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ѯһ������
	 */
	List findOne(int GDQDFID);
	/*
	 * ��ѯ�ù����Ƿ����
	 */
	GDQDF selectOneGDQD(GDQDF gdqdf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectGDQDF(int pageNo,int pageCount, String GDQDFName);
	/*
	 * ��ѯһ������
	 */
	PageBean GDQDFListPage(int pageNo,int pageCount);


}
