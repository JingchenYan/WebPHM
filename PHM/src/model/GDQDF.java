package model;

import java.util.Date;

public class GDQDF {
	private int GDQDFID;
	private String GDQDFName;
	private Date GDQDFDate;  //Î¬ÐÞÈÕÆÚ
	private String GDQDFault;  //¹ÊÕÏ×´Ì¬


	public int getGDQDFID() {
		return GDQDFID;
	}
	public void setGDQDFID(int GDQDFID) {
		this.GDQDFID = GDQDFID;
	}
	public String getGDQDFName() {
		return GDQDFName;
	}
	public void setGDQDFName(String GDQDFName) {
		this.GDQDFName = GDQDFName;
	}
	public Date getGDQDFDate() {
		return GDQDFDate;
	}
	public void setGDQDFDate(Date GDQDFDate) {
		this.GDQDFDate = GDQDFDate;
	}
	public String getGDQDFault() {
		return GDQDFault;
	}
	public void setGDQDFault(String GDQDFault) {
		this.GDQDFault = GDQDFault;
	}

	public GDQDF(int GDQDFID, String GDQDFName, Date GDQDFDate, String GDQDFault) {
		super();
		this.GDQDFID = GDQDFID;
		this.GDQDFName = GDQDFName;
		this.GDQDFDate = GDQDFDate;
		this.GDQDFault = GDQDFault;
	}
	public GDQDF() {
		super();
	}
	public GDQDF(String GDQDFName, Date GDQDFDate, String GDQDFault) {
		super();
		this.GDQDFName = GDQDFName;
		this.GDQDFDate = GDQDFDate;
		this.GDQDFault = GDQDFault;
	}
	
	
}
