package dao.Impl;

import dao.XHJFDao;
import db.DBCon;
import model.PageBean;
import model.XHJF;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XHJFDaoImpl implements XHJFDao {

	private DBCon dbCon = new DBCon();
	private XHJF xhjf;
	private PageBean pageBean;

	public int addXHJF(XHJF xhj,String XHJFDate, String XHJRDate) {
		String sql = "insert into XHJF(XHJ_FName,XHJ_FDate,XHJ_RDate,XHJ_Pop,XHJ_Fault) values('"
				+ xhj.getXHJFName() + "', DATE('"
				+ XHJFDate + "'), DATE('"
				+ XHJRDate + "'), '"
				+ xhj.getXHJPop() + "', '"
				+ xhj.getXHJFault() + "')";
		System.out.println("Executing SQL: " + sql); // ¥Ú”°÷¥––µƒSQL£¨∞Ô÷˙’Ô∂œ
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteXHJF(int XHJFID) {
		String sql = "delete from XHJF where XHJ_FID=" + XHJFID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editXHJF(XHJF xhjf,String XHJFDate,String XHJRDate) {
		String sql = "update XHJF set XHJ_FName='" + xhjf.getXHJFName()
				+ "', XHJ_FDate=DATE('" + XHJFDate + "'), XHJ_RDate=DATE('" + XHJRDate + "')"
				+ ", XHJ_Pop='" + xhjf.getXHJPop() + "', XHJ_Fault='" + xhjf.getXHJFault() + "' WHERE XHJ_FID="
				+ xhjf.getXHJFID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<XHJF> list = new ArrayList<XHJF>();
		String sql = "select * from XHJF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJFID = rs.getInt("XHJ_FID");
				String XHJFName = rs.getString("XHJ_FName");
				Date XHJFDate = rs.getDate("XHJ_FDate");
				Date XHJRDate = rs.getDate("XHJ_RDate");
				String XHJPop = rs.getString("XHJ_Pop");
				String XHJFault = rs.getString("XHJ_Fault");
				xhjf = new XHJF(XHJFID, XHJFName, XHJFDate, XHJRDate, XHJPop, XHJFault);
				list.add(xhjf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int XHJFID) {
		List<XHJF> list = new ArrayList<XHJF>();
		String sql = "select * from XHJF where XHJ_FID=" + XHJFID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				String XHJFName = rs.getString("XHJ_FName");
				Date XHJFDate = rs.getDate("XHJ_FDate");
				Date XHJRDate = rs.getDate("XHJ_RDate");
				String XHJPop = rs.getString("XHJ_Pop");
				String XHJFault = rs.getString("XHJ_Fault");
				xhjf = new XHJF(XHJFID, XHJFName, XHJFDate, XHJRDate, XHJPop, XHJFault);
				list.add(xhjf);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public XHJF selectOneXHJF(XHJF xhjf1) {
		String sql = "select * from XHJF where XHJ_FName='"
				+ xhjf1.getXHJFName()+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJFID = rs.getInt("XHJ_FID");
				String XHJFName = rs.getString("XHJ_FName");
				Date XHJFDate = rs.getDate("XHJ_FDate");
				Date XHJRDate = rs.getDate("XHJ_RDate");
				String XHJPop = rs.getString("XHJ_Pop");
				String XHJFault = rs.getString("XHJ_Fault");
				xhjf = new XHJF(XHJFID, XHJFName, XHJFDate, XHJRDate, XHJPop, XHJFault);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return xhjf;
	}
	public PageBean selectXHJF(int pageNo, int pageCount, String XHJFName) {
		int totalCount = 0;
		List<XHJF> list = new ArrayList<XHJF>();
		String sql = "SELECT * FROM xhjf WHERE XHJ_FName = '" + XHJFName + "' LIMIT " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "SELECT COUNT(*) FROM xhjf WHERE XHJ_FName = '" + XHJFName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJFID = rs.getInt("XHJ_FID");
				String actualXHJFName = rs.getString("XHJ_FName");
				Date XHJFDate = rs.getDate("XHJ_FDate");
				Date XHJRDate = rs.getDate("XHJ_RDate");
				String XHJPop = rs.getString("XHJ_Pop");
				String XHJFault = rs.getString("XHJ_Fault");
				xhjf = new XHJF(XHJFID, actualXHJFName, XHJFDate, XHJRDate, XHJPop, XHJFault);
				list.add(xhjf);
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

	public PageBean XHJFListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<XHJF> list = new ArrayList<XHJF>();
		String sql = "select * from XHJF limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from XHJF";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int XHJFID = rs.getInt("XHJ_FID");
				String XHJFName = rs.getString("XHJ_FName");
				Date XHJFDate = rs.getDate("XHJ_FDate");
				Date XHJRDate = rs.getDate("XHJ_RDate");
				String XHJPop = rs.getString("XHJ_Pop");
				String XHJFault = rs.getString("XHJ_Fault");
				xhjf = new XHJF(XHJFID, XHJFName, XHJFDate, XHJRDate, XHJPop, XHJFault);
				list.add(xhjf);
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
