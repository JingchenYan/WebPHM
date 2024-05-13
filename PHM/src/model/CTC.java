package model;

import java.util.Date;

public class CTC {
	private int CTCID;
	private String CTCName;
	private Date CTCMDate;  //��������
	private Date CTCIDate;  //��װ����
	private String CTCHealth;  //����״̬


	public int getCTCID() {
		return CTCID;
	}
	public void setCTCID(int CTCID) {
		this.CTCID = CTCID;
	}
	public String getCTCName() {
		return CTCName;
	}
	public void setCTCName(String CTCName) {
		this.CTCName = CTCName;
	}
	public Date getCTCMDate() {
		return CTCMDate;
	}
	public void setCTCMDate(Date CTCMDate) {
		this.CTCMDate = CTCMDate;
	}
	public Date getCTCIDate() {
		return CTCIDate;
	}
	public void setCTCIDate(Date CTCIDate) {
		this.CTCIDate = CTCIDate;
	}
	public String getCTCHealth() {
		return CTCHealth;
	}
	public void setCTCHealth(String CTCHealth) {
		this.CTCHealth = CTCHealth;
	}

	public CTC(int CTCID, String CTCName, Date CTCMDate, Date CTCIDate, String CTCHealth) {
		super();
		this.CTCID = CTCID;
		this.CTCName = CTCName;
		this.CTCMDate = CTCMDate;
		this.CTCIDate = CTCIDate;
		this.CTCHealth = CTCHealth;
	}
	public CTC() {
		super();
	}
	public CTC(String CTCName, Date CTCMDate, Date CTCIDate, String CTCHealth) {
		super();
		this.CTCName = CTCName;
		this.CTCMDate = CTCMDate;
		this.CTCIDate = CTCIDate;
		this.CTCHealth = CTCHealth;
	}
	
	
}
