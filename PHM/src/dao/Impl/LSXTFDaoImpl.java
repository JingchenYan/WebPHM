package dao.Impl;

import dao.LSXTFDao;
import db.DBCon;
import model.PageBean;
import model.LSXTF;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LSXTFDaoImpl implements LSXTFDao {

	private DBCon dbCon = new DBCon();
	private LSXTF lsxtf;
	private PageBean pageBean;

	public int addLSXTF(LSXTF lsxt,String LSXTFDate) {
		String sql = "insert into LSXTF(LSXT_FName,LSXT_FDate,LSXT_Fault) values('"
				+ lsxt.getLSXTFName() + "', DATE('"
				+ LSXTFDate + "'), '"
				+ lsxt.getLSXTFault() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteLSXTF(int LSXTFID) {
		String sql = "delete from LSXTF where LSXT_FID=" + LSXTFID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editLSXTF(LSXTF lsxtf,String LSXTFDate) {
		String sql = "update LSXTF set LSXT_FName='" + lsxtf.getLSXTFName()
				+ "', LSXT_FDate=DATE('" + LSXTFDate + "')"
				+ ", LSXT_Fault='" + lsxtf.getLSXTFault() + "' WHERE LSXT_FID="
				+ lsxtf.getLSXTFID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<LSXTF> list = new ArrayList<LSXTF>();
		String sql = "select * from LSXTF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTFID = rs.getInt("LSXT_FID");
				String LSXTFName = rs.getString("LSXT_FName");
				Date LSXTFDate = rs.getDate("LSXT_FDate");
				String LSXTFault = rs.getString("LSXT_Fault");
				lsxtf = new LSXTF(LSXTFID, LSXTFName, LSXTFDate, LSXTFault);
				list.add(lsxtf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int LSXTFID) {
		List<LSXTF> list = new ArrayList<LSXTF>();
		String sql = "select * from LSXTF where LSXT_FID=" + LSXTFID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int lsxtFID = rs.getInt("LSXT_FID");
				String LSXTFName = rs.getString("LSXT_FName");
				Date LSXTFDate = rs.getDate("LSXT_FDate");
				String LSXTFault = rs.getString("LSXT_Fault");
				lsxtf = new LSXTF(lsxtFID, LSXTFName, LSXTFDate,LSXTFault);
				list.add(lsxtf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public LSXTF selectOneLSXTF(LSXTF lsxtf1) {
		String sql = "select * from LSXTF where LSXT_FName='"
				+ lsxtf1.getLSXTFName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTFID = rs.getInt("LSXT_FID");
				String LSXTFName = rs.getString("LSXT_FName");
				Date LSXTFDate = rs.getDate("LSXT_FDate");
				String LSXTFault = rs.getString("LSXT_Fault");
				lsxtf = new LSXTF(LSXTFID, LSXTFName, LSXTFDate, LSXTFault);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lsxtf;
	}
	public PageBean selectLSXTF(int pageNo, int pageCount, String LSXTFName) {
		int totalCount = 0;
		List<LSXTF> list = new ArrayList<LSXTF>();
		String sql = "SELECT * FROM lsxtf WHERE LSXT_FName = '" + LSXTFName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM lsxtf WHERE LSXT_FName = '" + LSXTFName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTFID = rs.getInt("LSXT_FID");
				String actualLSXTFName = rs.getString("LSXT_FName");
				Date LSXTFDate = rs.getDate("LSXT_FDate");
				String LSXTFault = rs.getString("LSXT_Fault");
				lsxtf = new LSXTF(LSXTFID, actualLSXTFName, LSXTFDate, LSXTFault);
				list.add(lsxtf);
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

	public PageBean LSXTFListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<LSXTF> list = new ArrayList<LSXTF>();
		String sql = "select * from LSXTF limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from LSXTF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTFID = rs.getInt("LSXT_FID");
				String LSXTFName = rs.getString("LSXT_FName");
				Date LSXTFDate = rs.getDate("LSXT_FDate");
				String LSXTFault = rs.getString("LSXT_Fault");
				lsxtf = new LSXTF(LSXTFID, LSXTFName, LSXTFDate,LSXTFault);
				list.add(lsxtf);
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
