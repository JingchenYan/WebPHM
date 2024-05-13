package model;

import java.util.Date;

public class LSXT {
	private int LSXTID;
	private String LSXTName;
	private Date LSXTMDate;  //��������
	private Date LSXTIDate;  //��װ����
	private String LSXTHealth;  //����״̬


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
