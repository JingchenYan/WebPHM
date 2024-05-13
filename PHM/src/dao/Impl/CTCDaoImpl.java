package dao.Impl;

import dao.CTCDao;
import db.DBCon;
import model.CTC;
import model.PageBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CTCDaoImpl implements CTCDao {

	private DBCon dbCon = new DBCon();
	private CTC ctc;
	private PageBean pageBean;

	public int addCTC(CTC ctc,String CTCMDate,String CTCIDate) {
		String sql = "insert into CTC(CTC_name,CTC_MDate,CTC_IDate,CTC_health) values('"
				+ ctc.getCTCName() + "', DATE('"
				+ CTCMDate + "'), DATE('"
				+ CTCIDate + "'), '"
				+ ctc.getCTCHealth() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteCTC(int CTCID) {
		String sql = "delete from CTC where CTC_id=" + CTCID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editCTC(CTC ctc,String CTCMDate,String CTCIDate) {
		String sql = "update CTC set CTC_name='" + ctc.getCTCName()
				+ "', CTC_MDate=DATE('" + CTCMDate + "')"
				+ ", CTC_IDate=DATE('" + CTCIDate + "')"
				+ ", CTC_health='" + ctc.getCTCHealth() + "' WHERE CTC_id="
				+ ctc.getCTCID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<CTC> list = new ArrayList<CTC>();
		String sql = "select * from CTC";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCID = rs.getInt("CTC_id");
				String CTCName = rs.getString("CTC_name");
				Date CTCMDate = rs.getDate("CTC_MDate");
				Date CTCIDate = rs.getDate("CTC_IDate");
				String CTCHealth = rs.getString("CTC_health");
				ctc = new CTC(CTCID, CTCName, CTCMDate, CTCIDate, CTCHealth);
				list.add(ctc);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int CTCID) {
		List<CTC> list = new ArrayList<CTC>();
		String sql = "select * from CTC where CTC_id=" + CTCID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int ctcID = rs.getInt("CTC_id");
				String CTCName = rs.getString("CTC_name");
				Date CTCMDate = rs.getDate("CTC_MDate");
				Date CTCIDate = rs.getDate("CTC_IDate");
				String CTCHealth = rs.getString("CTC_health");
				ctc = new CTC(ctcID, CTCName, CTCMDate, CTCIDate, CTCHealth);
				list.add(ctc);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public CTC selectOneCTC(CTC ctc1) {
		String sql = "select * from CTC where CTC_name='"
				+ ctc1.getCTCName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCID = rs.getInt("CTC_id");
				String CTCName = rs.getString("CTC_name");
				Date CTCMDate = rs.getDate("CTC_MDate");
				Date CTCIDate = rs.getDate("CTC_IDate");
				String CTCHealth = rs.getString("CTC_health");
				ctc = new CTC(CTCID, CTCName, CTCMDate, CTCIDate, CTCHealth);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ctc;
	}
	public PageBean selectCTC(int pageNo, int pageCount, String CTCName) {
		int totalCount = 0;
		List<CTC> list = new ArrayList<CTC>();
		String sql = "SELECT * FROM ctc WHERE CTC_name = '" + CTCName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM ctc WHERE CTC_name = '" + CTCName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCID = rs.getInt("CTC_id");
				String actualCTCName = rs.getString("CTC_name");
				Date CTCMDate = rs.getDate("CTC_MDate");
				Date CTCIDate = rs.getDate("CTC_IDate");
				String CTCHealth = rs.getString("CTC_health");
				ctc = new CTC(CTCID, actualCTCName, CTCMDate, CTCIDate, CTCHealth);
				list.add(ctc);
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

	public PageBean CTCListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<CTC> list = new ArrayList<CTC>();
		String sql = "select * from CTC limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from CTC";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int CTCID = rs.getInt("CTC_id");
				String CTCName = rs.getString("CTC_name");
				Date CTCMDate = rs.getDate("CTC_MDate");
				Date CTCIDate = rs.getDate("CTC_IDate");
				String CTCHealth = rs.getString("CTC_health");
				ctc = new CTC(CTCID, CTCName, CTCMDate, CTCIDate, CTCHealth);
				list.add(ctc);
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
