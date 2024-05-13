package dao.Impl;

import dao.GDQDFDao;
import db.DBCon;
import model.PageBean;
import model.GDQDF;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GDQDFDaoImpl implements GDQDFDao {

	private DBCon dbCon = new DBCon();
	private GDQDF gdqdf;
	private PageBean pageBean;

	public int addGDQDF(GDQDF gdqd,String GDQDFDate) {
		String sql = "insert into GDQDF(GDQD_FName,GDQD_FDate,GDQD_Fault) values('"
				+ gdqd.getGDQDFName() + "', DATE('"
				+ GDQDFDate + "'), '"
				+ gdqd.getGDQDFault() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteGDQDF(int GDQDFID) {
		String sql = "delete from GDQDF where GDQD_FID=" + GDQDFID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editGDQDF(GDQDF gdqdf,String GDQDFDate) {
		String sql = "update GDQDF set GDQD_FName='" + gdqdf.getGDQDFName()
				+ "', GDQD_FDate=DATE('" + GDQDFDate + "')"
				+ ", GDQD_Fault='" + gdqdf.getGDQDFault() + "' WHERE GDQD_FID="
				+ gdqdf.getGDQDFID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<GDQDF> list = new ArrayList<GDQDF>();
		String sql = "select * from GDQDF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDFID = rs.getInt("GDQD_FID");
				String GDQDFName = rs.getString("GDQD_FName");
				Date GDQDFDate = rs.getDate("GDQD_FDate");
				String GDQDFault = rs.getString("GDQD_Fault");
				gdqdf = new GDQDF(GDQDFID, GDQDFName, GDQDFDate, GDQDFault);
				list.add(gdqdf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int GDQDFID) {
		List<GDQDF> list = new ArrayList<GDQDF>();
		String sql = "select * from GDQDF where GDQD_FID=" + GDQDFID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int gdqdFID = rs.getInt("GDQD_FID");
				String GDQDFName = rs.getString("GDQD_FName");
				Date GDQDFDate = rs.getDate("GDQD_FDate");
				String GDQDFault = rs.getString("GDQD_Fault");
				gdqdf = new GDQDF(gdqdFID, GDQDFName, GDQDFDate,GDQDFault);
				list.add(gdqdf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public GDQDF selectOneGDQDF(GDQDF gdqdf1) {
		String sql = "select * from GDQDF where GDQD_FName='"
				+ gdqdf1.getGDQDFName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDFID = rs.getInt("GDQD_FID");
				String GDQDFName = rs.getString("GDQD_FName");
				Date GDQDFDate = rs.getDate("GDQD_FDate");
				String GDQDFault = rs.getString("GDQD_Fault");
				gdqdf = new GDQDF(GDQDFID, GDQDFName, GDQDFDate, GDQDFault);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return gdqdf;
	}
	public PageBean selectGDQDF(int pageNo, int pageCount, String GDQDFName) {
		int totalCount = 0;
		List<GDQDF> list = new ArrayList<GDQDF>();
		String sql = "SELECT * FROM gdqdf WHERE GDQD_FName = '" + GDQDFName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM gdqdf WHERE GDQD_FName = '" + GDQDFName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDFID = rs.getInt("GDQD_FID");
				String actualGDQDFName = rs.getString("GDQD_FName");
				Date GDQDFDate = rs.getDate("GDQD_FDate");
				String GDQDFault = rs.getString("GDQD_Fault");
				gdqdf = new GDQDF(GDQDFID, actualGDQDFName, GDQDFDate, GDQDFault);
				list.add(gdqdf);
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

	public PageBean GDQDFListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<GDQDF> list = new ArrayList<GDQDF>();
		String sql = "select * from GDQDF limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from GDQDF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDFID = rs.getInt("GDQD_FID");
				String GDQDFName = rs.getString("GDQD_FName");
				Date GDQDFDate = rs.getDate("GDQD_FDate");
				String GDQDFault = rs.getString("GDQD_Fault");
				gdqdf = new GDQDF(GDQDFID, GDQDFName, GDQDFDate,GDQDFault);
				list.add(gdqdf);
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
