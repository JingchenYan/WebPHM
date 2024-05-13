package model;

import java.util.Date;

public class LSXT {
	private int LSXTID;
	private String LSXTName;
	private Date LSXTMDate;  //出厂日期
	private Date LSXTIDate;  //安装日期
	private String LSXTHealth;  //健康状态


	public int getLSXTID() {
		return LSXTID;
	}
	public void setLSXTID(int LSXTID) {
		this.LSXTID = LSXTID;
	}
	public String getLSXTName() {
		return LSXTName;
	}
	public void setLSXTName(String LSXTName) {
		this.LSXTName = LSXTName;
	}
	public Date getLSXTMDate() {
		return LSXTMDate;
	}
	public void setLSXTMDate(Date LSXTMDate) {
		this.LSXTMDate = LSXTMDate;
	}
	public Date getLSXTIDate() {
		return LSXTIDate;
	}
	public void setLSXTIDate(Date LSXTIDate) {
		this.LSXTIDate = LSXTIDate;
	}
	public String getLSXTHealth() {
		return LSXTHealth;
	}
	public void setLSXTHealth(String LSXTHealth) {
		this.LSXTHealth = LSXTHealth;
	}

	public LSXT(int LSXTID, String LSXTName, Date LSXTMDate, Date LSXTIDate, String LSXTHealth) {
		super();
		this.LSXTID = LSXTID;
		this.LSXTName = LSXTName;
		this.LSXTMDate = LSXTMDate;
		this.LSXTIDate = LSXTIDate;
		this.LSXTHealth = LSXTHealth;
	}
	public LSXT() {
		super();
	}
	public LSXT(String LSXTName, Date LSXTMDate, Date LSXTIDate, String LSXTHealth) {
		super();
		this.LSXTName = LSXTName;
		this.LSXTMDate = LSXTMDate;
		this.LSXTIDate = LSXTIDate;
		this.LSXTHealth = LSXTHealth;
	}
	
	
}
