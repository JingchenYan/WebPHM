package model;

import java.util.Date;

public class DC {
	private int DCID;
	private String DCName;
	private Date DCMDate;  //出厂日期
	private Date DCIDate;  //安装日期
	private String DCHealth;  //健康状态


	public int getDCID() {
		return DCID;
	}
	public void setDCID(int DCID) {
		this.DCID = DCID;
	}
	public String getDCName() {
		return DCName;
	}
	public void setDCName(String DCName) {
		this.DCName = DCName;
	}
	public Date getDCMDate() {
		return DCMDate;
	}
	public void setDCMDate(Date DCMDate) {
		this.DCMDate = DCMDate;
	}
	public Date getDCIDate() {
		return DCIDate;
	}
	public void setDCIDate(Date DCIDate) {
		this.DCIDate = DCIDate;
	}
	public String getDCHealth() {
		return DCHealth;
	}
	public void setDCHealth(String DCHealth) {
		this.DCHealth = DCHealth;
	}

	public DC(int DCID, String DCName, Date DCMDate, Date DCIDate, String DCHealth) {
		super();
		this.DCID = DCID;
		this.DCName = DCName;
		this.DCMDate = DCMDate;
		this.DCIDate = DCIDate;
		this.DCHealth = DCHealth;
	}
	public DC() {
		super();
	}
	public DC(String DCName, Date DCMDate, Date DCIDate, String DCHealth) {
		super();
		this.DCName = DCName;
		this.DCMDate = DCMDate;
		this.DCIDate = DCIDate;
		this.DCHealth = DCHealth;
	}
	
	
}
