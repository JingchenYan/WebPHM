package model;

import java.util.Date;

public class DCF {
	private int DCFID;
	private String DCFName;
	private Date DCFDate;  //Î¬ÐÞÈÕÆÚ
	private String DCFault;  //¹ÊÕÏ×´Ì¬


	public int getDCFID() {
		return DCFID;
	}
	public void setDCFID(int DCFID) {
		this.DCFID = DCFID;
	}
	public String getDCFName() {
		return DCFName;
	}
	public void setDCFName(String DCFName) {
		this.DCFName = DCFName;
	}
	public Date getDCFDate() {
		return DCFDate;
	}
	public void setDCFDate(Date DCFDate) {
		this.DCFDate = DCFDate;
	}
	public String getDCFault() {
		return DCFault;
	}
	public void setDCFault(String DCFault) {
		this.DCFault = DCFault;
	}

	public DCF(int DCFID, String DCFName, Date DCFDate, String DCFault) {
		super();
		this.DCFID = DCFID;
		this.DCFName = DCFName;
		this.DCFDate = DCFDate;
		this.DCFault = DCFault;
	}
	public DCF() {
		super();
	}
	public DCF(String DCFName, Date DCFDate, String DCFault) {
		super();
		this.DCFName = DCFName;
		this.DCFDate = DCFDate;
		this.DCFault = DCFault;
	}
	
	
}
