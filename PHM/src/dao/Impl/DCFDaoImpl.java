package dao.Impl;

import dao.DCFDao;
import db.DBCon;
import model.PageBean;
import model.DCF;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DCFDaoImpl implements DCFDao {

	private DBCon dbCon = new DBCon();
	private DCF dcf;
	private PageBean pageBean;

	public int addDCF(DCF dc,String DCFDate) {
		String sql = "insert into DCF(DC_FName,DC_FDate,DC_Fault) values('"
				+ dc.getDCFName() + "', DATE('"
				+ DCFDate + "'), '"
				+ dc.getDCFault() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteDCF(int DCFID) {
		String sql = "delete from DCF where DC_FID=" + DCFID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editDCF(DCF dcf,String DCFDate) {
		String sql = "update DCF set DC_FName='" + dcf.getDCFName()
				+ "', DC_FDate=DATE('" + DCFDate + "')"
				+ ", DC_Fault='" + dcf.getDCFault() + "' WHERE DC_FID="
				+ dcf.getDCFID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<DCF> list = new ArrayList<DCF>();
		String sql = "select * from DCF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCFID = rs.getInt("DC_FID");
				String DCFName = rs.getString("DC_FName");
				Date DCFDate = rs.getDate("DC_FDate");
				String DCFault = rs.getString("DC_Fault");
				dcf = new DCF(DCFID, DCFName, DCFDate, DCFault);
				list.add(dcf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int DCFID) {
		List<DCF> list = new ArrayList<DCF>();
		String sql = "select * from DCF where DC_FID=" + DCFID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int dcFID = rs.getInt("DC_FID");
				String DCFName = rs.getString("DC_FName");
				Date DCFDate = rs.getDate("DC_FDate");
				String DCFault = rs.getString("DC_Fault");
				dcf = new DCF(dcFID, DCFName, DCFDate,DCFault);
				list.add(dcf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public DCF selectOneDCF(DCF dcf1) {
		String sql = "select * from DCF where DC_FName='"
				+ dcf1.getDCFName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCFID = rs.getInt("DC_FID");
				String DCFName = rs.getString("DC_FName");
				Date DCFDate = rs.getDate("DC_FDate");
				String DCFault = rs.getString("DC_Fault");
				dcf = new DCF(DCFID, DCFName, DCFDate, DCFault);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dcf;
	}
	public PageBean selectDCF(int pageNo, int pageCount, String DCFName) {
		int totalCount = 0;
		List<DCF> list = new ArrayList<DCF>();
		String sql = "SELECT * FROM dcf WHERE DC_FName = '" + DCFName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM dcf WHERE DC_FName = '" + DCFName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCFID = rs.getInt("DC_FID");
				String actualDCFName = rs.getString("DC_FName");
				Date DCFDate = rs.getDate("DC_FDate");
				String DCFault = rs.getString("DC_Fault");
				dcf = new DCF(DCFID, actualDCFName, DCFDate, DCFault);
				list.add(dcf);
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

	public PageBean DCFListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<DCF> list = new ArrayList<DCF>();
		String sql = "select * from DCF limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from DCF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCFID = rs.getInt("DC_FID");
				String DCFName = rs.getString("DC_FName");
				Date DCFDate = rs.getDate("DC_FDate");
				String DCFault = rs.getString("DC_Fault");
				dcf = new DCF(DCFID, DCFName, DCFDate,DCFault);
				list.add(dcf);
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
