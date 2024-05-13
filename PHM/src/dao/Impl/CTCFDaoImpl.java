package dao.Impl;

import dao.CTCFDao;
import db.DBCon;
import model.PageBean;
import model.CTCF;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CTCFDaoImpl implements CTCFDao {

	private DBCon dbCon = new DBCon();
	private CTCF ctcf;
	private PageBean pageBean;

	public int addCTCF(CTCF ctc,String CTCFDate, String CTCRDate) {
		String sql = "insert into CTCF(CTC_FName,CTC_FDate,CTC_RDate,CTC_Pop,CTC_Fault) values('"
				+ ctc.getCTCFName() + "', DATE('"
				+ CTCFDate + "'), DATE('"
				+ CTCRDate + "'), '"
				+ ctc.getCTCPop() + "', '"
				+ ctc.getCTCFault() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteCTCF(int CTCFID) {
		String sql = "delete from CTCF where CTC_FID=" + CTCFID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editCTCF(CTCF ctcf,String CTCFDate,String CTCRDate) {
		String sql = "update CTCF set CTC_FName='" + ctcf.getCTCFName()
				+ "', CTC_FDate=DATE('" + CTCFDate + "'), CTC_RDate=DATE('" + CTCRDate + "')"
				+ ", CTC_Pop='" + ctcf.getCTCPop() + "', CTC_Fault='" + ctcf.getCTCFault() + "' WHERE CTC_FID="
				+ ctcf.getCTCFID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<CTCF> list = new ArrayList<CTCF>();
		String sql = "select * from CTCF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCFID = rs.getInt("CTC_FID");
				String CTCFName = rs.getString("CTC_FName");
				Date CTCFDate = rs.getDate("CTC_FDate");
				Date CTCRDate = rs.getDate("CTC_RDate");
				String CTCPop = rs.getString("CTC_Pop");
				String CTCFault = rs.getString("CTC_Fault");
				ctcf = new CTCF(CTCFID, CTCFName, CTCFDate, CTCRDate, CTCPop, CTCFault);
				list.add(ctcf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int CTCFID) {
		List<CTCF> list = new ArrayList<CTCF>();
		String sql = "select * from CTCF where CTC_FID=" + CTCFID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int ctcFID = rs.getInt("CTC_FID");
				String CTCFName = rs.getString("CTC_FName");
				Date CTCFDate = rs.getDate("CTC_FDate");
				Date CTCRDate = rs.getDate("CTC_RDate");
				String CTCPop = rs.getString("CTC_Pop");
				String CTCFault = rs.getString("CTC_Fault");
				ctcf = new CTCF(CTCFID, CTCFName, CTCFDate, CTCRDate, CTCPop, CTCFault);
				list.add(ctcf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public CTCF selectOneCTCF(CTCF ctcf1) {
		String sql = "select * from CTCF where CTC_FName='"
				+ ctcf1.getCTCFName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCFID = rs.getInt("CTC_FID");
				String CTCFName = rs.getString("CTC_FName");
				Date CTCFDate = rs.getDate("CTC_FDate");
				Date CTCRDate = rs.getDate("CTC_RDate");
				String CTCPop = rs.getString("CTC_Pop");
				String CTCFault = rs.getString("CTC_Fault");
				ctcf = new CTCF(CTCFID, CTCFName, CTCFDate, CTCRDate, CTCPop, CTCFault);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ctcf;
	}
	public PageBean selectCTCF(int pageNo, int pageCount, String CTCFName) {
		int totalCount = 0;
		List<CTCF> list = new ArrayList<CTCF>();
		String sql = "SELECT * FROM ctcf WHERE CTC_FName = '" + CTCFName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM ctcf WHERE CTC_FName = '" + CTCFName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCFID = rs.getInt("CTC_FID");
				String actualCTCFName = rs.getString("CTC_FName");
				Date CTCFDate = rs.getDate("CTC_FDate");
				Date CTCRDate = rs.getDate("CTC_RDate");
				String CTCPop = rs.getString("CTC_Pop");
				String CTCFault = rs.getString("CTC_Fault");
				ctcf = new CTCF(CTCFID, CTCFName, CTCFDate, CTCRDate, CTCPop, CTCFault);
				list.add(ctcf);
			}
			rs = dbCon.find(sqlCount);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

	public PageBean CTCFListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<CTCF> list = new ArrayList<CTCF>();
		String sql = "select * from CTCF limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from CTCF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCFID = rs.getInt("CTC_FID");
				String CTCFName = rs.getString("CTC_FName");
				Date CTCFDate = rs.getDate("CTC_FDate");
				Date CTCRDate = rs.getDate("CTC_RDate");
				String CTCPop = rs.getString("CTC_Pop");
				String CTCFault = rs.getString("CTC_Fault");
				ctcf = new CTCF(CTCFID, CTCFName, CTCFDate, CTCRDate, CTCPop, CTCFault);
				list.add(ctcf);
			}
			rs=dbCon.find(sqlCount);
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
			pageBean=new PageBean(list,totalCount,pageNo,pageCount);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pageBean;
	}

}
