package dao;

import model.CTC;
import model.PageBean;

import java.util.List;


public interface CTCDao {
	/*
	 * ����豸
	 */
	int addCTC(CTC ctc,String CTCMDate,String CTCIDate);
	/*
	 * ɾ���豸
	 */
	int deleteCTC(int CTCID);
	/*
	 * �޸��豸
	 */
	int editCTC(CTC ctc,String CTCMDate,String CTCIDate);
	/*
	 * ��ѯ�����豸
	 */
	List findAll();
	/*
	 * ��ѯһ���豸
	 */
	List findOne(int CTCID);
	/*
	 * ��ѯ���豸�Ƿ����
	 */
	CTC selectOneCTC(CTC ctc1);
	/*
	 * ��ҳ��ѯ�豸
	 */
	PageBean selectCTC(int pageNo,int pageCount, String CTCName);
	/*
	 * ��ѯһ���豸
	 */
	PageBean CTCListPage(int pageNo,int pageCount);

}
