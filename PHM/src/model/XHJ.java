package model;

import java.util.Date;

public class XHJ {
	private int XHJID;
	private String XHJName;
	private Date XHJMDate;  //��������
	private Date XHJIDate;  //��װ����
	private String XHJHealth;  //����״̬


	public int getXHJID() {
		return XHJID;
	}
	public void setXHJID(int XHJID) {
		this.XHJID = XHJID;
	}
	public String getXHJName() {
		return XHJName;
	}
	public void setXHJName(String XHJName) {
		this.XHJName = XHJName;
	}
	public Date getXHJMDate() {
		return XHJMDate;
	}
	public void setXHJMDate(Date XHJMDate) {
		this.XHJMDate = XHJMDate;
	}
	public Date getXHJIDate() {
		return XHJIDate;
	}
	public void setXHJIDate(Date XHJIDate) {
		this.XHJIDate = XHJIDate;
	}
	public String getXHJHealth() {
		return XHJHealth;
	}
	public void setXHJHealth(String XHJHealth) {
		this.XHJHealth = XHJHealth;
	}

	public XHJ(int XHJID, String XHJName, Date XHJMDate, Date XHJIDate, String XHJHealth) {
		super();
		this.XHJID = XHJID;
		this.XHJName = XHJName;
		this.XHJMDate = XHJMDate;
		this.XHJIDate = XHJIDate;
		this.XHJHealth = XHJHealth;
	}
	public XHJ() {
		super();
	}
	public XHJ(String XHJName, Date XHJMDate, Date XHJIDate, String XHJHealth) {
		super();
		this.XHJName = XHJName;
		this.XHJMDate = XHJMDate;
		this.XHJIDate = XHJIDate;
		this.XHJHealth = XHJHealth;
	}
	
	
}
