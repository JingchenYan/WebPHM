package service;

import model.PageBean;
import model.LSXTF;

import java.util.List;

public interface LSXTFService {
	/*
	 * ��ӹ���
	 */
	int addLSXTF(LSXTF lsxtf,String LSXTFDate);
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
	LSXTF selectOneLSXT(LSXTF lsxtf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectLSXTF(int pageNo,int pageCount, String LSXTFName);
	/*
	 * ��ѯһ������
	 */
	PageBean LSXTFListPage(int pageNo,int pageCount);


}
