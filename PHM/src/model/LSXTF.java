package model;

import java.util.Date;

public class LSXTF {
	private int LSXTFID;
	private String LSXTFName;
	private Date LSXTFDate;  //Î¬ÐÞÈÕÆÚ
	private String LSXTFault;  //¹ÊÕÏ×´Ì¬


	public int getLSXTFID() {
		return LSXTFID;
	}
	public void setLSXTFID(int LSXTFID) {
		this.LSXTFID = LSXTFID;
	}
	public String getLSXTFName() {
		return LSXTFName;
	}
	public void setLSXTFName(String LSXTFName) {
		this.LSXTFName = LSXTFName;
	}
	public Date getLSXTFDate() {
		return LSXTFDate;
	}
	public void setLSXTFDate(Date LSXTFDate) {
		this.LSXTFDate = LSXTFDate;
	}
	public String getLSXTFault() {
		return LSXTFault;
	}
	public void setLSXTFault(String LSXTFault) {
		this.LSXTFault = LSXTFault;
	}

	public LSXTF(int LSXTFID, String LSXTFName, Date LSXTFDate, String LSXTFault) {
		super();
		this.LSXTFID = LSXTFID;
		this.LSXTFName = LSXTFName;
		this.LSXTFDate = LSXTFDate;
		this.LSXTFault = LSXTFault;
	}
	public LSXTF() {
		super();
	}
	public LSXTF(String LSXTFName, Date LSXTFDate, String LSXTFault) {
		super();
		this.LSXTFName = LSXTFName;
		this.LSXTFDate = LSXTFDate;
		this.LSXTFault = LSXTFault;
	}
	
	
}
