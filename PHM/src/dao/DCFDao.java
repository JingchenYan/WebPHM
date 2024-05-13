package dao;

import model.PageBean;
import model.DCF;

import java.util.List;


public interface DCFDao {
	/*
	 * ��ӹ���
	 */
	int addDCF(DCF dcf,String DCFDate);
	/*
	 * ɾ������
	 */
	int deleteDCF(int DCFID);
	/*
	 * �޸Ĺ���
	 */
	int editDCF(DCF dcf,String DCFDate);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ѯһ������
	 */
	List findOne(int DCFID);
	/*
	 * ��ѯ�ù����Ƿ����
	 */
	DCF selectOneDCF(DCF dcf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectDCF(int pageNo,int pageCount, String DCFName);
	/*
	 * ��ѯһ������
	 */
	PageBean DCFListPage(int pageNo,int pageCount);

}
