package dao;

import model.LSXT;
import model.PageBean;

import java.util.List;


public interface LSXTDao {
	/*
	 * ����豸
	 */
	int addLSXT(LSXT lsxt,String LSXTMDate,String LSXTIDate);
	/*
	 * ɾ���豸
	 */
	int deleteLSXT(int LSXTID);
	/*
	 * �޸��豸
	 */
	int editLSXT(LSXT lsxt,String LSXTMDate,String LSXTIDate);
	/*
	 * ��ѯ�����豸
	 */
	List findAll();
	/*
	 * ��ѯһ���豸
	 */
	List findOne(int LSXTID);
	/*
	 * ��ѯ���豸�Ƿ����
	 */
	LSXT selectOneLSXT(LSXT lsxt1);
	/*
	 * ��ҳ��ѯ�豸
	 */
	PageBean selectLSXT(int pageNo,int pageCount, String LSXTName);
	/*
	 * ��ѯһ���豸
	 */
	PageBean LSXTListPage(int pageNo,int pageCount);

}
