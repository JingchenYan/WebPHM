package dao;

import model.DC;
import model.PageBean;

import java.util.List;


public interface DCDao {
	/*
	 * ����豸
	 */
	int addDC(DC dc,String DCMDate,String DCIDate);
	/*
	 * ɾ���豸
	 */
	int deleteDC(int DCID);
	/*
	 * �޸��豸
	 */
	int editDC(DC dc,String DCMDate,String DCIDate);
	/*
	 * ��ѯ�����豸
	 */
	List findAll();
	/*
	 * ��ѯһ���豸
	 */
	List findOne(int DCID);
	/*
	 * ��ѯ���豸�Ƿ����
	 */
	DC selectOneDC(DC dc1);
	/*
	 * ��ҳ��ѯ�豸
	 */
	PageBean selectDC(int pageNo,int pageCount, String DCName);
	/*
	 * ��ѯһ���豸
	 */
	PageBean DCListPage(int pageNo,int pageCount);

}
