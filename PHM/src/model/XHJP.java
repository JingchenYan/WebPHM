package model;

import java.util.Date;

public class XHJP {
	private int XHJPID;
	private String XHJPName;
	private Date XHJPDate;  //π ’œ»’∆⁄

	public int getXHJPID() {
		return XHJPID;
	}
	public void setXHJPID(int XHJPID) {
		this.XHJPID = XHJPID;
	}
	public String getXHJPName() {
		return XHJPName;
	}
	public void setXHJPName(String XHJPName) {
		this.XHJPName = XHJPName;
	}
	public Date getXHJPDate() {
		return XHJPDate;
	}
	public void setXHJPDate(Date XHJPDate) {
		this.XHJPDate = XHJPDate;
	}

	public XHJP(int XHJPID, String XHJPName, Date XHJPDate) {
		super();
		this.XHJPID = XHJPID;
		this.XHJPName = XHJPName;
		this.XHJPDate = XHJPDate;
	}
	public XHJP() {
		super();
	}
	public XHJP(String XHJPName, Date XHJPDate) {
		super();
		this.XHJPName = XHJPName;
		this.XHJPDate = XHJPDate;
	}
	
	
}
