package dao.Impl;

import dao.DCDao;
import db.DBCon;
import model.DC;
import model.PageBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DCDaoImpl implements DCDao {

	private DBCon dbCon = new DBCon();
	private DC dc;
	private PageBean pageBean;

	public int addDC(DC dc,String DCMDate,String DCIDate) {
		String sql = "insert into DC(DC_name,DC_MDate,DC_IDate,DC_health) values('"
				+ dc.getDCName() + "', DATE('"
				+ DCMDate + "'), DATE('"
				+ DCIDate + "'), '"
				+ dc.getDCHealth() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteDC(int DCID) {
		String sql = "delete from DC where DC_id=" + DCID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editDC(DC dc,String DCMDate,String DCIDate) {
		String sql = "update DC set DC_name='" + dc.getDCName()
				+ "', DC_MDate=DATE('" + DCMDate + "')"
				+ ", DC_IDate=DATE('" + DCIDate + "')"
				+ ", DC_health='" + dc.getDCHealth() + "' WHERE DC_id="
				+ dc.getDCID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<DC> list = new ArrayList<DC>();
		String sql = "select * from DC";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCID = rs.getInt("DC_id");
				String DCName = rs.getString("DC_name");
				Date DCMDate = rs.getDate("DC_MDate");
				Date DCIDate = rs.getDate("DC_IDate");
				String DCHealth = rs.getString("DC_health");
				dc = new DC(DCID, DCName, DCMDate, DCIDate, DCHealth);
				list.add(dc);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int DCID) {
		List<DC> list = new ArrayList<DC>();
		String sql = "select * from DC where DC_id=" + DCID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int dcID = rs.getInt("DC_id");
				String DCName = rs.getString("DC_name");
				Date DCMDate = rs.getDate("DC_MDate");
				Date DCIDate = rs.getDate("DC_IDate");
				String DCHealth = rs.getString("DC_health");
				dc = new DC(dcID, DCName, DCMDate, DCIDate, DCHealth);
				list.add(dc);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public DC selectOneDC(DC dc1) {
		String sql = "select * from DC where DC_name='"
				+ dc1.getDCName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCID = rs.getInt("DC_id");
				String DCName = rs.getString("DC_name");
				Date DCMDate = rs.getDate("DC_MDate");
				Date DCIDate = rs.getDate("DC_IDate");
				String DCHealth = rs.getString("DC_health");
				dc = new DC(DCID, DCName, DCMDate, DCIDate, DCHealth);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dc;
	}
	public PageBean selectDC(int pageNo, int pageCount, String DCName) {
		int totalCount = 0;
		List<DC> list = new ArrayList<DC>();
		String sql = "SELECT * FROM dc WHERE DC_name = '" + DCName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM dc WHERE DC_name = '" + DCName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCID = rs.getInt("DC_id");
				String actualDCName = rs.getString("DC_name");
				Date DCMDate = rs.getDate("DC_MDate");
				Date DCIDate = rs.getDate("DC_IDate");
				String DCHealth = rs.getString("DC_health");
				dc = new DC(DCID, actualDCName, DCMDate, DCIDate, DCHealth);
				list.add(dc);
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

	public PageBean DCListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<DC> list = new ArrayList<DC>();
		String sql = "select * from DC limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from DC";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int DCID = rs.getInt("DC_id");
				String DCName = rs.getString("DC_name");
				Date DCMDate = rs.getDate("DC_MDate");
				Date DCIDate = rs.getDate("DC_IDate");
				String DCHealth = rs.getString("DC_health");
				dc = new DC(DCID, DCName, DCMDate, DCIDate, DCHealth);
				list.add(dc);
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
