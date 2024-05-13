package dao.Impl;

import dao.LSXTDao;
import db.DBCon;
import model.LSXT;
import model.PageBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LSXTDaoImpl implements LSXTDao {

	private DBCon dbCon = new DBCon();
	private LSXT lsxt;
	private PageBean pageBean;

	public int addLSXT(LSXT lsxt,String LSXTMDate,String LSXTIDate) {
		String sql = "insert into LSXT(LSXT_name,LSXT_MDate,LSXT_IDate,LSXT_health) values('"
				+ lsxt.getLSXTName() + "', DATE('"
				+ LSXTMDate + "'), DATE('"
				+ LSXTIDate + "'), '"
				+ lsxt.getLSXTHealth() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteLSXT(int LSXTID) {
		String sql = "delete from LSXT where LSXT_id=" + LSXTID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editLSXT(LSXT lsxt,String LSXTMDate,String LSXTIDate) {
		String sql = "update LSXT set LSXT_name='" + lsxt.getLSXTName()
				+ "', LSXT_MDate=DATE('" + LSXTMDate + "')"
				+ ", LSXT_IDate=DATE('" + LSXTIDate + "')"
				+ ", LSXT_health='" + lsxt.getLSXTHealth() + "' WHERE LSXT_id="
				+ lsxt.getLSXTID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<LSXT> list = new ArrayList<LSXT>();
		String sql = "select * from LSXT";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTID = rs.getInt("LSXT_id");
				String LSXTName = rs.getString("LSXT_name");
				Date LSXTMDate = rs.getDate("LSXT_MDate");
				Date LSXTIDate = rs.getDate("LSXT_IDate");
				String LSXTHealth = rs.getString("LSXT_health");
				lsxt = new LSXT(LSXTID, LSXTName, LSXTMDate, LSXTIDate, LSXTHealth);
				list.add(lsxt);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int LSXTID) {
		List<LSXT> list = new ArrayList<LSXT>();
		String sql = "select * from LSXT where LSXT_id=" + LSXTID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int lsxtID = rs.getInt("LSXT_id");
				String LSXTName = rs.getString("LSXT_name");
				Date LSXTMDate = rs.getDate("LSXT_MDate");
				Date LSXTIDate = rs.getDate("LSXT_IDate");
				String LSXTHealth = rs.getString("LSXT_health");
				lsxt = new LSXT(lsxtID, LSXTName, LSXTMDate, LSXTIDate, LSXTHealth);
				list.add(lsxt);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public LSXT selectOneLSXT(LSXT lsxt1) {
		String sql = "select * from LSXT where LSXT_name='"
				+ lsxt1.getLSXTName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTID = rs.getInt("LSXT_id");
				String LSXTName = rs.getString("LSXT_name");
				Date LSXTMDate = rs.getDate("LSXT_MDate");
				Date LSXTIDate = rs.getDate("LSXT_IDate");
				String LSXTHealth = rs.getString("LSXT_health");
				lsxt = new LSXT(LSXTID, LSXTName, LSXTMDate, LSXTIDate, LSXTHealth);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lsxt;
	}
	public PageBean selectLSXT(int pageNo, int pageCount, String LSXTName) {
		int totalCount = 0;
		List<LSXT> list = new ArrayList<LSXT>();
		String sql = "SELECT * FROM lsxt WHERE LSXT_name = '" + LSXTName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM lsxt WHERE LSXT_name = '" + LSXTName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTID = rs.getInt("LSXT_id");
				String actualLSXTName = rs.getString("LSXT_name");
				Date LSXTMDate = rs.getDate("LSXT_MDate");
				Date LSXTIDate = rs.getDate("LSXT_IDate");
				String LSXTHealth = rs.getString("LSXT_health");
				lsxt = new LSXT(LSXTID, actualLSXTName, LSXTMDate, LSXTIDate, LSXTHealth);
				list.add(lsxt);
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

	public PageBean LSXTListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<LSXT> list = new ArrayList<LSXT>();
		String sql = "select * from LSXT limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from LSXT";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int LSXTID = rs.getInt("LSXT_id");
				String LSXTName = rs.getString("LSXT_name");
				Date LSXTMDate = rs.getDate("LSXT_MDate");
				Date LSXTIDate = rs.getDate("LSXT_IDate");
				String LSXTHealth = rs.getString("LSXT_health");
				lsxt = new LSXT(LSXTID, LSXTName, LSXTMDate, LSXTIDate, LSXTHealth);
				list.add(lsxt);
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
