package dao;

import model.GDQD;
import model.PageBean;

import java.util.List;


public interface GDQDDao {
	/*
	 * ����豸
	 */
	int addGDQD(GDQD gdqd,String GDQDMDate,String GDQDIDate);
	/*
	 * ɾ���豸
	 */
	int deleteGDQD(int GDQDID);
	/*
	 * �޸��豸
	 */
	int editGDQD(GDQD gdqd,String GDQDMDate,String GDQDIDate);
	/*
	 * ��ѯ�����豸
	 */
	List findAll();
	/*
	 * ��ѯһ���豸
	 */
	List findOne(int GDQDID);
	/*
	 * ��ѯ���豸�Ƿ����
	 */
	GDQD selectOneGDQD(GDQD gdqd1);
	/*
	 * ��ҳ��ѯ�豸
	 */
	PageBean selectGDQD(int pageNo,int pageCount, String GDQDName);
	/*
	 * ��ѯһ���豸
	 */
	PageBean GDQDListPage(int pageNo,int pageCount);

}
