package dao.Impl;

import dao.GDQDDao;
import db.DBCon;
import model.GDQD;
import model.PageBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GDQDDaoImpl implements GDQDDao {

	private DBCon dbCon = new DBCon();
	private GDQD gdqd;
	private PageBean pageBean;

	public int addGDQD(GDQD gdqd,String GDQDMDate,String GDQDIDate) {
		String sql = "insert into GDQD(GDQD_name,GDQD_MDate,GDQD_IDate,GDQD_health) values('"
				+ gdqd.getGDQDName() + "', DATE('"
				+ GDQDMDate + "'), DATE('"
				+ GDQDIDate + "'), '"
				+ gdqd.getGDQDHealth() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteGDQD(int GDQDID) {
		String sql = "delete from GDQD where GDQD_id=" + GDQDID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editGDQD(GDQD gdqd,String GDQDMDate,String GDQDIDate) {
		String sql = "update GDQD set GDQD_name='" + gdqd.getGDQDName()
				+ "', GDQD_MDate=DATE('" + GDQDMDate + "')"
				+ ", GDQD_IDate=DATE('" + GDQDIDate + "')"
				+ ", GDQD_health='" + gdqd.getGDQDHealth() + "' WHERE GDQD_id="
				+ gdqd.getGDQDID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<GDQD> list = new ArrayList<GDQD>();
		String sql = "select * from GDQD";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDID = rs.getInt("GDQD_id");
				String GDQDName = rs.getString("GDQD_name");
				Date GDQDMDate = rs.getDate("GDQD_MDate");
				Date GDQDIDate = rs.getDate("GDQD_IDate");
				String GDQDHealth = rs.getString("GDQD_health");
				gdqd = new GDQD(GDQDID, GDQDName, GDQDMDate, GDQDIDate, GDQDHealth);
				list.add(gdqd);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int GDQDID) {
		List<GDQD> list = new ArrayList<GDQD>();
		String sql = "select * from GDQD where GDQD_id=" + GDQDID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int gdqdID = rs.getInt("GDQD_id");
				String GDQDName = rs.getString("GDQD_name");
				Date GDQDMDate = rs.getDate("GDQD_MDate");
				Date GDQDIDate = rs.getDate("GDQD_IDate");
				String GDQDHealth = rs.getString("GDQD_health");
				gdqd = new GDQD(gdqdID, GDQDName, GDQDMDate, GDQDIDate, GDQDHealth);
				list.add(gdqd);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public GDQD selectOneGDQD(GDQD gdqd1) {
		String sql = "select * from GDQD where GDQD_name='"
				+ gdqd1.getGDQDName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDID = rs.getInt("GDQD_id");
				String GDQDName = rs.getString("GDQD_name");
				Date GDQDMDate = rs.getDate("GDQD_MDate");
				Date GDQDIDate = rs.getDate("GDQD_IDate");
				String GDQDHealth = rs.getString("GDQD_health");
				gdqd = new GDQD(GDQDID, GDQDName, GDQDMDate, GDQDIDate, GDQDHealth);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return gdqd;
	}
	public PageBean selectGDQD(int pageNo, int pageCount, String GDQDName) {
		int totalCount = 0;
		List<GDQD> list = new ArrayList<GDQD>();
		String sql = "SELECT * FROM gdqd WHERE GDQD_name = '" + GDQDName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM gdqd WHERE GDQD_name = '" + GDQDName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDID = rs.getInt("GDQD_id");
				String actualGDQDName = rs.getString("GDQD_name");
				Date GDQDMDate = rs.getDate("GDQD_MDate");
				Date GDQDIDate = rs.getDate("GDQD_IDate");
				String GDQDHealth = rs.getString("GDQD_health");
				gdqd = new GDQD(GDQDID, actualGDQDName, GDQDMDate, GDQDIDate, GDQDHealth);
				list.add(gdqd);
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

	public PageBean GDQDListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<GDQD> list = new ArrayList<GDQD>();
		String sql = "select * from GDQD limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from GDQD";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int GDQDID = rs.getInt("GDQD_id");
				String GDQDName = rs.getString("GDQD_name");
				Date GDQDMDate = rs.getDate("GDQD_MDate");
				Date GDQDIDate = rs.getDate("GDQD_IDate");
				String GDQDHealth = rs.getString("GDQD_health");
				gdqd = new GDQD(GDQDID, GDQDName, GDQDMDate, GDQDIDate, GDQDHealth);
				list.add(gdqd);
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
