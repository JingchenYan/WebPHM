package dao.Impl;

import dao.YDQFDao;
import db.DBCon;
import model.PageBean;
import model.YDQF;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YDQFDaoImpl implements YDQFDao {

	private DBCon dbCon = new DBCon();
	private YDQF ydqf;
	private PageBean pageBean;

	public int addYDQF(YDQF ydq,String YDQFDate) {
		String sql = "insert into YDQF(YDQ_FName,YDQ_FDate,YDQ_Fault) values('"
				+ ydq.getYDQFName() + "', DATE('"
				+ YDQFDate + "'), '"
				+ ydq.getYDQFault() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteYDQF(int YDQFID) {
		String sql = "delete from YDQF where YDQ_FID=" + YDQFID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editYDQF(YDQF ydqf,String YDQFDate) {
		String sql = "update YDQF set YDQ_FName='" + ydqf.getYDQFName()
				+ "', YDQ_FDate=DATE('" + YDQFDate + "')"
				+ ", YDQ_Fault='" + ydqf.getYDQFault() + "' WHERE YDQ_FID="
				+ ydqf.getYDQFID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<YDQF> list = new ArrayList<YDQF>();
		String sql = "select * from YDQF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQFID = rs.getInt("YDQ_FID");
				String YDQFName = rs.getString("YDQ_FName");
				Date YDQFDate = rs.getDate("YDQ_FDate");
				String YDQFault = rs.getString("YDQ_Fault");
				ydqf = new YDQF(YDQFID, YDQFName, YDQFDate, YDQFault);
				list.add(ydqf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int YDQFID) {
		List<YDQF> list = new ArrayList<YDQF>();
		String sql = "select * from YDQF where YDQ_FID=" + YDQFID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int ydqFID = rs.getInt("YDQ_FID");
				String YDQFName = rs.getString("YDQ_FName");
				Date YDQFDate = rs.getDate("YDQ_FDate");
				String YDQFault = rs.getString("YDQ_Fault");
				ydqf = new YDQF(ydqFID, YDQFName, YDQFDate,YDQFault);
				list.add(ydqf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public YDQF selectOneYDQF(YDQF ydqf1) {
		String sql = "select * from YDQF where YDQ_FName='"
				+ ydqf1.getYDQFName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQFID = rs.getInt("YDQ_FID");
				String YDQFName = rs.getString("YDQ_FName");
				Date YDQFDate = rs.getDate("YDQ_FDate");
				String YDQFault = rs.getString("YDQ_Fault");
				ydqf = new YDQF(YDQFID, YDQFName, YDQFDate, YDQFault);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ydqf;
	}
	public PageBean selectYDQF(int pageNo, int pageCount, String YDQFName) {
		int totalCount = 0;
		List<YDQF> list = new ArrayList<YDQF>();
		String sql = "SELECT * FROM ydqf WHERE YDQ_FName = '" + YDQFName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM ydqf WHERE YDQ_FName = '" + YDQFName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQFID = rs.getInt("YDQ_FID");
				String actualYDQFName = rs.getString("YDQ_FName");
				Date YDQFDate = rs.getDate("YDQ_FDate");
				String YDQFault = rs.getString("YDQ_Fault");
				ydqf = new YDQF(YDQFID, actualYDQFName, YDQFDate, YDQFault);
				list.add(ydqf);
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

	public PageBean YDQFListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<YDQF> list = new ArrayList<YDQF>();
		String sql = "select * from YDQF limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from YDQF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQFID = rs.getInt("YDQ_FID");
				String YDQFName = rs.getString("YDQ_FName");
				Date YDQFDate = rs.getDate("YDQ_FDate");
				String YDQFault = rs.getString("YDQ_Fault");
				ydqf = new YDQF(YDQFID, YDQFName, YDQFDate,YDQFault);
				list.add(ydqf);
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
