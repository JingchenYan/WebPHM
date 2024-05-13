package model;

import java.util.Date;

public class GDQD {
	private int GDQDID;
	private String GDQDName;
	private Date GDQDMDate;  //出厂日期
	private Date GDQDIDate;  //安装日期
	private String GDQDHealth;  //健康状态


	public int getGDQDID() {
		return GDQDID;
	}
	public void setGDQDID(int GDQDID) {
		this.GDQDID = GDQDID;
	}
	public String getGDQDName() {
		return GDQDName;
	}
	public void setGDQDName(String GDQDName) {
		this.GDQDName = GDQDName;
	}
	public Date getGDQDMDate() {
		return GDQDMDate;
	}
	public void setGDQDMDate(Date GDQDMDate) {
		this.GDQDMDate = GDQDMDate;
	}
	public Date getGDQDIDate() {
		return GDQDIDate;
	}
	public void setGDQDIDate(Date GDQDIDate) {
		this.GDQDIDate = GDQDIDate;
	}
	public String getGDQDHealth() {
		return GDQDHealth;
	}
	public void setGDQDHealth(String GDQDHealth) {
		this.GDQDHealth = GDQDHealth;
	}

	public GDQD(int GDQDID, String GDQDName, Date GDQDMDate, Date GDQDIDate, String GDQDHealth) {
		super();
		this.GDQDID = GDQDID;
		this.GDQDName = GDQDName;
		this.GDQDMDate = GDQDMDate;
		this.GDQDIDate = GDQDIDate;
		this.GDQDHealth = GDQDHealth;
	}
	public GDQD() {
		super();
	}
	public GDQD(String GDQDName, Date GDQDMDate, Date GDQDIDate, String GDQDHealth) {
		super();
		this.GDQDName = GDQDName;
		this.GDQDMDate = GDQDMDate;
		this.GDQDIDate = GDQDIDate;
		this.GDQDHealth = GDQDHealth;
	}
	
	
}
