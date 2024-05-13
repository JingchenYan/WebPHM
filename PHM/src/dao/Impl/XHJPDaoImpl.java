package dao.Impl;

import dao.XHJPDao;
import db.DBCon;
import model.PageBean;
import model.XHJF;
import model.XHJP;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XHJPDaoImpl implements XHJPDao {

	private DBCon dbCon = new DBCon();
	private XHJP xhjp;
	private PageBean pageBean;

	public int deleteXHJP(int XHJPID) {
		String sql = "delete from XHJP where XHJ_PID=" + XHJPID;
		int rs = dbCon.query(sql);
		return rs;
	}
	public List findAll() {
		List<XHJP> list = new ArrayList<XHJP>();
		String sql = "select * from XHJP";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJPID = rs.getInt("XHJ_PID");
				String XHJPName = rs.getString("XHJ_PName");
				Date XHJPDate = rs.getDate("XHJ_PDate");
				xhjp = new XHJP(XHJPID, XHJPName, XHJPDate);
				list.add(xhjp);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	public PageBean selectXHJP(int pageNo, int pageCount, String XHJPName) {
		int totalCount = 0;
		List<XHJP> list = new ArrayList<XHJP>();
		String sql = "SELECT * FROM xhjp WHERE XHJ_PName = '" + XHJPName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM xhjp WHERE XHJ_PName = '" + XHJPName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJPID = rs.getInt("XHJ_PID");
				Date XHJPDate = rs.getDate("XHJ_PDate");
				xhjp = new XHJP(XHJPID, XHJPName, XHJPDate);
				list.add(xhjp);
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

	public PageBean XHJPListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<XHJP> list = new ArrayList<XHJP>();
		String sql = "select * from XHJP limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from XHJP";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJPID = rs.getInt("XHJ_PID");
				String XHJPName = rs.getString("XHJ_PName");
				Date XHJPDate = rs.getDate("XHJ_PDate");
				xhjp = new XHJP(XHJPID, XHJPName, XHJPDate);
				list.add(xhjp);
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
