package dao.Impl;

import dao.YDQDao;
import db.DBCon;
import model.YDQ;
import model.PageBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YDQDaoImpl implements YDQDao {

	private DBCon dbCon = new DBCon();
	private YDQ ydq;
	private PageBean pageBean;

	public int addYDQ(YDQ ydq,String YDQMDate,String YDQIDate) {
		String sql = "insert into YDQ(YDQ_name,YDQ_MDate,YDQ_IDate,YDQ_health) values('"
				+ ydq.getYDQName() + "', DATE('"
				+ YDQMDate + "'), DATE('"
				+ YDQIDate + "'), '"
				+ ydq.getYDQHealth() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteYDQ(int YDQID) {
		String sql = "delete from YDQ where YDQ_id=" + YDQID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editYDQ(YDQ ydq,String YDQMDate,String YDQIDate) {
		String sql = "update YDQ set YDQ_name='" + ydq.getYDQName()
				+ "', YDQ_MDate=DATE('" + YDQMDate + "')"
				+ ", YDQ_IDate=DATE('" + YDQIDate + "')"
				+ ", YDQ_health='" + ydq.getYDQHealth() + "' WHERE YDQ_id="
				+ ydq.getYDQID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<YDQ> list = new ArrayList<YDQ>();
		String sql = "select * from YDQ";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQID = rs.getInt("YDQ_id");
				String YDQName = rs.getString("YDQ_name");
				Date YDQMDate = rs.getDate("YDQ_MDate");
				Date YDQIDate = rs.getDate("YDQ_IDate");
				String YDQHealth = rs.getString("YDQ_health");
				ydq = new YDQ(YDQID, YDQName, YDQMDate, YDQIDate, YDQHealth);
				list.add(ydq);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int YDQID) {
		List<YDQ> list = new ArrayList<YDQ>();
		String sql = "select * from YDQ where YDQ_id=" + YDQID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int ydqID = rs.getInt("YDQ_id");
				String YDQName = rs.getString("YDQ_name");
				Date YDQMDate = rs.getDate("YDQ_MDate");
				Date YDQIDate = rs.getDate("YDQ_IDate");
				String YDQHealth = rs.getString("YDQ_health");
				ydq = new YDQ(ydqID, YDQName, YDQMDate, YDQIDate, YDQHealth);
				list.add(ydq);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public YDQ selectOneYDQ(YDQ ydq1) {
		String sql = "select * from YDQ where YDQ_name='"
				+ ydq1.getYDQName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQID = rs.getInt("YDQ_id");
				String YDQName = rs.getString("YDQ_name");
				Date YDQMDate = rs.getDate("YDQ_MDate");
				Date YDQIDate = rs.getDate("YDQ_IDate");
				String YDQHealth = rs.getString("YDQ_health");
				ydq = new YDQ(YDQID, YDQName, YDQMDate, YDQIDate, YDQHealth);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ydq;
	}
	public PageBean selectYDQ(int pageNo, int pageCount, String YDQName) {
		int totalCount = 0;
		List<YDQ> list = new ArrayList<YDQ>();
		String sql = "SELECT * FROM ydq WHERE YDQ_name = '" + YDQName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM ydq WHERE YDQ_name = '" + YDQName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQID = rs.getInt("YDQ_id");
				String actualYDQName = rs.getString("YDQ_name");
				Date YDQMDate = rs.getDate("YDQ_MDate");
				Date YDQIDate = rs.getDate("YDQ_IDate");
				String YDQHealth = rs.getString("YDQ_health");
				ydq = new YDQ(YDQID, actualYDQName, YDQMDate, YDQIDate, YDQHealth);
				list.add(ydq);
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

	public PageBean YDQListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<YDQ> list = new ArrayList<YDQ>();
		String sql = "select * from YDQ limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from YDQ";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int YDQID = rs.getInt("YDQ_id");
				String YDQName = rs.getString("YDQ_name");
				Date YDQMDate = rs.getDate("YDQ_MDate");
				Date YDQIDate = rs.getDate("YDQ_IDate");
				String YDQHealth = rs.getString("YDQ_health");
				ydq = new YDQ(YDQID, YDQName, YDQMDate, YDQIDate, YDQHealth);
				list.add(ydq);
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
