package model;

import java.util.Date;

public class YDQF {
	private int YDQFID;
	private String YDQFName;
	private Date YDQFDate;  //Î¬ÐÞÈÕÆÚ
	private String YDQFault;  //¹ÊÕÏ×´Ì¬


	public int getYDQFID() {
		return YDQFID;
	}
	public void setYDQFID(int YDQFID) {
		this.YDQFID = YDQFID;
	}
	public String getYDQFName() {
		return YDQFName;
	}
	public void setYDQFName(String YDQFName) {
		this.YDQFName = YDQFName;
	}
	public Date getYDQFDate() {
		return YDQFDate;
	}
	public void setYDQFDate(Date YDQFDate) {
		this.YDQFDate = YDQFDate;
	}
	public String getYDQFault() {
		return YDQFault;
	}
	public void setYDQFault(String YDQFault) {
		this.YDQFault = YDQFault;
	}

	public YDQF(int YDQFID, String YDQFName, Date YDQFDate, String YDQFault) {
		super();
		this.YDQFID = YDQFID;
		this.YDQFName = YDQFName;
		this.YDQFDate = YDQFDate;
		this.YDQFault = YDQFault;
	}
	public YDQF() {
		super();
	}
	public YDQF(String YDQFName, Date YDQFDate, String YDQFault) {
		super();
		this.YDQFName = YDQFName;
		this.YDQFDate = YDQFDate;
		this.YDQFault = YDQFault;
	}
	
	
}
