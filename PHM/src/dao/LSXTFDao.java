package dao;

import model.PageBean;
import model.LSXTF;

import java.util.List;


public interface LSXTFDao {
	/*
	 * ��ӹ���
	 */
	int addLSXTF(LSXTF lsxtf,String LSXTMDate);
	/*
	 * ɾ������
	 */
	int deleteLSXTF(int LSXTFID);
	/*
	 * �޸Ĺ���
	 */
	int editLSXTF(LSXTF lsxtf,String LSXTFDate);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ѯһ������
	 */
	List findOne(int LSXTFID);
	/*
	 * ��ѯ�ù����Ƿ����
	 */
	LSXTF selectOneLSXTF(LSXTF lsxtf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectLSXTF(int pageNo,int pageCount, String LSXTFName);
	/*
	 * ��ѯһ������
	 */
	PageBean LSXTFListPage(int pageNo,int pageCount);

}
