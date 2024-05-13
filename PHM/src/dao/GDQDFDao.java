package dao;

import model.PageBean;
import model.GDQDF;

import java.util.List;


public interface GDQDFDao {
	/*
	 * ��ӹ���
	 */
	int addGDQDF(GDQDF gdqdf,String GDQDMDate);
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
	GDQDF selectOneGDQDF(GDQDF gdqdf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectGDQDF(int pageNo,int pageCount, String GDQDFName);
	/*
	 * ��ѯһ������
	 */
	PageBean GDQDFListPage(int pageNo,int pageCount);

}
