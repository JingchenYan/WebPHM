package model;

import java.util.Date;

public class CTCF {
	private int CTCFID;
	private String CTCFName;
	private Date CTCFDate;  //故障日期
	private Date CTCRDate;  //维修日期
	private String CTCPop;  //维修人员
	private String CTCFault;  //故障类型


	public int getCTCFID() {
		return CTCFID;
	}
	public void setCTCFID(int CTCFID) {
		this.CTCFID = CTCFID;
	}
	public String getCTCFName() {
		return CTCFName;
	}
	public void setCTCFName(String CTCFName) {
		this.CTCFName = CTCFName;
	}
	public Date getCTCFDate() {
		return CTCFDate;
	}
	public void setCTCFDate(Date CTCFDate) {
		this.CTCFDate = CTCFDate;
	}
	public Date getCTCRDate() {
		return CTCRDate;
	}
	public void setCTCRDate(Date CTCRDate) {
		this.CTCRDate = CTCRDate;
	}
	public String getCTCPop() {
		return CTCPop;
	}
	public void setCTCPop(String CTCPop) {
		this.CTCPop = CTCPop;
	}

	public String getCTCFault() {
		return CTCFault;
	}
	public void setCTCFault(String CTCFault) {
		this.CTCFault = CTCFault;
	}

	public CTCF(int CTCFID, String CTCFName, Date CTCFDate, Date CTCRDate, String CTCPop, String CTCFault) {
		super();
		this.CTCFID = CTCFID;
		this.CTCFName = CTCFName;
		this.CTCPop = CTCPop;
		this.CTCRDate = CTCRDate;
		this.CTCFDate = CTCFDate;
		this.CTCFault = CTCFault;
	}
	public CTCF() {
		super();
	}
	public CTCF(String CTCFName, Date CTCFDate, Date CTCRDate, String CTCPop, String CTCFault) {
		super();
		this.CTCFName = CTCFName;
		this.CTCPop = CTCPop;
		this.CTCRDate = CTCRDate;
		this.CTCFDate = CTCFDate;
		this.CTCFault = CTCFault;
	}
	
	
}
