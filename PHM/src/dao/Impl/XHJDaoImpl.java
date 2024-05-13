package dao.Impl;

import dao.XHJDao;
import db.DBCon;
import model.XHJ;
import model.PageBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XHJDaoImpl implements XHJDao {

	private DBCon dbCon = new DBCon();
	private XHJ xhj;
	private PageBean pageBean;

	public int addXHJ(XHJ xhj,String XHJMDate,String XHJIDate) {
		String sql = "insert into XHJ(XHJ_name,XHJ_MDate,XHJ_IDate,XHJ_health) values('"
				+ xhj.getXHJName() + "', DATE('"
				+ XHJMDate + "'), DATE('"
				+ XHJIDate + "'), '"
				+ xhj.getXHJHealth() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteXHJ(int XHJID) {
		String sql = "delete from XHJ where XHJ_id=" + XHJID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editXHJ(XHJ xhj,String XHJMDate,String XHJIDate) {
		String sql = "update XHJ set XHJ_name='" + xhj.getXHJName()
				+ "', XHJ_MDate=DATE('" + XHJMDate + "')"
				+ ", XHJ_IDate=DATE('" + XHJIDate + "')"
				+ ", XHJ_health='" + xhj.getXHJHealth() + "' WHERE XHJ_id="
				+ xhj.getXHJID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<XHJ> list = new ArrayList<XHJ>();
		String sql = "select * from XHJ";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJID = rs.getInt("XHJ_id");
				String XHJName = rs.getString("XHJ_name");
				Date XHJMDate = rs.getDate("XHJ_MDate");
				Date XHJIDate = rs.getDate("XHJ_IDate");
				String XHJHealth = rs.getString("XHJ_health");
				xhj = new XHJ(XHJID, XHJName, XHJMDate, XHJIDate, XHJHealth);
				list.add(xhj);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int XHJID) {
		List<XHJ> list = new ArrayList<XHJ>();
		String sql = "select * from XHJ where XHJ_id=" + XHJID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int xhjID = rs.getInt("XHJ_id");
				String XHJName = rs.getString("XHJ_name");
				Date XHJMDate = rs.getDate("XHJ_MDate");
				Date XHJIDate = rs.getDate("XHJ_IDate");
				String XHJHealth = rs.getString("XHJ_health");
				xhj = new XHJ(xhjID, XHJName, XHJMDate, XHJIDate, XHJHealth);
				list.add(xhj);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public XHJ selectOneXHJ(XHJ xhj1) {
		String sql = "select * from XHJ where XHJ_name='"
				+ xhj1.getXHJName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJID = rs.getInt("XHJ_id");
				String XHJName = rs.getString("XHJ_name");
				Date XHJMDate = rs.getDate("XHJ_MDate");
				Date XHJIDate = rs.getDate("XHJ_IDate");
				String XHJHealth = rs.getString("XHJ_health");
				xhj = new XHJ(XHJID, XHJName, XHJMDate, XHJIDate, XHJHealth);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return xhj;
	}
	public PageBean selectXHJ(int pageNo, int pageCount, String XHJName) {
		int totalCount = 0;
		List<XHJ> list = new ArrayList<XHJ>();
		String sql = "SELECT * FROM xhj WHERE XHJ_name = '" + XHJName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM xhj WHERE XHJ_name = '" + XHJName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJID = rs.getInt("XHJ_id");
				String actualXHJName = rs.getString("XHJ_name");
				Date XHJMDate = rs.getDate("XHJ_MDate");
				Date XHJIDate = rs.getDate("XHJ_IDate");
				String XHJHealth = rs.getString("XHJ_health");
				xhj = new XHJ(XHJID, actualXHJName, XHJMDate, XHJIDate, XHJHealth);
				list.add(xhj);
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

	public PageBean XHJListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<XHJ> list = new ArrayList<XHJ>();
		String sql = "select * from XHJ limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from XHJ";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJID = rs.getInt("XHJ_id");
				String XHJName = rs.getString("XHJ_name");
				Date XHJMDate = rs.getDate("XHJ_MDate");
				Date XHJIDate = rs.getDate("XHJ_IDate");
				String XHJHealth = rs.getString("XHJ_health");
				xhj = new XHJ(XHJID, XHJName, XHJMDate, XHJIDate, XHJHealth);
				list.add(xhj);
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
