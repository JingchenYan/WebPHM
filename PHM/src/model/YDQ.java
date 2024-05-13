package model;

import java.util.Date;

public class YDQ {
	private int YDQID;
	private String YDQName;
	private Date YDQMDate;  //出厂日期
	private Date YDQIDate;  //安装日期
	private String YDQHealth;  //健康状态


	public int getYDQID() {
		return YDQID;
	}
	public void setYDQID(int YDQID) {
		this.YDQID = YDQID;
	}
	public String getYDQName() {
		return YDQName;
	}
	public void setYDQName(String YDQName) {
		this.YDQName = YDQName;
	}
	public Date getYDQMDate() {
		return YDQMDate;
	}
	public void setYDQMDate(Date YDQMDate) {
		this.YDQMDate = YDQMDate;
	}
	public Date getYDQIDate() {
		return YDQIDate;
	}
	public void setYDQIDate(Date YDQIDate) {
		this.YDQIDate = YDQIDate;
	}
	public String getYDQHealth() {
		return YDQHealth;
	}
	public void setYDQHealth(String YDQHealth) {
		this.YDQHealth = YDQHealth;
	}

	public YDQ(int YDQID, String YDQName, Date YDQMDate, Date YDQIDate, String YDQHealth) {
		super();
		this.YDQID = YDQID;
		this.YDQName = YDQName;
		this.YDQMDate = YDQMDate;
		this.YDQIDate = YDQIDate;
		this.YDQHealth = YDQHealth;
	}
	public YDQ() {
		super();
	}
	public YDQ(String YDQName, Date YDQMDate, Date YDQIDate, String YDQHealth) {
		super();
		this.YDQName = YDQName;
		this.YDQMDate = YDQMDate;
		this.YDQIDate = YDQIDate;
		this.YDQHealth = YDQHealth;
	}
	
	
}
