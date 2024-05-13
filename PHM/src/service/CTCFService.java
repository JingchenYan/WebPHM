package service;

import model.PageBean;
import model.CTCF;

import java.util.List;

public interface CTCFService {
	/*
	 * ��ӹ���
	 */
	int addCTCF(CTCF ctcf,String CTCFDate,String CTCRDate);
	/*
	 * ɾ������
	 */
	int deleteCTCF(int CTCFID);
	/*
	 * �޸Ĺ���
	 */
	int editCTCF(CTCF ctcf,String CTCFDate,String CTCRDate);
	/*
	 * ��ѯ���й���
	 */
	List findAll();
	/*
	 * ��ѯһ������
	 */
	List findOne(int CTCFID);
	/*
	 * ��ѯ�ù����Ƿ����
	 */
	CTCF selectOneCTC(CTCF ctcf1);
	/*
	 * ��ҳ��ѯ����
	 */
	PageBean selectCTCF(int pageNo,int pageCount, String CTCFName);
	/*
	 * ��ѯһ������
	 */
	PageBean CTCFListPage(int pageNo,int pageCount);


}
