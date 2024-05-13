package model;

import java.util.Date;

public class XHJF {
	private int XHJFID;
	private String XHJFName;
	private Date XHJFDate;  //故障日期
	private Date XHJRDate;  //维修日期
	private String XHJPop;  //维修人员
	private String XHJFault;  //故障状态


	public int getXHJFID() {
		return XHJFID;
	}
	public void setXHJFID(int XHJFID) {
		this.XHJFID = XHJFID;
	}
	public String getXHJFName() {
		return XHJFName;
	}
	public void setXHJFName(String XHJFName) {
		this.XHJFName = XHJFName;
	}
	public Date getXHJFDate() {
		return XHJFDate;
	}
	public void setXHJFDate(Date XHJFDate) {
		this.XHJFDate = XHJFDate;
	}
	public Date getXHJRDate() {return XHJRDate;}
	public void setXHJRDate(Date XHJRDate) {this.XHJRDate = XHJRDate;}
	public String getXHJPop() {return XHJPop;}
	public void setXHJPop(String XHJPop) {this.XHJPop = XHJPop;}
	public String getXHJFault() {
		return XHJFault;
	}
	public void setXHJFault(String XHJFault) {
		this.XHJFault = XHJFault;
	}

	public XHJF(int XHJFID, String XHJFName, Date XHJFDate, Date XHJRDate, String XHJPop, String XHJFault) {
		super();
		this.XHJFID = XHJFID;
		this.XHJFName = XHJFName;
		this.XHJPop = XHJPop;
		this.XHJRDate = XHJRDate;
		this.XHJFDate = XHJFDate;
		this.XHJFault = XHJFault;
	}
	public XHJF() {
		super();
	}
	public XHJF(String XHJFName, Date XHJFDate, Date XHJRDate, String XHJPop, String XHJFault) {
		super();
		this.XHJFName = XHJFName;
		this.XHJPop = XHJPop;
		this.XHJRDate = XHJRDate;
		this.XHJFDate = XHJFDate;
		this.XHJFault = XHJFault;
	}
	
	
}
